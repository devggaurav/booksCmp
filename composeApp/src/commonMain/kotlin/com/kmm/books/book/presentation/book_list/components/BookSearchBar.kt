package com.kmm.books.book.presentation.book_list.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kmm.books.core.presentation.DarkBlue
import com.kmm.books.core.presentation.SandYellow
import gcbookscmp.composeapp.generated.resources.Res
import gcbookscmp.composeapp.generated.resources.search_hint
import org.jetbrains.compose.resources.stringResource


//
// Created by Code For Android on 19/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Composable
fun BookSearchBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onImeSearch: () -> Unit,
    modifier: Modifier = Modifier
){

    OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        maxLines = 1,
        singleLine = true,
        shape = RoundedCornerShape(100),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = DarkBlue,
            focusedBorderColor = SandYellow

        ),
        placeholder = {
            Text(
                text = stringResource(Res.string.search_hint)
            )
        }


    )



}