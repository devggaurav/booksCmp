package com.kmm.books.book.presentation.book_details.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


//
// Created by Code For Android on 26/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//
enum class ChipSize {
    Small,
    REGULAR,
    Large
}


@Composable
fun BookChip(
    modifier: Modifier = Modifier,
    isSmall: ChipSize = ChipSize.REGULAR,
    chipContent : @Composable () -> Unit
) {




}