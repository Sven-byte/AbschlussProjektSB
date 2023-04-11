package com.example.abschlussprojektsb

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        assertTrue(LoadingText().greet().contains("Hello"), "Check 'Hello' is mentioned")
    }
}