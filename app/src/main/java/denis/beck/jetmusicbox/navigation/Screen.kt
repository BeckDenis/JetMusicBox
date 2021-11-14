package denis.beck.jetmusicbox.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object AuthWeb : Screen("auth_web")
    object Main : Screen("main")

    companion object {
        fun isNavBarVisible(route: String?) = when (route) {
            Login.route, AuthWeb.route, null -> false
            else -> true
        }
    }
}