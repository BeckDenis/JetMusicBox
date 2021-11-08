package denis.beck.jetmusicbox.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import denis.beck.jetmusicbox.navigation.Root
import denis.beck.jetmusicbox.navigation.Screen
import denis.beck.jetmusicbox.screens.login.models.LoginUiState

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel) {

    val uiState = viewModel.uiState.observeAsState()

    LaunchedEffect(key1 = uiState.value) {
        if (uiState.value is LoginUiState.Authorized) {
            navController.navigate(Root.Main.route) {
                popUpTo(Root.Login.route) {  inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 44.dp, end = 44.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login", Modifier.clickable {
            navController.navigate(Screen.AuthWeb.route)
        })
    }
}