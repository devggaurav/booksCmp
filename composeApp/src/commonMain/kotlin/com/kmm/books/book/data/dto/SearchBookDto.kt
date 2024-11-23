package com.kmm.books.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//
// Created by Code For Android on 22/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

@Serializable
data class SearchBookDto(
    @SerialName("key") val id: String,
    @SerialName("title") val title: String,
    @SerialName("language") val languages: List<String>? = null,
    @SerialName("cover_i") val coverAlternativeKey: Int? = null,
    @SerialName("author_key") val authorKey: List<String>? = null,
    @SerialName("author_name") val authorName: List<String>? = null,
    @SerialName("cover_edition_key") val coverKey: String? = null,

    @SerialName("first_publish_year") val firstPublishYear: Int? = null,
    @SerialName("ratings_average") val ratingsAverage: Double? = null,
    @SerialName("ratings_count") val ratingsCount: Int? = null,
    @SerialName("number_of_pages_median") val numPagesMedian: Int? = null,
    @SerialName("edition_count") val editionCount: Int? = null,

    )
