package com.kmm.books.book.data.network

import com.kmm.books.book.data.dto.SearchResponseDto
import com.kmm.books.book.domain.Book
import com.kmm.books.core.domain.DataError
import com.kmm.books.core.domain.Result
import io.ktor.client.HttpClient


//
// Created by Code For Android on 22/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
) {

    suspend fun searchBooks(query: String,
                            resultLimit: Int? = null): Result<List<Book>,DataError.Remote> {

    }


}