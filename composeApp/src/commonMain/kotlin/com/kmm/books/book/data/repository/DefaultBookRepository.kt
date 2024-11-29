package com.kmm.books.book.data.repository

import androidx.sqlite.SQLiteException
import com.kmm.books.book.data.database.FavoriteBookDao
import com.kmm.books.book.data.mappers.toBook
import com.kmm.books.book.data.mappers.toBookEntity
import com.kmm.books.book.data.network.RemoteBookDataSource
import com.kmm.books.book.domain.Book
import com.kmm.books.book.domain.BookRepository
import com.kmm.books.core.domain.DataError
import com.kmm.books.core.domain.EmptyResult
import com.kmm.books.core.domain.Result
import com.kmm.books.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


//
// Created by Code For Android on 23/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao
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

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao.getFavoriteBooks().map { bookEntities ->
            bookEntities.map { it.toBook() }
        }
    }

    override fun isBookFavorite(bookId: String): Flow<Boolean> {
        return favoriteBookDao.getFavoriteBooks().map { bookEntities ->
            bookEntities.any {
                it.id == bookId
            }
        }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsertBook(book.toBookEntity())
            Result.Success(Unit)
        } catch (ex: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }


    }

    override suspend fun deleteFavoriteBook(bookId: String) {
        favoriteBookDao.deleteFavoriteBookById(bookId)
    }
}