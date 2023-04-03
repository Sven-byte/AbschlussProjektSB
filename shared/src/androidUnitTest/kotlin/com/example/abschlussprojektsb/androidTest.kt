package com.example.abschlussprojektsb

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", LoadingText().greet().contains("Android"))
    }
}