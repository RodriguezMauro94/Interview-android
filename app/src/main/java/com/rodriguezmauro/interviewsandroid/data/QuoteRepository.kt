package com.rodriguezmauro.interviewsandroid.data

import com.rodriguezmauro.interviewsandroid.data.model.QuoteModel
import com.rodriguezmauro.interviewsandroid.data.model.QuoteProvider
import com.rodriguezmauro.interviewsandroid.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuote()
        QuoteProvider.quotes = response
        return response
    }
}