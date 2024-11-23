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
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)

val books = (1..100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "https://",
        authors = listOf("Author $it"),
        averageRating = 4.5678,
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = null,
        ratingsCount = 5,
        numPages = 100,
        numEditions = 3
    )


}

