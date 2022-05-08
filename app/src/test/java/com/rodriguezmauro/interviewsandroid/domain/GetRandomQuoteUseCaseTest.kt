package com.rodriguezmauro.interviewsandroid.domain

import com.rodriguezmauro.interviewsandroid.data.QuoteRepository
import com.rodriguezmauro.interviewsandroid.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetRandomQuoteUseCaseTest {
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when the database doesn't returns anything return null`() = runBlocking {
        // Given
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()

        // When
        val response = getRandomQuoteUseCase()

        // Then
        assert(response == null)
    }

    @Test
    fun `when the database is empty return quote`() = runBlocking {
        // Given
        val quotes = listOf(Quote("mock quote", "mock author"))
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns quotes

        // When
        val response = getRandomQuoteUseCase()

        // Then
        assert(response == quotes.first())
    }
}
