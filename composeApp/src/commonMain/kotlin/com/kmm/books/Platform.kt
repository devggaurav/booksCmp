package com.kmm.books

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform