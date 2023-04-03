package com.example.abschlussprojektsb.network

import com.example.abschlussprojektsb.model.TaskDto
import com.example.abschlussprojektsb.model.UserTokenDto

interface RequestService {

    suspend fun getTasks(token: String): List<TaskDto>

    suspend fun login(): UserTokenDto?

}