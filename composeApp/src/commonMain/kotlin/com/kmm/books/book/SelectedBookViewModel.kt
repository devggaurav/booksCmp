package com.kmm.books.book

import androidx.lifecycle.ViewModel
import com.kmm.books.book.domain.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


//
// Created by Code For Android on 25/11/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

class SelectedBookViewModel : ViewModel() {

    private val _selectedBook = MutableStateFlow<Book?>(null)
    val selectedBook = _selectedBook.asStateFlow()


    fun onSelectedBook(book: Book?) {
        _selectedBook.value = book
    }



}