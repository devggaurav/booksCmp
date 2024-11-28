package com.kmm.books.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.kmm.books.book.data.network.KtorRemoteBookDataSource
import com.kmm.books.book.data.network.RemoteBookDataSource
import com.kmm.books.book.data.repository.DefaultBookRepository
import com.kmm.books.book.domain.BookRepository
import com.kmm.books.book.presentation.book_list.BookListViewModel
import com.kmm.books.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.kmm.books.book.SelectedBookViewModel
import com.kmm.books.book.data.database.DatabaseFactory
import com.kmm.books.book.presentation.book_details.BookDetailsViewModel


//
// Created by Code For Android on 23/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
         get<DatabaseFactory>().create().setDriver(BundledSQLiteDriver()).build()
    }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailsViewModel)
    viewModelOf(::SelectedBookViewModel)


}