package com.example.abschlussprojektsb.service

import com.example.abschlussprojektsb.model.UserInfoDto

fun checkIfCredentialsArePlausible(userInfoDto: UserInfoDto): Boolean {


    // Diese Klasse könnt ein Beißpiel für einfache Logik sein die man in das Shared Modul auslagern kann.

    val thePassword: String? = userInfoDto.password
    val theUsername: String? = userInfoDto.username

    if (theUsername != null && theUsername.isNotBlank()) {

            if(thePassword != null && thePassword.isNotBlank() ){

                if ( thePassword.contains("-") || thePassword.contains("_"))
                return true
            }
        }



return false
}
