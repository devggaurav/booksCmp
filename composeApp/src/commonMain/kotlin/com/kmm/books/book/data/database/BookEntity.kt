package com.kmm.books.book.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey


//
// Created by Code For Android on 28/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val title: String,
    val description: String?,
    val imageUrl: String,
    val languages: List<String>,
    val authors: List<String>,
    val firstPublishYear: String?,
    val ratingsAverage: Double?,
    val ratingsCount: Int?,
    val numPagesMedian: Int?,
    val numEditions: Int
)
