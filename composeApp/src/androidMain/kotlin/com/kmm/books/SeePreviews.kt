package com.kmm.books

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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