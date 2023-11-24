package com.davidnicsamm.examplemvvm.data.network

import com.davidnicsamm.examplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApliClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}