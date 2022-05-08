package com.rodriguezmauro.interviewsandroid.domain

import com.rodriguezmauro.interviewsandroid.data.QuoteRepository
import com.rodriguezmauro.interviewsandroid.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            return quotes.random()
        }
        return null
    }
}