package com.example.stories_mvvm.ui

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.stories_mvvm.data.repository.UserRepository
import com.example.stories_mvvm.ui.Auth.AuthListener
import com.example.stories_mvvm.utils.ApiException
import com.example.stories_mvvm.utils.Coroutines
import com.example.stories_mvvm.utils.NoInternetException

class AuthViewModel(
    val repository: UserRepository
) : ViewModel(){

    var email : String? = null
    var password : String? = null
    var authListener: AuthListener? = null
    fun getLoggedInUser() = repository.getUser()

    fun onLoginBtn(view : View){
        authListener?.onStarted("started")
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("please enter email or password")
            return
        }

        Coroutines.main {
            try {
               val authResponse = repository.userLogin(email!!,password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }

            }
            catch (e : ApiException){
                authListener?.onFailure(e.message!!)
            }
            catch (e: NoInternetException){
                authListener?.onFailure(e.message!!)
            }
        }




    }

}
