package com.kmm.books.book.presentation.book_details

import com.kmm.books.book.domain.Book


//
// Created by Code For Android on 25/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

data class BookDetailsState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
