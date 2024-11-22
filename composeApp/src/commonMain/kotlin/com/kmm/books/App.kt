package com.kmm.books

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kmm.books.book.data.network.KtorRemoteBookDataSource
import com.kmm.books.book.data.repository.DefaultBookRepository
import com.kmm.books.book.presentation.book_list.BookListScreenRoot
import com.kmm.books.book.presentation.book_list.BookListViewModel
import com.kmm.books.core.data.HttpClientFactory
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import gcbookscmp.composeapp.generated.resources.Res
import gcbookscmp.composeapp.generated.resources.compose_multiplatform
import io.ktor.client.engine.HttpClientEngine

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember {
            BookListViewModel(
                bookRepository = DefaultBookRepository(
                    remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(
                            engine = engine
                        )
                    )
                )
            )
        },
        onBookCLick = {

        }
    )
}