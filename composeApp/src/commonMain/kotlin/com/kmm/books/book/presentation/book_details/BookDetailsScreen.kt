package com.kmm.books.book.presentation.book_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kmm.books.book.presentation.book_details.components.BlurredImageBackground
import com.kmm.books.book.presentation.book_details.components.BookChip
import com.kmm.books.book.presentation.book_details.components.ChipSize
import com.kmm.books.book.presentation.book_details.components.TitledContent
import com.kmm.books.core.presentation.SandYellow
import gcbookscmp.composeapp.generated.resources.Res
import gcbookscmp.composeapp.generated.resources.languages
import gcbookscmp.composeapp.generated.resources.pages
import gcbookscmp.composeapp.generated.resources.rating
import gcbookscmp.composeapp.generated.resources.synopsis
import org.jetbrains.compose.resources.stringResource
import kotlin.math.round


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


@OptIn(ExperimentalLayoutApi::class)
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
    ) {

        if (state.book != null) {
            Column(
                modifier = Modifier.widthIn(max = 700.dp).fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 24.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = state.book.title,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = state.book.authors.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                )

                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    state.book.averageRating?.let { rating ->

                        TitledContent(
                            title = stringResource(Res.string.rating)
                        ) {
                            BookChip(

                            ) {
                                Text(
                                    text = "${round(rating * 10) / 10.0}"
                                )
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = stringResource(Res.string.rating),
                                    tint = SandYellow
                                )
                            }

                        }


                    }

                    state.book.numPages?.let { pages ->

                        TitledContent(
                            title = stringResource(Res.string.pages)
                        ) {
                            BookChip(

                            ) {
                                Text(
                                    text = pages.toString()
                                )

                            }

                        }

                    }


                }

                if (state.book.languages.isNotEmpty()) {

                    TitledContent(
                        title = stringResource(Res.string.languages),
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {

                        FlowRow(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.wrapContentSize(Alignment.Center)

                        ) {
                            state.book.languages.forEach { language ->

                                BookChip(
                                    size = ChipSize.Small,
                                    modifier = Modifier.padding(2.dp)
                                ) {

                                    Text(
                                        text = language.uppercase(),
                                        style = MaterialTheme.typography.bodyMedium
                                    )

                                }


                            }


                        }

                    }
                }

                 Text(
                     text = stringResource(Res.string.synopsis),
                     style = MaterialTheme.typography.titleLarge,
                     modifier = Modifier.align(Alignment.Start).fillMaxWidth().padding(top = 24.dp, bottom = 8.dp)
                 )




            }


        } else {


        }

    }

}