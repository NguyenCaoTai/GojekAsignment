package com.example.myapplication.bussiness

import com.example.myapplication.bussiness.model.Location
import com.example.myapplication.bussiness.model.Name
import com.example.myapplication.bussiness.model.User
import com.example.myapplication.data.model.RandomUser
import java.lang.IllegalArgumentException

class MapperImpl : Mapper {
    override fun randomUser(randomUser: RandomUser): User? = randomUser
        .takeIf { it.results.isNotEmpty() }
        ?.let { it.results[0].user }
        ?.let {
            User(
                name = Name(it.name.title, it.name.first, it.name.last),
                location = Location(
                    it.location.street,
                    it.location.city,
                    it.location.state,
                    it.location.zip
                ),
                dateOfBirth = it.dob.toLong(),
                phone = it.phone,
                picture = it.picture
            )
        } ?: throw IllegalArgumentException("Illegal")
}