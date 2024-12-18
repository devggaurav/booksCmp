package com.kmm.books

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.kmm.books.book.domain.Book
import com.kmm.books.book.presentation.book_list.BookListScreen
import com.kmm.books.book.presentation.book_list.BookListState
import com.kmm.books.book.presentation.book_list.components.BookSearchBar


//
// Created by Code For Android on 20/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Preview
@Composable
private fun BookSearchBarPreview() {
    MaterialTheme {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            BookSearchBar(searchQuery = "kotlin", onSearchQueryChange = {}, onImeSearch = { },
                modifier = Modifier.fillMaxWidth()
            )
        }


    }

}

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



@Preview
@Composable
private fun BookListScreenPreview() {

    BookListScreen(
        state = BookListState(
           searchResult = books
        )
    ) {

    }
}