package denis.beck.jetmusicbox.views

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import denis.beck.jetmusicbox.navigation.BottomNavItem

private val bottomNavItems = listOf(
    BottomNavItem.Main
)

@Composable
fun BottomNavBar(
    navController: NavController
) = BottomNavigation(
    backgroundColor = MaterialTheme.colors.background,
    elevation = 10.dp,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    bottomNavItems.forEach { item ->
        BottomNavigationItem(
            icon = {
                Icon(item.iconId, contentDescription = null)
            },
            label = { Text(item.label) },
            selected = currentDestination?.hierarchy?.any { it.route == item.root.route } == true,
            onClick = {
                navController.navigate(item.root.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        // FixMe: Extract Methods
                        saveState =
                            currentDestination?.hierarchy?.any { it.route == item.root.route } != true ||
                                    currentDestination.parent?.startDestinationRoute == currentDestination.route
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}
