package com.example.abschlussprojektsb.model

import io.ktor.http.*
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class UserInfoDto(
    @SerialName("username") val username: String,
    @SerialName("password") val password: String?,
)

@kotlinx.serialization.Serializable
data class UserTokenDto(
   @SerialName ("token")val token: String,
   @SerialName ("id")val id: String,
   @SerialName ("username")val username: String,
)

@kotlinx.serialization.Serializable
data class TaskDto(
    @SerialName("task_id") val task_id: String,
    @SerialName("title") val title: String,
    @SerialName("is_done")var is_done: Boolean = false,
    @SerialName("start")val start: String?,
    @SerialName("end")val end: String?,
    @SerialName("content")val content: String?,
)


