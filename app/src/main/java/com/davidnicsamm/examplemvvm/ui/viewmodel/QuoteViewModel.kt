package com.davidnicsamm.examplemvvm.ui.viewmodel

import android.app.appsearch.GetByDocumentIdRequest
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidnicsamm.examplemvvm.data.model.QuoteModel
import com.davidnicsamm.examplemvvm.data.model.QuoteProvider
import com.davidnicsamm.examplemvvm.domain.GetQuotesUseCase
import com.davidnicsamm.examplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()
    fun onCreate() {
        // Ejecutar una corrutina
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)

        val quote = getRandomQuoteUseCase()
        if(quote != null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }




}