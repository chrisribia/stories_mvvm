package com.example.stories_mvvm.data.network.responses

import com.example.stories_mvvm.data.entity.db.Quote

data class QuoteResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)