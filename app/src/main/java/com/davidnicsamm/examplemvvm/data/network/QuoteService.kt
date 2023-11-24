package com.davidnicsamm.examplemvvm.data.network

import com.davidnicsamm.examplemvvm.core.RetrofitHelper
import com.davidnicsamm.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{

        // Ejecutar en hilo secundario
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApliClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}