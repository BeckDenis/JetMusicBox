package denis.beck.jetmusicbox.screens.authentication.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import denis.beck.jetmusicbox.R
import denis.beck.jetmusicbox.navigation.Root
import denis.beck.jetmusicbox.navigation.Screen
import denis.beck.jetmusicbox.screens.authentication.login.models.SignInEffect
import denis.beck.jetmusicbox.screens.authentication.login.models.SignInEvent
import denis.beck.jetmusicbox.screens.authentication.login.models.SignInState
import denis.beck.jetmusicbox.theme.MyTheme
import denis.beck.jetmusicbox.theme.ThemeStyle
import denis.beck.jetmusicbox.views.MyButton
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun SignInScreen(navController: NavController, viewModel: SignInViewModel) {
    val uiState = viewModel.uiState
    val effect = viewModel.effect

    when (uiState.value) {
        SignInState.AuthChecking -> SignInScreenUI_AuthChecking()
        SignInState.Idle -> SignInScreenUI_Idle(viewModel::setEvent)
    }

    LaunchedEffect(key1 = "firstLaunch") {
        effect.onEach { effect ->
            when (effect) {
                is SignInEffect.Navigation.ToMain -> {
                    navController.navigate(Root.Main.route) {
                        popUpTo(Root.Login.route) { inclusive = true }
                    }
                }
                is SignInEffect.Navigation.ToAuthWeb -> {
                    navController.navigate(Screen.AuthWeb.route)
                }
            }
        }.collect { }
    }
}

@Composable
private fun SignInScreenUI_AuthChecking() {
    Box(modifier = Modifier.background(MaterialTheme.colors.background), content = {})
}

@Composable
private fun SignInScreenUI_Idle(event: (SignInEvent) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(start = 44.dp, end = 44.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppIcon()
        Box(modifier = Modifier.weight(0.2f), contentAlignment = Alignment.Center) {
            MyButton(text = "Sign In", onClick = { event.invoke(SignInEvent.SignInButtonClick) })
        }
    }
}

@Composable
private fun ColumnScope.AppIcon() {
    Box(modifier = Modifier.weight(0.8f), contentAlignment = Alignment.Center) {
        Icon(
            painter = painterResource(id = R.drawable.ic_app),
            tint = MaterialTheme.colors.primary,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
        )
    }
}

@Composable
@Preview
private fun LoginScreenUIDark_Preview() {
    MyTheme(ThemeStyle.Dark) {
        SignInScreenUI_Idle()
    }
}

@Composable
@Preview
private fun LoginScreenUILight_Preview() {
    MyTheme(ThemeStyle.Light) {
        SignInScreenUI_Idle()
    }
}

