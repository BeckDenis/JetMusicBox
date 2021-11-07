package denis.beck.jetmusicbox.repositories

import denis.beck.jetmusicbox.networking.apis.AuthApi
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authApi: AuthApi) {

    suspend fun authorize(code: String) = authApi.accessToken(code = code)

}