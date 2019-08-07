package com.example.stories_mvvm.ui.Home.Details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stories_mvvm.data.repository.QuotesRepository
import com.example.stories_mvvm.ui.DetailsViewModel


@Suppress("UNCHECKED_CAST")
class DetailsViewModelFactory(
    private val repository: QuotesRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailsViewModel(repository) as T
    }
}