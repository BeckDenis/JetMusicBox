package denis.beck.jetmusicbox.views

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import denis.beck.jetmusicbox.networking.Queries
import denis.beck.jetmusicbox.networking.URL

class AuthWebViewClient(private val code: (String) -> Unit) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url = request?.url
        if (url != null && URL.isRedirectUri(url)) {
            url.getQueryParameter(Queries.code)?.let { code(it) }
        }
        return false
    }

}