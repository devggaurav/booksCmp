package com.kmm.books.book.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


//
// Created by Code For Android on 28/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//


@Database(
    entities = [BookEntity::class],
    version = 1
)
@TypeConverters(StringListTypeConverter::class)
abstract class FavoriteBookDatabase : RoomDatabase() {
    abstract val favoriteBookDao: FavoriteBookDao

    companion object {
        const val DATABASE_NAME = "favorite_books_db"
    }
}