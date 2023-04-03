package com.example.abschlussprojektsb


class LoadingText {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "${platform.name} Gerät lädt..."

    }
}