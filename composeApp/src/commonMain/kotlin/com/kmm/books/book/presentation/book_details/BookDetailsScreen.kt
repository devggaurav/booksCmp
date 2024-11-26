package com.kmm.books.book.presentation.book_details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kmm.books.book.presentation.book_details.components.BlurredImageBackground


//
// Created by Code For Android on 26/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//


@Composable
fun BookDetailsScreenRoot(
    viewModel: BookDetailsViewModel,
    onBackClick: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BookDetailsScreen(
        state = state,
        onAction = { action ->
            when (action) {
                BookDetailsAction.OnBackClick -> onBackClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}


@Composable
private fun BookDetailsScreen(
    state: BookDetailsState,
    onAction: (BookDetailsAction) -> Unit,
    modifier: Modifier = Modifier,
) {

    BlurredImageBackground(
        imageUrl = state.book?.imageUrl,
        isFavorite = state.isFavorite,
        onFavoriteClick = {
            onAction(BookDetailsAction.OnFavoriteClick)
        },
        onBackClick = {
            onAction(BookDetailsAction.OnBackClick)
        },
        modifier = Modifier.fillMaxSize()
    ){


    }

}