package com.kmm.books.book.data.network

import com.kmm.books.book.data.dto.SearchResponseDto
import com.kmm.books.book.domain.Book
import com.kmm.books.core.data.safeCall
import com.kmm.books.core.domain.DataError
import com.kmm.books.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter


//
// Created by Code For Android on 22/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

private val BASE_URL = "https://openlibrary.org"


class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
) {

    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<List<Book>, DataError.Remote> {


        return safeCall {
            httpClient.get(urlString = "$BASE_URL/search.json") {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter(
                    "fields",
                    "key,title,author_name,author_key,cover_edition_key,cover_i,ratings_average,ratings_count,first_publish_year,language,number_of_pages_median,edition_count"
                )
            }
        }

    }


}