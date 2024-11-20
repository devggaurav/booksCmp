package com.kmm.books.book.presentation.book_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kmm.books.book.domain.Book
import org.koin.compose.viewmodel.koinViewModel


//
// Created by Code For Android on 19/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Composable
fun BookListScreenRoot(
    viewModel: BookListViewModel = koinViewModel(),
    onBookCLick: (Book) -> Unit,
    modifier: Modifier = Modifier
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    BookListScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is BookListAction.OnBookClick -> onBookCLick(action.book)
                else -> Unit
            }
            viewModel.onAction(action)

        }

    )

}


@Composable
private fun BookListScreen(
    state: BookListState,
    onAction: (BookListAction) -> Unit,
) {

}