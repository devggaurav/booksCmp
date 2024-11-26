package com.kmm.books.book.presentation.book_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.kmm.books.core.presentation.DarkBlue
import com.kmm.books.core.presentation.DesertWhite
import gcbookscmp.composeapp.generated.resources.Res
import gcbookscmp.composeapp.generated.resources.book_cover
import org.jetbrains.compose.resources.stringResource


//
// Created by Code For Android on 26/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Composable
fun BlurredImageBackground(
    imageUrl: String?,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    var imageLoadResult by remember {
        mutableStateOf<Result<Painter>?>(null)
    }

    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        onSuccess = {
            val size = it.painter.intrinsicSize
            imageLoadResult = if (size.width > 1 && size.height > 1) {
                Result.success(it.painter)
            } else {
                Result.failure(Exception("Invalid image size"))

            }
        },
    )

    Box() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.weight(0.3f).fillMaxWidth().background(DarkBlue)
            ) {
                imageLoadResult?.getOrNull()?.let { painter ->
                    Image(
                        painter = painter,
                        contentDescription = stringResource(Res.string.book_cover),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize().blur(20.dp)
                    )


                }

            }

            Box(
                modifier = Modifier.weight(0.7f).fillMaxWidth().background(DesertWhite)
            ) {

            }


        }


    }

}