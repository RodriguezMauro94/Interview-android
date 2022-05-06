package com.rodriguezmauro.interviewsandroid.data

import com.rodriguezmauro.interviewsandroid.data.model.QuoteModel
import com.rodriguezmauro.interviewsandroid.data.model.QuoteProvider
import com.rodriguezmauro.interviewsandroid.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
) {
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuote()
        quoteProvider.quotes = response
        return response
    }
}