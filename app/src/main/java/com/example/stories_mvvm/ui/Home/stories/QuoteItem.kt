package com.example.stories_mvvm.ui.Home.stories

import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.stories_mvvm.R
import com.example.stories_mvvm.data.entity.db.Quote
import com.example.stories_mvvm.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote

) : BindableItem<ItemQuoteBinding>(){


    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)

        viewBinding.root.setOnClickListener{
//        it.context.toast(quote.author + " " + quote.quote  )
//            val mQuote =  quote.id.toString()
//            it.context.toast( mQuote)mQuote
            val action = StoriesFragmentDirections.actionDetails(quote)
            Navigation.findNavController(it).navigate(action)






        }

    }



}