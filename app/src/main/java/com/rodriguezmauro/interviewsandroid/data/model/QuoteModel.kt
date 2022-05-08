package com.rodriguezmauro.interviewsandroid.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel(@SerializedName("text") val quote: String, val author: String?)