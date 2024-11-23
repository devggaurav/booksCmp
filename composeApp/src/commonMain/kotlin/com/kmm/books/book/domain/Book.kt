package com.kmm.books.book.domain


//
// Created by Code For Android on 19/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

data class Book(
    val id : String,
    val title : String,
    val authors : List<String>,
    val description : String?,
    val imageUrl : String,
    val languages : List<String>,
    val firstPublishYear : String?,
    val averageRating : Double?,
    val ratingsCount : Int?,
    val numPages : Int?,
    val numEditions : Int
)
