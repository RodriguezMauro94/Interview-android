package com.rodriguezmauro.interviewsandroid.data

import com.rodriguezmauro.interviewsandroid.data.database.dao.QuoteDao
import com.rodriguezmauro.interviewsandroid.data.database.entities.QuoteEntity
import com.rodriguezmauro.interviewsandroid.data.network.QuoteService
import com.rodriguezmauro.interviewsandroid.domain.model.Quote
import com.rodriguezmauro.interviewsandroid.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        return api.getQuote().map {
            it.toDomain()
        }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        return quoteDao.getAllQuotes().map {
            it.toDomain()
        }
    }
    
    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }
    
    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}