package com.kmm.books.core.presentation

import com.kmm.books.core.domain.DataError
import gcbookscmp.composeapp.generated.resources.Res
import gcbookscmp.composeapp.generated.resources.error_disk_full
import gcbookscmp.composeapp.generated.resources.error_no_internet
import gcbookscmp.composeapp.generated.resources.error_request_timeout
import gcbookscmp.composeapp.generated.resources.error_serialization
import gcbookscmp.composeapp.generated.resources.error_too_many_requests
import gcbookscmp.composeapp.generated.resources.error_unknown


//
// Created by Code For Android on 23/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

fun DataError.toUiText(): UiText {
    val stringRes = when(this) {
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN_ERROR -> Res.string.error_unknown
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_timeout
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        DataError.Remote.NO_INTERNET_CONNECTION -> Res.string.error_no_internet
        DataError.Remote.SERVER_ERROR -> Res.string.error_unknown
        DataError.Remote.SERIALIZATION_ERROR -> Res.string.error_serialization
        DataError.Remote.UNKNOWN_ERROR -> Res.string.error_unknown
    }

    return UiText.StringResourceId(stringRes)
}