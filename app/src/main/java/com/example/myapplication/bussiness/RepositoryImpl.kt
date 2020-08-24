package com.example.myapplication.bussiness

import com.example.myapplication.bussiness.model.User
import com.example.myapplication.data.Service
import com.example.myapplication.model.Either
import com.example.myapplication.model.Error
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.IllegalArgumentException

class RepositoryImpl(
    private val service: Service,
    private val mapper: Mapper
) : Repository {
    override suspend fun getRandomUser(): Either<Error, User> = withContext(Dispatchers.IO) {
        service.random()
            .execute()
            .let {
                when (it.isSuccessful) {
                    false -> Either.Left(Error(it.message()))
                    else -> when (it.body()) {
                        null -> Either.Left<Error, User>(Error("Data is empty"))
                        else -> try {
                            Either.Right<Error, User>(mapper.randomUser(it.body()!!.string()))
                        } catch (ex: IllegalArgumentException) {
                            Either.Left<Error, User>(Error("Data is empty"))
                        }
                    }
                }
            }
    }
}