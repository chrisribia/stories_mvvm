package com.example.stories_mvvm.ui.Home.account

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.stories_mvvm.R
import com.example.stories_mvvm.databinding.AccountFragmentBinding
import com.example.stories_mvvm.ui.AccountViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class AccountFragment : Fragment(), KodeinAware {
    override val kodein by kodein()
    private lateinit var viewModel : AccountViewModel
    private val factory: AccountViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : AccountFragmentBinding =
            DataBindingUtil.inflate(inflater,R.layout.account_fragment,container,false)
         viewModel = ViewModelProviders.of(this,factory).get(AccountViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }



}
