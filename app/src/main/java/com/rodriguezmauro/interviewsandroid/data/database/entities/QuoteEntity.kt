package com.rodriguezmauro.interviewsandroid.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rodriguezmauro.interviewsandroid.domain.model.Quote

@Entity(tableName = "quote_table")
data class QuoteEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "text") val quote: String,
    @ColumnInfo(name = "author") val author: String?
)

fun Quote.toDatabase() = QuoteEntity(quote = quote, author = author)