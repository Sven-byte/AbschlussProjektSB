package com.example.abschlussprojektsb.android.model

import com.example.abschlussprojektsb.model.UserTokenDto

data class UserToken( val token: String,
                      val id: String,
                      val username: String,): java.io.Serializable
{
    companion object {
        fun fromUserTokenDto(dto: UserTokenDto): UserToken {
            return UserToken(
                token = dto.token,
                id = dto.id,
                username = dto.username
            )
        }
    }
}
