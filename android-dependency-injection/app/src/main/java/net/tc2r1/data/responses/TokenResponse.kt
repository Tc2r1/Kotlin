package net.tc2r1.data.responses

data class TokenResponse(
    val access_token: String?,
    val refresh_token: String?
)