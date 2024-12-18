package com.kmm.books.book.data.dto

import kotlinx.serialization.Serializable


//
// Created by Code For Android on 27/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//


@Serializable(with = BookWorkDtoSerializer::class)
data class BookWorkDto(
    val description: String? = null,
)
