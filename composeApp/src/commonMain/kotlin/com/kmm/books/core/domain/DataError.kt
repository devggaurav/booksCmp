package com.kmm.books.core.domain


//
// Created by Code For Android on 22/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

sealed interface DataError : Error {

    enum class Remote : DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET_CONNECTION,
        SERVER_ERROR,
        SERIALIZATION_ERROR,
        UNKNOWN_ERROR
    }


    enum class Local : DataError {
        DISK_FULL,
        UNKNOWN_ERROR
    }

}