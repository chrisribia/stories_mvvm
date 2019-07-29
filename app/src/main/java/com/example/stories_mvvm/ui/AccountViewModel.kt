package com.example.stories_mvvm.ui

import androidx.lifecycle.ViewModel;
import com.example.stories_mvvm.data.repository.UserRepository

class AccountViewModel(
      repository : UserRepository
) : ViewModel() {
    val user = repository.getUser()

}
