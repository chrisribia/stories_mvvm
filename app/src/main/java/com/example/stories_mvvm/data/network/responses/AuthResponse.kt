package com.example.stories_mvvm.data.network.responses

import com.example.stories_mvvm.data.entity.db.User

data class AuthResponse(
    val isSuccessful : Boolean,
    val message : String,
    val user : User
    )