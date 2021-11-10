package denis.beck.jetmusicbox.networking

import denis.beck.jetmusicbox.BuildConfig
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val credential = Credentials.basic(BuildConfig.clientId, BuildConfig.clientSecret)
        val request = chain.request().newBuilder()
            .addHeader("Authorization", credential)
            .build()

        return chain.proceed(request)
    }
}