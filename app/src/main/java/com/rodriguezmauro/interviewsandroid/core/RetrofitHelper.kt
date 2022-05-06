package com.rodriguezmauro.interviewsandroid.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://type.fit/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
