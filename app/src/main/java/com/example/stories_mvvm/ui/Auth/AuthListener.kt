package com.example.stories_mvvm.ui.Auth

import com.example.stories_mvvm.data.entity.db.User

interface AuthListener {
    fun onStarted(message : String)
    fun onSuccess(user : User)
    fun onFailure(message: String)

}