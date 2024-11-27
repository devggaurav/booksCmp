package com.kmm.books.book.data.dto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


//
// Created by Code For Android on 27/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

object BookWorkDtoSerializer : KSerializer<BookWorkDto> {

    override val descriptor: SerialDescriptor
        get() = TODO("Not yet implemented")

    override fun deserialize(decoder: Decoder): BookWorkDto {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: BookWorkDto) {
        TODO("Not yet implemented")
    }


}