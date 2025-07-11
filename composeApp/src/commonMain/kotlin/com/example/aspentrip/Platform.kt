package com.example.aspentrip

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform