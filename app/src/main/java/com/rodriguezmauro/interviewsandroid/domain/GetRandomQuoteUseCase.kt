package com.rodriguezmauro.interviewsandroid.domain

import com.rodriguezmauro.interviewsandroid.data.QuoteRepository
import com.rodriguezmauro.interviewsandroid.data.model.QuoteModel
import com.rodriguezmauro.interviewsandroid.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    val repository = QuoteRepository()

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            return quotes.random()
        }
        return null
    }
}