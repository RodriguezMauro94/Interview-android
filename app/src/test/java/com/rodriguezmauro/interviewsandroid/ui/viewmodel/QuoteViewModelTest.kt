package com.rodriguezmauro.interviewsandroid.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rodriguezmauro.interviewsandroid.domain.GetQuotesUseCase
import com.rodriguezmauro.interviewsandroid.domain.GetRandomQuoteUseCase
import com.rodriguezmauro.interviewsandroid.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class QuoteViewModelTest {
    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase
    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    private lateinit var quoteViewModel: QuoteViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomQuoteUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewModel is created at the first time, get all quotes and set the first value`() = runTest {
        // Given
        val quotes = listOf(Quote("mock quote 1", "mock author 1"), Quote("mock quote 2", "mock author 2"))
        coEvery { getQuotesUseCase() } returns quotes

        // When
        quoteViewModel.onCreate()

        // Then
        assert(quoteViewModel.quoteModel.value == quotes.first())
    }

    @Test
    fun `when randomQuoteUseCase return a quote set on the liveData`() = runTest {
        // Given
        val quote = Quote("mock quote", "mock author")
        coEvery { getRandomQuoteUseCase() } returns quote

        // When
        quoteViewModel.randomQuote()

        // Then
        assert(quoteViewModel.quoteModel.value == quote)
    }
}
