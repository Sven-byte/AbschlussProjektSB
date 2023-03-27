package com.example.abschlussprojektsb

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform