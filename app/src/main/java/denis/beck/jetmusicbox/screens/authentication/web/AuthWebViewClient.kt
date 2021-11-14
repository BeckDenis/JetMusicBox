package denis.beck.jetmusicbox.screens.authentication.web

import android.graphics.Bitmap
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import denis.beck.jetmusicbox.BuildConfig
import denis.beck.jetmusicbox.networking.URL
import denis.beck.jetmusicbox.networking.constants.Queries

class AuthWebViewClient(
    private val isPageLoading: (Boolean) -> Unit,
    private val code: (String) -> Unit,
    private val error: (String) -> Unit,
) : WebViewClient() {

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        isPageLoading(true)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        // No need to show our redirect page, so keep showing progress indicator
        if (Uri.parse(url).authority != Uri.parse(BuildConfig.redirectURI).authority) {
            isPageLoading(false)
        }
    }

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url = request?.url
        if (url != null && URL.isRedirectUri(url)) {
            url.getQueryParameter(Queries.code)?.let { code(it) }
            url.getQueryParameter(Queries.error)?.let { error(it) }
        }
        return false
    }

}