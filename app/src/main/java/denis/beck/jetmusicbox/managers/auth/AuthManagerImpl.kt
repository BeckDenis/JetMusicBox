package denis.beck.jetmusicbox.managers.auth

import denis.beck.jetmusicbox.core.models.AuthData
import denis.beck.jetmusicbox.extensions.toAuthData
import denis.beck.jetmusicbox.networking.apis.AuthApi
import denis.beck.jetmusicbox.repositories.authData.AuthDataRepository
import timber.log.Timber
import javax.inject.Inject

class AuthManagerImpl @Inject constructor(
    private val authApi: AuthApi,
    private val authDataRepository: AuthDataRepository,
) : AuthManager {

    override suspend fun isAuthorize(): Boolean = authDataRepository.getAuthData() != AuthData()

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

    override suspend fun refreshToken(): String? {
        return try {
            val authData = authDataRepository.getAuthData()
            val refreshResponse = authApi.refreshToken(authData.refreshToken)
            refreshResponse.accessToken.also {
                authDataRepository.setAuthData(
                    authData.copy(
                        accessToken = refreshResponse.accessToken,
                        expiresIn = refreshResponse.expiresIn
                    )
                )
            }
        } catch (e: Exception) {
            Timber.e(e.message)
            null
        }
    }

}