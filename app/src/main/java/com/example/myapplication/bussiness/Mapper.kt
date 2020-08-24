package com.example.myapplication.bussiness

import com.example.myapplication.bussiness.model.User
import com.example.myapplication.data.model.RandomUser

interface Mapper {
    fun randomUser(randomUser: RandomUser): User?
}
