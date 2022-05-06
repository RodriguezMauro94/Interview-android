package com.rodriguezmauro.interviewsandroid.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodriguezmauro.interviewsandroid.data.model.QuoteModel
import com.rodriguezmauro.interviewsandroid.domain.GetQuotesUseCase
import com.rodriguezmauro.interviewsandroid.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()
    val getQuotesUseCase = GetQuotesUseCase()
    val getRandomQuoteUseCategory = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                isLoading.postValue(false)
                quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val randomQuote = getRandomQuoteUseCategory()
            isLoading.postValue(false)
            quoteModel.postValue(randomQuote!!)
        }
    }
}
