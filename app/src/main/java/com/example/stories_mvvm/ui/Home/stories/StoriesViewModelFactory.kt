package com.example.stories_mvvm.ui.Home.stories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stories_mvvm.data.repository.QuotesRepository

@Suppress("UNCHECKED_CAST")
class StoriesViewModelFactory(
    private val repository: QuotesRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StoriesViewModel(repository) as T
    }
}