package denis.beck.jetmusicbox.screens.authentication.web

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import denis.beck.jetmusicbox.networking.URL
import denis.beck.jetmusicbox.networking.constants.Queries

class AuthWebViewClient(
    private val code: (String) -> Unit,
    private val error: (String) -> Unit
) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url = request?.url
        if (url != null && URL.isRedirectUri(url)) {
            url.getQueryParameter(Queries.code)?.let { code(it) }
            url.getQueryParameter(Queries.error)?.let { error(it) }
        }
        return false
    }

}