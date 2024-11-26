package com.kmm.books.book.presentation.book_details

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


//
// Created by Code For Android on 26/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class BookDetailsViewModel : ViewModel() {

    private val _state = MutableStateFlow(BookDetailsState())
    val state = _state.asStateFlow()


    fun onAction(action: BookDetailsAction) {
        when (action) {
            is BookDetailsAction.OnSelectedBookChange -> {
                _state.update {
                    it.copy(
                        book = action.book
                    )
                }

            }
            else -> Unit
        }
    }

}