package denis.beck.jetmusicbox.networking

import denis.beck.jetmusicbox.repositories.authData.AuthDataRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class BaseInterceptor(private val authDataRepository: AuthDataRepository): Interceptor {

    var accessToken: String? = null

    private fun getToken(): String {
        runBlocking {
            this@BaseInterceptor.accessToken = authDataRepository.getAuthData().accessToken
        }
        return this.accessToken!!
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization",
                "Bearer ${accessToken ?: getToken()}")
            .addHeader("Content-Type", "application/json")
            .build()

        return chain.proceed(request)
    }
}