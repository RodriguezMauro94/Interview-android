package com.rodriguezmauro.interviewsandroid.di

import com.rodriguezmauro.interviewsandroid.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Nivel aplicación
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://type.fit/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}
