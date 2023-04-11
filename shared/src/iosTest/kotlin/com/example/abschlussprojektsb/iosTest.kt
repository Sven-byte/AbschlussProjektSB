package com.example.abschlussprojektsb

import com.example.abschlussprojektsb.network.NetworkService
import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        assertTrue(LoadingText().greet().contains("iOS"), "Check iOS is mentioned")
    }


}