package com.rodriguezmauro.interviewsandroid.domain

import com.rodriguezmauro.interviewsandroid.data.QuoteRepository
import com.rodriguezmauro.interviewsandroid.data.database.entities.toDatabase
import com.rodriguezmauro.interviewsandroid.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetQuotesUseCaseTest {
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getQuotesUseCase: GetQuotesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    @Test
    fun `when the api doesn't returns anything then getValuesFromDatabase`() = runBlocking {
        // Given
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()

        // When
        getQuotesUseCase()

        // Then
        coVerify(exactly = 1) {
            quoteRepository.getAllQuotesFromDatabase()
        }
    }

    @Test
    fun `when the api returns quotes then insertQuotes`() = runBlocking {
        // Given
        val quotes = listOf(Quote("mock quote", "mock author"))
        coEvery { quoteRepository.getAllQuotesFromApi() } returns quotes

        // When
        val response = getQuotesUseCase()

        // Then
        coVerify(exactly = 1) {
            quoteRepository.clearQuotes()
            quoteRepository.insertQuotes(eq(quotes.map { it.toDatabase() }))
            assertEquals(quotes, response)
        }
        coVerify(exactly = 0) {
            quoteRepository.getAllQuotesFromDatabase()
        }
    }
}
