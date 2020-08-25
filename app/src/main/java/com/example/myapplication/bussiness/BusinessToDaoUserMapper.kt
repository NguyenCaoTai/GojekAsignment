package com.example.myapplication.bussiness

import com.example.myapplication.bussiness.model.User
import com.example.myapplication.data.local.model.Location
import com.example.myapplication.data.local.model.Name

class BusinessUserToDaoMapper : Mapper<User, com.example.myapplication.data.local.model.User> {
    override fun transform(input: User): com.example.myapplication.data.local.model.User =
        input
            .let {
                com.example.myapplication.data.local.model.User(
                    ssn = it.ssn,
                    name = Name(
                        first = it.name.first,
                        last = it.name.last,
                        title = it.name.title
                    ),
                    location = Location(
                        street = it.location.street,
                        city = it.location.city,
                        state = it.location.state,
                        zip = it.location.zip
                    ),
                    picture = it.picture,
                    phone = it.phone,
                    dateOfBirth = it.dateOfBirth
                )
            }
}