package denis.beck.jetmusicbox.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColors = lightColors()
private val DarkColors = darkColors()

@Composable
fun MyTheme(themeStyle: ThemeStyle = themeStyle(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = getColors(themeStyle),
        shapes = MyShape,
        typography = MyTypography,
        content = content,
    )
}

@Composable
fun themeStyle(): ThemeStyle = if (isSystemInDarkTheme()) ThemeStyle.Dark else ThemeStyle.Dark

private fun getColors(style: ThemeStyle): Colors = when (style) {
    ThemeStyle.Dark -> DarkColors
    ThemeStyle.Light -> LightColors

}
