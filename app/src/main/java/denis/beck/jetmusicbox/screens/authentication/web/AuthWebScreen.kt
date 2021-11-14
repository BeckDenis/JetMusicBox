package denis.beck.jetmusicbox.screens.authentication.web

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import denis.beck.jetmusicbox.navigation.Root
import denis.beck.jetmusicbox.networking.URL
import denis.beck.jetmusicbox.screens.authentication.web.models.AuthWebEffect
import denis.beck.jetmusicbox.screens.authentication.web.models.AuthWebEvent
import denis.beck.jetmusicbox.screens.authentication.web.models.AuthWebState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun AuthWebScreen(
    navController: NavController,
    viewModel: AuthWebViewModel,
) {
    val uiState = viewModel.uiState
    val effect = viewModel.effect

    LaunchedEffect(key1 = "firstLaunch") {
        effect.onEach { effect ->
            handleEffect(effect, navController)
        }.collect { }
    }

    AuthWebUI(state = uiState.value, event = viewModel::setEvent)
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
private fun AuthWebUI(state: AuthWebState, event: (AuthWebEvent) -> Unit) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = AuthWebViewClient(
                    isPageLoading = { isLoading ->
                        event(AuthWebEvent.PageChangedState(isLoading))
                    },
                    code = { code ->
                        event(AuthWebEvent.CodeReceived(code))
                    },
                    error = {}
                )
                settings.javaScriptEnabled = true
                loadUrl(URL.auth)
            }
        }
    )

    if (state == AuthWebState.Idle(isLoading = true)) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center) {

            CircularProgressIndicator()
        }
    }
}

private fun handleEffect(
    effect: AuthWebEffect,
    navController: NavController,
) {
    when (effect) {
        is AuthWebEffect.Navigate.ToMain -> {
            navController.navigate(Root.Main.route) {
                popUpTo(Root.Login.route) { inclusive = true }
            }
        }
    }
}