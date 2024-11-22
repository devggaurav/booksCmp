package com.kmm.books.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//
// Created by Code For Android on 22/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//
@Serializable
data class SearchResponseDto(

   @SerialName("docs") val results : List <SearchBookDto>

)
