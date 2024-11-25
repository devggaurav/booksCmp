package com.kmm.books.app

import kotlinx.serialization.Serializable


//
// Created by Code For Android on 25/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

sealed interface Route {

    @Serializable
    data object BookGraph : Route


    @Serializable
    data object BookList : Route

    @Serializable
    data class BookDetail(val id: String) : Route
}