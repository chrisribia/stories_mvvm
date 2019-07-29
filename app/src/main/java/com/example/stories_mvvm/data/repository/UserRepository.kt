package com.example.stories_mvvm.data.repository

import com.example.stories_mvvm.data.entity.AppDataBase
import com.example.stories_mvvm.data.entity.db.User
import com.example.stories_mvvm.data.network.MyApi
import com.example.stories_mvvm.data.network.SafeApiRequest
import com.example.stories_mvvm.data.network.responses.AuthResponse

class UserRepository(
    val api : MyApi,
    val db : AppDataBase
): SafeApiRequest() {
    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun saveUser(user : User) = db.getUserDao().upsert(user)

     fun getUser() = db.getUserDao().getUser()

}