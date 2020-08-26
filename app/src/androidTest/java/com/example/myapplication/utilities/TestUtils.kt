package com.example.myapplication.utilities

import com.example.myapplication.data.local.model.Location
import com.example.myapplication.data.local.model.Name
import com.example.myapplication.data.local.model.User

object TestUtils {
    val userOriginal = User(
        name = Name(
            title = "mr",
            first = "enrique",
            last = "romero"
        ),
        location = Location(
            street = "3451 china ave",
            city = "lancaster",
            state = "california",
            zip = "19040"
        ),
        ssn = "322-31-7447",
        dateOfBirth = 200337769,
        phone = "(818)-127-3982",
        picture = "https://api.randomuser.me/portraits/men/5.jpg"
    )

    /**
     * [User] objects used for tests.
     */
    val testUsers = arrayListOf(
        userOriginal,
        userOriginal.copy(
            ssn = "322-31-1111", name = Name(
                title = "mr",
                first = "ruger",
                last = "hardock"
            )
        ),
        userOriginal.copy(
            ssn = "322-31-2222", name = Name(
                title = "ms",
                first = "best",
                last = "beautiful"
            )
        )
    )
}