package com.example.stories_mvvm.ui.Home.stories

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


    }
}