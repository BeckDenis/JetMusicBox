package denis.beck.jetmusicbox.screens

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import denis.beck.jetmusicbox.networking.URL
import denis.beck.jetmusicbox.views.AuthWebViewClient

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun AuthWebScreen() {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = AuthWebViewClient {
                }
                settings.javaScriptEnabled = true
                loadUrl(URL.auth)
            }
        }
    )
}