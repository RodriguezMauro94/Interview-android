package com.rodriguezmauro.interviewsandroid.domain

import com.rodriguezmauro.interviewsandroid.data.QuoteRepository
import com.rodriguezmauro.interviewsandroid.data.model.QuoteModel

class GetQuotesUseCase {
    private  val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? {
        return repository.getAllQuotes()
    }
}