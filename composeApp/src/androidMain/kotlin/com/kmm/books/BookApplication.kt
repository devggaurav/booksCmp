package com.kmm.books

import android.app.Application
import com.kmm.books.di.initKoin
import org.koin.android.ext.koin.androidContext


//
// Created by Code For Android on 25/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class BookApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookApplication)
        }

    }
}