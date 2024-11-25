package com.kmm.books

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.kmm.books.di.initKoin
import io.ktor.client.engine.darwin.Darwin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {


    App()


}