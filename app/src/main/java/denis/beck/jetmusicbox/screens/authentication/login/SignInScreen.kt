package denis.beck.jetmusicbox.screens.authentication.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import denis.beck.jetmusicbox.R
import denis.beck.jetmusicbox.navigation.Root
import denis.beck.jetmusicbox.navigation.Screen
import denis.beck.jetmusicbox.screens.authentication.login.models.SignInUiState
import denis.beck.jetmusicbox.theme.MyTheme
import denis.beck.jetmusicbox.theme.ThemeStyle
import denis.beck.jetmusicbox.views.MyButton

@Composable
fun LoginScreen(navController: NavController, viewModel: SignInViewModel) {

    val uiState = viewModel.uiState.observeAsState()

    LaunchedEffect(key1 = uiState.value) {
        if (uiState.value is SignInUiState.Authorized) {
            navController.navigate(Root.Main.route) {
                popUpTo(Root.Login.route) { inclusive = true }
            }
        }
    }

    LoginScreenUI(navController)
}

@Composable
private fun LoginScreenUI(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(start = 44.dp, end = 44.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppIcon()
        Box(modifier = Modifier.weight(0.2f), contentAlignment = Alignment.Center) {
            MyButton(text = "Login", onClick = navigateToAuthWeb(navController))
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
private fun navigateToAuthWeb(navController: NavController): () -> Unit = {
    navController.navigate(Screen.AuthWeb.route)
}

@Composable
@Preview
private fun LoginScreenUIDark_Preview() {
    MyTheme(ThemeStyle.Dark) {
        LoginScreenUI(navController = rememberNavController())
    }
}

@Composable
@Preview
private fun LoginScreenUILight_Preview() {
    MyTheme(ThemeStyle.Light) {
        LoginScreenUI(navController = rememberNavController())
    }
}

