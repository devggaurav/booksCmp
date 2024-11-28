package com.kmm.books.book.presentation.book_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.kmm.books.app.Route
import com.kmm.books.book.domain.BookRepository
import com.kmm.books.core.domain.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


//
// Created by Code For Android on 26/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class BookDetailsViewModel(
    private val bookRepository: BookRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val bookId = savedStateHandle.toRoute<Route.BookDetail>().id
    private val _state = MutableStateFlow(BookDetailsState())
    val state = _state.onStart {
        fetchBookDescription()
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        _state.value
    )


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


    private fun fetchBookDescription() {
        viewModelScope.launch {

            bookRepository.getBookDescription(bookId).onSuccess { description ->
                _state.update {
                    it.copy(
                        book = it.book?.copy(description = description),
                        isLoading = false
                    )
                }
            }

        }

    }

}