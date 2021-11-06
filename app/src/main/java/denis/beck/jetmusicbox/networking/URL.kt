package denis.beck.jetmusicbox.networking

import android.net.Uri
import denis.beck.jetmusicbox.BuildConfig

object URL {

    val auth = getAuthUrl()

    private object Scopes {
        const val userReadPrivate = "user-read-private"
    }

    private object ResponseTypes {
        const val code = "code"
    }

    private object Queries {
        const val responseType = "response_type"
        const val clientId = "client_id"
        const val scope = "scope"
        const val redirectUri = "redirect_uri"
    }

    private fun getAuthUrl() = Uri.parse(BuildConfig.authURL).buildUpon()
        .appendQueryParameter(Queries.responseType, ResponseTypes.code)
        .appendQueryParameter(Queries.clientId, BuildConfig.apiKey)
        .appendQueryParameter(Queries.scope, Scopes.userReadPrivate)
        .appendQueryParameter(Queries.redirectUri, BuildConfig.redirectURI)
        .toString()
}