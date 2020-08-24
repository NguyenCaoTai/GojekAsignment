package com.example.myapplication.bussiness

import com.example.myapplication.bussiness.model.User
import org.json.JSONObject

interface Mapper {
    fun randomUser(resp: String): User
}
