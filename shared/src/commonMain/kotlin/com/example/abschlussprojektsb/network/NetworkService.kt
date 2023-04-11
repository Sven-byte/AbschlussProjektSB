package com.example.abschlussprojektsb.network

import com.example.abschlussprojektsb.model.TaskDto
import com.example.abschlussprojektsb.model.UserInfoDto
import com.example.abschlussprojektsb.model.UserTokenDto
import com.example.abschlussprojektsb.service.checkIfCredentialsArePlausible
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*


class NetworkService(): RequestService {

    private val client = HttpClient(){
        install(ContentNegotiation){
            json()
        }
    }

    override suspend fun getTasks(token: String): List<TaskDto> {
        val response: HttpResponse = client.get("https://tasksapi.pschuberth.de/task") {
            headers {
                append("Accept", "application/json")
                append("Authorization", "Bearer $token")
            }
        }
        return response.body<List<TaskDto>>()
    }

    override suspend fun login(): UserTokenDto {
        val response: HttpResponse = client.request("https://tasksapi.pschuberth.de/user/login") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)

            val userInputTestData = UserInfoDto("sven", "test")

            if (checkIfCredentialsArePlausible(userInputTestData)){
                setBody(userInputTestData)
            }
        }
        return response.body<UserTokenDto>()
    }
}