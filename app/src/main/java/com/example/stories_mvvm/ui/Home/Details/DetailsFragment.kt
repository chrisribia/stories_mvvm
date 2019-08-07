package com.example.stories_mvvm.ui.Home.Details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.stories_mvvm.R
import com.example.stories_mvvm.data.entity.db.Quote
import com.example.stories_mvvm.ui.DetailsViewModel
import kotlinx.android.synthetic.main.details_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class DetailsFragment : Fragment(),KodeinAware {

    override val kodein by kodein()

    private val factory: DetailsViewModelFactory by instance()

    private lateinit var viewModel: DetailsViewModel


    private var quote : Quote? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,factory).get(DetailsViewModel::class.java)


        arguments?.let {
            quote = DetailsFragmentArgs.fromBundle(it).quote


            Glide
                .with(this)
                .load(quote!!.thumbnail)
                .centerCrop()
//                .placeholder(R.drawable.loading_spinner)
                .into(imageview)
            mquote.setText(quote!!.author)
            author.setText(quote!!.quote)
        }
    }

}
