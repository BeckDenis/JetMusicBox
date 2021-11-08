package denis.beck.jetmusicbox.managers.auth

import denis.beck.jetmusicbox.data.AuthData
import denis.beck.jetmusicbox.extensions.toAuthData
import denis.beck.jetmusicbox.managers.authData.AuthDataRepository
import denis.beck.jetmusicbox.networking.apis.AuthApi
import timber.log.Timber
import javax.inject.Inject

class AuthManagerImpl @Inject constructor(
    private val authApi: AuthApi,
    private val authDataRepository: AuthDataRepository
) : AuthManager {

    override suspend fun isAuthorize(): Boolean =
        authDataRepository.getAuthData() != AuthData()

    override suspend fun authorize(code: String): Boolean {
        return try {
            val authData = authApi.accessToken(code = code).toAuthData()
            authDataRepository.setAuthData(authData)
            true
        } catch (e: Exception) {
            Timber.e(e.message)
            false
        }
    }

}