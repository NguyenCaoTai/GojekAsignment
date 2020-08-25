package com.example.myapplication.bussiness

import com.example.myapplication.bussiness.model.User
import com.example.myapplication.data.Service
import com.example.myapplication.data.local.UserDao
import com.example.myapplication.model.Either
import com.example.myapplication.model.Error
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.lang.IllegalArgumentException

class RepositoryImpl(
    private val service: Service,
    private val dao: UserDao,
    private val randomUserMapper: Mapper<String, User>,
    private val businessUserToDaoMapper: Mapper<User, com.example.myapplication.data.local.model.User>,
    private val daoToBusinessUserMapper: Mapper<com.example.myapplication.data.local.model.User, User>
) : Repository {
    override suspend fun getRandomUser(): Either<Error, User> =
        withContext(Dispatchers.IO) {
            service.random()
                .execute()
                .let {
                    when (it.isSuccessful) {
                        false -> Either.Left(Error(it.message()))
                        else -> when (it.body()) {
                            null -> Either.Left<Error, User>(Error("Data is empty"))
                            else -> try {
                                Either.Right<Error, User>(
                                    randomUserMapper.transform(
                                        it.body()!!.string()
                                    )
                                )
                            } catch (ex: IllegalArgumentException) {
                                Either.Left<Error, User>(Error("Data is empty"))
                            }
                        }
                    }
                }
        }

    override suspend fun addFavoriteUser(user: User): Either<Error, Unit> =
        try {
            dao.insertAll(businessUserToDaoMapper.transform(user))
            Either.Right<Error, Unit>(Unit)
        } catch (ex: Exception) {
            Either.Left<Error, Unit>(Error("Insert failed"))
        }

    override suspend fun getAllFavoriteUser(): Either<Error, List<User>> =
        withContext(Dispatchers.IO) {
            try {
                Either.Right<Error, List<User>>(
                    dao.getAll()
                        .map { daoToBusinessUserMapper.transform(it) }
                )
            } catch (ex: Exception) {
                Either.Left<Error, List<User>>(Error(ex.message ?: "Get favorite user failed"))
            }
        }
}