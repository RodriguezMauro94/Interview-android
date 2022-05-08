package com.rodriguezmauro.interviewsandroid.domain.model

import com.rodriguezmauro.interviewsandroid.data.database.entities.QuoteEntity
import com.rodriguezmauro.interviewsandroid.data.model.QuoteModel

data class Quote(val quote: String, val author: String?)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)