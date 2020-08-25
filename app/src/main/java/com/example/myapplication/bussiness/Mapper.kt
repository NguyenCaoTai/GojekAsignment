package com.example.myapplication.bussiness

import com.example.myapplication.bussiness.model.User

interface Mapper<in I, out O> {
    fun transform(input: I): O
}
