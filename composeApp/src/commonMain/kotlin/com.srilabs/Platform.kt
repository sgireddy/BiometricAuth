package com.srilabs

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform