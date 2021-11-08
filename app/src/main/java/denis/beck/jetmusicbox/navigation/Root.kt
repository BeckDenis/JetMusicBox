package denis.beck.jetmusicbox.navigation

sealed class Root(
    val route: String
) {
    object Login : Root("login_root")
    object Main : Root("main_root")
}