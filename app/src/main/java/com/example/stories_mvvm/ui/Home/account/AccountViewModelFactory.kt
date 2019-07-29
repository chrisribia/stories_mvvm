package com.example.stories_mvvm.ui.Home.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stories_mvvm.data.repository.UserRepository
import com.example.stories_mvvm.ui.AccountViewModel

@Suppress("UNCHECKED_CAST")
class AccountViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AccountViewModel(repository) as T
    }
}