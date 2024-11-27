package com.kmm.books.book.presentation.book_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.kmm.books.core.presentation.LightBlue


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
    size: ChipSize = ChipSize.REGULAR,
    chipContent: @Composable RowScope.() -> Unit
) {

    Box(
        modifier = modifier.widthIn(
            min = when (size) {
                ChipSize.Small -> 50.dp
                ChipSize.REGULAR -> 80.dp
                ChipSize.Large -> 136.dp
            }
        ).clip(RoundedCornerShape(16.dp))
            .background(LightBlue)
            .padding(vertical = 8.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            chipContent()
        }

    }


}