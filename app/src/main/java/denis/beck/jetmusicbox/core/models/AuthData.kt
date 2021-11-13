package denis.beck.jetmusicbox.core.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthData(
    val accessToken: String = "",
    val refreshToken: String = "",
    val expiresIn: Int = -1,
)