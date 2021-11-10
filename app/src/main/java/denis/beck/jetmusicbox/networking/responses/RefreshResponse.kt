package denis.beck.jetmusicbox.networking.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshResponse(
    @SerialName(value = "access_token") val accessToken: String,
    @SerialName(value = "token_type") val tokenType: String,
    @SerialName(value = "scope") val scope: String,
    @SerialName(value = "expires_in") val expiresIn: Int,
)