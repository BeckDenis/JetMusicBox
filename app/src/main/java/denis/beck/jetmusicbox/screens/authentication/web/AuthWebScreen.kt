package denis.beck.jetmusicbox.screens.authentication.web

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import denis.beck.jetmusicbox.navigation.Root
import denis.beck.jetmusicbox.networking.URL
import denis.beck.jetmusicbox.screens.authentication.web.models.AuthWebEffect
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun AuthWebScreen(
    navController: NavController,
    viewModel: AuthWebViewModel
) {

    val uiState = viewModel.uiState
    val effect = viewModel.effect

    LaunchedEffect(key1 = "firstLaunch") {
        effect.onEach { effect ->
            when (effect) {
                is AuthWebEffect.Navigate.ToMain -> {
                    navController.navigate(Root.Main.route) {
                        popUpTo(Root.Login.route) {  inclusive = true }
                    }
                }
            }
        }.collect { }
    }

    AuthWebUI(viewModel)
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
private fun AuthWebUI(viewModel: AuthWebViewModel) {
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