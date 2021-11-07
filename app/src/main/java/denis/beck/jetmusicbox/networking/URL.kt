package denis.beck.jetmusicbox.networking

import android.net.Uri
import denis.beck.jetmusicbox.BuildConfig

object URL {

    val auth = getAuthUrl()

    fun isRedirectUri(url: Uri?) = url?.host == Uri.parse(BuildConfig.redirectURI).host

    private object Scopes {
        const val userReadPrivate = "user-read-private"
    }

    private object ResponseTypes {
        const val code = "code"
    }

    private fun getAuthUrl() = Uri.parse(BuildConfig.authURL).buildUpon()
        .appendQueryParameter(Queries.responseType, ResponseTypes.code)
        .appendQueryParameter(Queries.clientId, BuildConfig.apiKey)
        .appendQueryParameter(Queries.scope, Scopes.userReadPrivate)
        .appendQueryParameter(Queries.redirectUri, BuildConfig.redirectURI)
        .toString()
}