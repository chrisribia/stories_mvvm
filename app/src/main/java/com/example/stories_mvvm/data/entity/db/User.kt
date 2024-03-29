package com.example.stories_mvvm.data.entity.db

import androidx.room.Entity
import androidx.room.PrimaryKey


const val CURRENT_USER_ID = 0
@Entity
data class User(
    var name : String? = null,
    var email: String? = null,
    var password: String? = null

){
    @PrimaryKey(autoGenerate = false)
    var uid : Int? = CURRENT_USER_ID
}
