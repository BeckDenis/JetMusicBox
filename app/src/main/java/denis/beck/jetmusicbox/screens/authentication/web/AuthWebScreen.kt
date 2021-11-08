package denis.beck.jetmusicbox.screens.authentication.web

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import denis.beck.jetmusicbox.navigation.Root
import denis.beck.jetmusicbox.networking.URL
import denis.beck.jetmusicbox.screens.authentication.web.models.AuthWebUiState
import denis.beck.jetmusicbox.views.AuthWebViewClient

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun AuthWebScreen(
    navController: NavController,
    viewModel: AuthWebViewModel
) {

    val uiState = viewModel.uiState.observeAsState()

    LaunchedEffect(key1 = uiState.value) {
        if (uiState.value is AuthWebUiState.Authorized) {
            navController.navigate(Root.Main.route) {
                popUpTo(Root.Login.route) {  inclusive = true }
            }
        }
    }

    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = AuthWebViewClient(
                    code = { code ->
                        viewModel.authorize(code = code)
                    },
                    error = {}
                )
                settings.javaScriptEnabled = true
                loadUrl(URL.auth)
            }
        }
    )
}