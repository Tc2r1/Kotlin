package net.tc2r1.data.responses

data class User(
    val access_token: String?,
    val refresh_token: String?,
    val created_at: String,
    val email: String,
    val email_verified_at: Any,
    val id: Int,
    val name: String,
    val updated_at: String
)