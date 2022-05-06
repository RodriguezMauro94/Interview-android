package com.rodriguezmauro.interviewsandroid.domain

import com.rodriguezmauro.interviewsandroid.data.QuoteRepository
import com.rodriguezmauro.interviewsandroid.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<QuoteModel>? {
        return repository.getAllQuotes()
    }
}