package com.kmm.books.book.data.database

import androidx.room.RoomDatabase


//
// Created by Code For Android on 28/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

expect class DatabaseFactory {

    fun create() : RoomDatabase.Builder<FavoriteBookDatabase>
}