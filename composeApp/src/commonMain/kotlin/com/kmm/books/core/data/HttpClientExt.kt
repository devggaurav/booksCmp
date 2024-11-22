package com.kmm.books.core.data

import com.kmm.books.core.domain.DataError
import com.kmm.books.core.domain.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse


//
// Created by Code For Android on 22/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, DataError.Remote> {
    return when (response.status.value) {
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch (ex: NoTransformationFoundException) {
                Result.Error(DataError.Remote.SERIALIZATION_ERROR)
            }
        }

        400 -> Result.Error(DataError.Remote.REQUEST_TIMEOUT)
        429 -> Result.Error(DataError.Remote.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(DataError.Remote.SERVER_ERROR)
        else -> Result.Error(DataError.Remote.UNKNOWN_ERROR)


    }
}