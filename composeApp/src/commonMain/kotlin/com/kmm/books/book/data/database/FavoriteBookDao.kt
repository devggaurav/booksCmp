package com.kmm.books.book.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


//
// Created by Code For Android on 28/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//
@Dao
interface FavoriteBookDao {

    @Upsert
    suspend fun upsertBook(book: BookEntity)

     @Query("SELECT * FROM BookEntity")
    fun getFavoriteBooks(): Flow<List<BookEntity>>


    @Query("SELECT * FROM BookEntity WHERE id = :bookId")
    suspend fun getFavoriteBookById(bookId: String): BookEntity?


    @Query("DELETE FROM BookEntity WHERE id = :bookId")
    suspend fun deleteFavoriteBookById(bookId: String)


}