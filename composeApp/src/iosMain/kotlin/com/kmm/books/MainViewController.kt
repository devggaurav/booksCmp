package com.kmm.books

import androidx.compose.ui.window.ComposeUIViewController
import com.kmm.books.app.App
import com.kmm.books.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {


    App()


}