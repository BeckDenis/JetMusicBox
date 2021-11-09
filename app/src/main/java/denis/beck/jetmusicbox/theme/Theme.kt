package denis.beck.jetmusicbox.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColors = lightColors()
private val DarkColors = darkColors()

@Composable
fun MyTheme(themeStyle: ThemeStyle, content: @Composable () -> Unit) {
    MaterialTheme(
        colors = getColors(themeStyle),
        shapes = MyShape,
        typography = MyTypography,
        content = content,
    )
}

private fun getColors(style: ThemeStyle): Colors = when (style) {
    ThemeStyle.Dark -> DarkColors
    ThemeStyle.Light -> LightColors

}
