package denis.beck.jetmusicbox.data

import kotlinx.serialization.Serializable

@Serializable
data class AuthData(
    val accessToken: String = "",
    val refreshToken: String = "",
    val expiresIn: Int = -1,
)