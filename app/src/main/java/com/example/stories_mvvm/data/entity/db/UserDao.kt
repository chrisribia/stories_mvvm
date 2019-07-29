package com.example.stories_mvvm.data.entity.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.stories_mvvm.data.entity.db.CURRENT_USER_ID
import com.example.stories_mvvm.data.entity.db.User


@Dao
interface  UserDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user : User): Long

    @Query("SELECT * FROM user WHERE uid =$CURRENT_USER_ID ")
     fun getUser() : LiveData<User>

}