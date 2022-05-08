package com.rodriguezmauro.interviewsandroid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rodriguezmauro.interviewsandroid.data.database.dao.QuoteDao
import com.rodriguezmauro.interviewsandroid.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}