package com.example.stories_mvvm

import android.app.Application
import com.example.stories_mvvm.data.entity.AppDataBase
import com.example.stories_mvvm.data.entity.preferences.PreferenceProvider
import com.example.stories_mvvm.data.network.MyApi
import com.example.stories_mvvm.data.network.NetworkConnectionInterceptor
import com.example.stories_mvvm.data.repository.QuotesRepository
import com.example.stories_mvvm.data.repository.UserRepository
import com.example.stories_mvvm.ui.AccountViewModel
import com.example.stories_mvvm.ui.Auth.AuthViewModelFactory
import com.example.stories_mvvm.ui.Home.account.AccountViewModelFactory
import com.example.stories_mvvm.ui.Home.stories.StoriesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDataBase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }

        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { AccountViewModelFactory(instance()) }
        bind() from provider{ StoriesViewModelFactory(instance()) }





    }

}