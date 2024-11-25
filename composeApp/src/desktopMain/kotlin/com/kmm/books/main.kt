package com.kmm.books

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.kmm.books.app.App
import com.kmm.books.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "GCBooksCmp",
        ) {
            App()
        }
    }
}