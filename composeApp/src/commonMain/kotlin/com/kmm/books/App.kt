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
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<BookListViewModel>()
    BookListScreenRoot(
        viewModel = viewModel,
        onBookCLick = {

        }
    )
}