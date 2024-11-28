package com.kmm.books.book.domain

import com.kmm.books.core.domain.DataError
import com.kmm.books.core.domain.EmptyResult
import com.kmm.books.core.domain.Result
import kotlinx.coroutines.flow.Flow


//
// Created by Code For Android on 23/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

interface BookRepository {

    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>

    suspend fun getBookDescription(bookId: String): Result<String?, DataError>


    fun getFavoriteBooks(): Flow<List<Book>>

    fun isBookFavorite(bookId: String): Flow<Boolean>

    suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local>
    suspend fun deleteFavoriteBook(bookId: String)
}