package com.rodriguezmauro.interviewsandroid.domain

import com.rodriguezmauro.interviewsandroid.data.model.QuoteModel
import com.rodriguezmauro.interviewsandroid.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
) {
    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            return quotes.random()
        }
        return null
    }
}