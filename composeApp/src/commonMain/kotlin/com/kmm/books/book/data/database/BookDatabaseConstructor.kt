package com.kmm.books.book.data.database

import androidx.room.RoomDatabaseConstructor


//
// Created by Code For Android on 28/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object BookDatabaseConstructor : RoomDatabaseConstructor<FavoriteBookDatabase> {
    override fun initialize(): FavoriteBookDatabase
}