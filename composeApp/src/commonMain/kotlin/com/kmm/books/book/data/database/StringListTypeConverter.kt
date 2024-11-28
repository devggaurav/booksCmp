package com.kmm.books.book.data.database

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


//
// Created by Code For Android on 28/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

object StringListTypeConverter {

    @TypeConverter
    fun fromString(value: String): List<String> {
        return Json.decodeFromString(value)
    }


    @TypeConverter
    fun fromList(list: List<String>): String {
        return Json.encodeToString(list)
    }

}