package com.example.myapplication.bussiness.model

data class User(
    val name: Name,
    val location: Location,
    val phone: String,
    val picture: String,
    val dateOfBirth: Long
)