package com.rodriguezmauro.interviewsandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rodriguezmauro.interviewsandroid.model.QuoteModel
import com.rodriguezmauro.interviewsandroid.model.QuoteProvider

class QuoteViewModel: ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}
