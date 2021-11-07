package denis.beck.jetmusicbox.extensions

import denis.beck.jetmusicbox.data.AuthData
import denis.beck.jetmusicbox.networking.responses.AuthResponse

fun AuthResponse.toAuthData() = AuthData(
    accessToken = accessToken,
    refreshToken = refreshToken,
    expiresIn = expiresIn
)