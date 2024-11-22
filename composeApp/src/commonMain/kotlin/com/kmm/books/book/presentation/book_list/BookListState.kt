package com.kmm.books.book.presentation.book_list

import com.kmm.books.book.domain.Book
import com.kmm.books.core.presentation.UiText


//
// Created by Code For Android on 19/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResult: List<Book> = emptyList(),
    val favoritesBook: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)
