package com.rodriguezmauro.interviewsandroid.data.network

import com.rodriguezmauro.interviewsandroid.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("quotes")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}