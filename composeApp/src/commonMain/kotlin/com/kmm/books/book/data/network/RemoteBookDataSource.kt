package com.kmm.books.book.data.network

import com.kmm.books.book.data.dto.BookWorkDto
import com.kmm.books.book.data.dto.SearchResponseDto
import com.kmm.books.core.domain.DataError
import com.kmm.books.core.domain.Result


//
// Created by Code For Android on 23/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

interface RemoteBookDataSource {


    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>


    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>

}