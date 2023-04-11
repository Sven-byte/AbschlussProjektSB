package com.example.abschlussprojektsb.service

import com.example.abschlussprojektsb.model.UserInfoDto

fun checkIfCredentialsArePlausible(userInfoDto: UserInfoDto): Boolean {

    val thePassword: String? = userInfoDto.password
    val theUsername: String? = userInfoDto.username

    if (theUsername != null && theUsername.isNotBlank()) {

            if(thePassword != null && thePassword.isNotBlank() ){

                return true
            }
        }

return false
}

