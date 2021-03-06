package denis.beck.jetmusicbox.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import denis.beck.jetmusicbox.screens.authentication.login.SignInScreen
import denis.beck.jetmusicbox.screens.authentication.login.SignInViewModel
import denis.beck.jetmusicbox.screens.authentication.web.AuthWebScreen
import denis.beck.jetmusicbox.screens.authentication.web.AuthWebViewModel
import denis.beck.jetmusicbox.screens.dashboard.main.MainScreen
import denis.beck.jetmusicbox.screens.dashboard.main.MainViewModel

@Composable
fun AppNavigation(navController: NavHostController, paddings: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Root.Login.route,
        modifier = Modifier.padding(paddings)
    ) {
        addLoginRoot(navController)
        addMainRoot()
    }
}

private fun NavGraphBuilder.addLoginRoot(navController: NavHostController) {
    navigation(startDestination = Screen.Login.route, route = Root.Login.route) {
        addLoginScreen(navController)
        addAuthWebScreen(navController)
    }
}

private fun NavGraphBuilder.addMainRoot() {
    navigation(startDestination = Screen.Main.route, route = Root.Main.route) {
        composable(Screen.Main.route) {
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(viewModel)
        }
    }
}

private fun NavGraphBuilder.addAuthWebScreen(navController: NavHostController) {
    composable(Screen.AuthWeb.route) {
        val viewModel = hiltViewModel<AuthWebViewModel>()
        AuthWebScreen(navController, viewModel)
    }
}

private fun NavGraphBuilder.addLoginScreen(navController: NavHostController) {
    composable(Screen.Login.route) {
        val viewModel = hiltViewModel<SignInViewModel>()
        SignInScreen(navController, viewModel)
    }
}
