package com.davidnicsamm.examplemvvm

import com.davidnicsamm.examplemvvm.data.model.QuoteModel
import com.davidnicsamm.examplemvvm.data.model.QuoteProvider
import com.davidnicsamm.examplemvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}