package denis.beck.jetmusicbox.networking

import denis.beck.jetmusicbox.managers.auth.AuthManager
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import timber.log.Timber
import javax.inject.Inject

class Authenticator @Inject constructor(private val authManager: AuthManager) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        return runBlocking {
            val accessToken = authManager.refreshToken()
            if (accessToken != null) {
                Timber.d(accessToken)
                response.request
                    .newBuilder()
                    .removeHeader("Authorization")
                    .addHeader("Authorization", "Bearer $accessToken")
                    .build()
            } else null
        }
    }
}