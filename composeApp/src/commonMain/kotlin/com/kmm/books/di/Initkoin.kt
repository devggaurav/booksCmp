package com.kmm.books.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration


//
// Created by Code For Android on 25/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

fun initKoin(config: KoinAppDeclaration? = null) {

    startKoin {
        config?.invoke(this)
        modules(sharedModule, platformModule)
    }
}