package com.kmm.books.book.presentation.book_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmm.books.book.domain.Book
import com.kmm.books.book.domain.BookRepository
import com.kmm.books.core.domain.onError
import com.kmm.books.core.domain.onSuccess
import com.kmm.books.core.presentation.toUiText
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


//
// Created by Code For Android on 19/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class BookListViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {



    private var cachedBooks = emptyList<Book>()
    private var searchJob: Job? = null

    private val _state = MutableStateFlow(BookListState())
    val state = _state
        .onStart {
            if (cachedBooks.isEmpty()) {
                observeSearchQuery()
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: BookListAction) {

        when (action) {
            is BookListAction.OnBookClick -> {

            }

            is BookListAction.OnSearchQueryChange -> {
                _state.update {
                    it.copy(searchQuery = action.query)
                }


            }

            is BookListAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }

            }
        }


    }


    @OptIn(FlowPreview::class)
    private fun observeSearchQuery() {
        state.map {
            it.searchQuery
        }.distinctUntilChanged().debounce(500L).onEach { query ->
            when {
                query.isBlank() -> {
                    _state.update {
                        it.copy(
                            errorMessage = null,
                            searchResult = cachedBooks
                        )
                    }
                }

                query.length >= 2 -> {
                    searchJob?.cancel()
                    searchJob = searchBooks(query)
                }


            }
        }.launchIn(viewModelScope)
    }

    private fun searchBooks(query: String) =
        viewModelScope.launch {

            _state.update {
                it.copy(
                    isLoading = true,

                    )
            }


            bookRepository.searchBooks(query).onSuccess { searchResult ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = null,
                        searchResult = searchResult
                    )

                }

            }
                .onError { error ->
                    _state.update {
                        it.copy(
                            searchResult = emptyList(),
                            isLoading = false,
                            errorMessage = error.toUiText()
                        )
                    }


                }
        }


}