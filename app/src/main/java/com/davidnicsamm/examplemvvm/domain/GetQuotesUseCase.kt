package com.davidnicsamm.examplemvvm.domain

import com.davidnicsamm.examplemvvm.QuoteRepository
import com.davidnicsamm.examplemvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}