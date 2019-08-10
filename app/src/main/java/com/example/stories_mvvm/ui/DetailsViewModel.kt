package com.example.stories_mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stories_mvvm.data.entity.db.Quote
import com.example.stories_mvvm.data.repository.QuotesRepository


class DetailsViewModel(
    private val repository: QuotesRepository
 ) : ViewModel() {


    private var _currentQuote= MutableLiveData<Quote>()


    val currentEmployee: LiveData<Quote>
        get() = _currentQuote



    fun findEmployee(id: Int): LiveData<Quote> {
        val employee = repository.findEmployee(id)
        employee.observeForever {
            _currentQuote.postValue(it)
        }
        return employee
    }


}



