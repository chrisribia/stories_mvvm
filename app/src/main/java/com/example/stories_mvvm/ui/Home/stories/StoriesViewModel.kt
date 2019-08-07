package com.example.stories_mvvm.ui.Home.stories

import androidx.lifecycle.ViewModel;
import com.example.stories_mvvm.data.repository.QuotesRepository
import com.example.stories_mvvm.utils.lazyDeferred


class StoriesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }


}
