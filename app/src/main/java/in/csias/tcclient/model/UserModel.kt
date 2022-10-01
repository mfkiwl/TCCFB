package `in`.csias.tcclient.model

import com.google.firebase.auth.AuthResult

data class UserModel(
    val phoneNumber: String? = "",
    val token: String = "",
)
