package com.example.abschlussprojektsb

import com.example.abschlussprojektsb.network.NetworkService
import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", LoadingText().greet().contains("Android"))
    }

    @Test
    suspend fun testNetworkCall(){
        assertTrue("Login Test", NetworkService().login().id.isNotBlank() )
    }
}