package com.example.stories_mvvm.data.entity

import android.content.Context
import androidx.room.*
import com.example.stories_mvvm.data.entity.db.Quote
import com.example.stories_mvvm.data.entity.db.QuoteDao
import com.example.stories_mvvm.data.entity.db.User
import com.example.stories_mvvm.data.entity.db.UserDao

@Database(
    entities = [User::class,Quote::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase(){
    abstract fun getUserDao() : UserDao
    abstract fun getQuoteDao() : QuoteDao
companion object {
    @Volatile
    private var instance: AppDataBase? = null
    private val LOCK = Any()


    operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
        instance ?: buildDatabase(context).also {
            instance = it
        }
    }

    private fun buildDatabase(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            "MyDatabase.db"
        ).build()
}
}