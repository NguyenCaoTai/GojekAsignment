package com.example.myapplication.bussiness

import com.example.myapplication.bussiness.model.User
import com.example.myapplication.model.Either
import com.example.myapplication.model.Error

interface Repository {
    suspend fun getRandomUser(): Either<Error, User>
}