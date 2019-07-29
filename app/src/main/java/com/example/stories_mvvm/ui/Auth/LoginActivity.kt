package com.example.stories_mvvm.ui.Auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.stories_mvvm.R
import com.example.stories_mvvm.data.entity.db.User
import com.example.stories_mvvm.data.repository.UserRepository
import com.example.stories_mvvm.databinding.ActivityLoginBinding
import com.example.stories_mvvm.ui.AuthViewModel
import com.example.stories_mvvm.ui.Home.HomeActivity
import com.example.stories_mvvm.utils.toast
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(),AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if(user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })

    }

    override fun onStarted(message: String) {
        toast(message)
    }

    override fun onSuccess(user: User) {

    }

    override fun onFailure(message: String) {
        toast(message)
    }
}
