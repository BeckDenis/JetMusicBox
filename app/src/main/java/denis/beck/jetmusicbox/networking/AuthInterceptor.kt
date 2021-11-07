package denis.beck.jetmusicbox.networking

import android.util.Base64
import denis.beck.jetmusicbox.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    private val base64EncodedAuth: String
        get() {
            val value = "${BuildConfig.clientId}:${BuildConfig.clientSecret}"
            return Base64.encodeToString(value.toByteArray(), Base64.URL_SAFE + Base64.NO_WRAP)
        }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Basic $base64EncodedAuth")
            .build()

        return chain.proceed(request)
    }
}