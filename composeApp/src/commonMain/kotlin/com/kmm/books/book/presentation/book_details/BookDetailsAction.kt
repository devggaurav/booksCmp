package com.kmm.books.book.presentation.book_details

import com.kmm.books.book.domain.Book


//
// Created by Code For Android on 26/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

sealed interface BookDetailsAction {

    data object OnBackClick : BookDetailsAction
    data object OnFavoriteClick : BookDetailsAction
    data class OnSelectedBookChange(val book: Book) : BookDetailsAction
}