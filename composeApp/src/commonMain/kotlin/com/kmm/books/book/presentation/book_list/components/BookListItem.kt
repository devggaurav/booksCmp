package com.kmm.books.book.presentation.book_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.kmm.books.book.domain.Book
import com.kmm.books.core.presentation.LightBlue
import gcbookscmp.composeapp.generated.resources.Res
import gcbookscmp.composeapp.generated.resources.book_error_2
import org.jetbrains.compose.resources.painterResource


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

            Box(
                modifier = Modifier.height(100.dp),
                contentAlignment = Alignment.Center

            ) {
                var imageLoadResult by remember {
                    mutableStateOf<Result<Painter>?>(null)
                }

                val painter = rememberAsyncImagePainter(
                    model = book.imageUrl,
                    onSuccess = {
                        imageLoadResult =
                            if (it.painter.intrinsicSize.width > 1 && it.painter.intrinsicSize.height > 1) {
                                Result.success(it.painter)
                            } else {
                                Result.failure(Exception("Invalid image size"))
                            }
                    },
                    onError = {
                        it.result.throwable.printStackTrace()
                        imageLoadResult = Result.failure(it.result.throwable)
                    }

                )

                when (val result = imageLoadResult) {

                    null -> CircularProgressIndicator()
                    else -> Image(
                        painter = if (result.isSuccess) painter else painterResource(Res.drawable.book_error_2),
                        contentDescription = book.title,
                        contentScale = if (result.isSuccess) androidx.compose.ui.layout.ContentScale.Crop else androidx.compose.ui.layout.ContentScale.Fit,
                        modifier = Modifier.aspectRatio(
                            ratio = 0.65f,
                            matchHeightConstraintsFirst = true
                        )
                    )


                }


            }

            Column(
                modifier = Modifier.fillMaxHeight().weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = book.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium
                )

            }


        }

    }


}