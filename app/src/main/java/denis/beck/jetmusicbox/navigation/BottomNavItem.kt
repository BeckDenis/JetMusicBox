package denis.beck.jetmusicbox.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val root: Root,
    val label: String,
    val iconId: ImageVector,
) {
    object Main: BottomNavItem(Root.Main, "Main", Icons.Rounded.Home)
}