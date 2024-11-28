package com.kmm.books.book.data.repository

import com.kmm.books.book.data.mappers.toBook
import com.kmm.books.book.data.network.RemoteBookDataSource
import com.kmm.books.book.domain.Book
import com.kmm.books.book.domain.BookRepository
import com.kmm.books.core.domain.DataError
import com.kmm.books.core.domain.Result
import com.kmm.books.core.domain.map


//
// Created by Code For Android on 23/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {

    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {

        return remoteBookDataSource.searchBooks(query).map { dto ->
            dto.results.map { it.toBook() }

        }

    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        return remoteBookDataSource.getBookDetails(bookId).map {
            it.description
        }
    }
}