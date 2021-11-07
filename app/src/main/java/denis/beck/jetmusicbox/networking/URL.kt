package denis.beck.jetmusicbox.networking

import android.net.Uri
import denis.beck.jetmusicbox.BuildConfig
import denis.beck.jetmusicbox.networking.constants.Paths
import denis.beck.jetmusicbox.networking.constants.Queries
import denis.beck.jetmusicbox.networking.constants.ResponseTypes
import denis.beck.jetmusicbox.networking.constants.Scopes

object URL {

    val auth = getAuthUrl()

    fun isRedirectUri(url: Uri?) = url?.host == Uri.parse(BuildConfig.redirectURI).host


    private fun getAuthUrl() = Uri.parse(BuildConfig.authURL).buildUpon()
        .appendPath(Paths.authorize)
        .appendQueryParameter(Queries.responseType, ResponseTypes.code)
        .appendQueryParameter(Queries.clientId, BuildConfig.clientId)
        .appendQueryParameter(Queries.scope, Scopes.userReadPrivate)
        .appendQueryParameter(Queries.redirectUri, BuildConfig.redirectURI)
        .toString()
}