package com.example.myapplication.bussiness

import com.example.myapplication.bussiness.model.Location
import com.example.myapplication.bussiness.model.Name
import com.example.myapplication.bussiness.model.User

class DaoToBusinessUserMapper : Mapper<com.example.myapplication.data.local.model.User, User> {
    override fun transform(input: com.example.myapplication.data.local.model.User): User =
        input
            .let {
                User(
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