package com.kmm.books.book.presentation.book_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmm.books.book.domain.Book
import com.kmm.books.core.presentation.LightBlue


//
// Created by Code For Android on 21/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Composable
fun BookListItem(
    book: Book,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(32.dp),
        modifier = modifier.clickable { onClick() },
        color = LightBlue.copy(alpha = 0.2f)
    ) {

        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth().height(IntrinsicSize.Min)
        ) {


        }

    }


}