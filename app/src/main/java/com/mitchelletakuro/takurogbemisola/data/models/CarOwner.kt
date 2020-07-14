package com.mitchelletakuro.takurogbemisola.data.models

data class CarOwner(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val email: String,
        val gender: String,
        val carModel: String,
        val carModelYear: Int,
        val carColor:String,
        val country: String,
        val jobTitle: String,
        val biography: String
)