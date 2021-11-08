package denis.beck.jetmusicbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import denis.beck.jetmusicbox.extensions.currentRoute
import denis.beck.jetmusicbox.navigation.AppNavigation
import denis.beck.jetmusicbox.navigation.Screen
import denis.beck.jetmusicbox.views.BottomNavBar

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = { SetBottomNavBarIfNeed(navController) }
            ) {
                AppNavigation(navController)
            }
        }
    }

    @Composable
    private fun SetBottomNavBarIfNeed(navController: NavHostController) {
        val route = navController.currentRoute()
        if (Screen.isNavBarVisible(route = route)) {
            BottomNavBar(navController)
        }
    }
}