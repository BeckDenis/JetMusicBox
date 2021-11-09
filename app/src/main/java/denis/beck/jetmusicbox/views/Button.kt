package denis.beck.jetmusicbox.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import denis.beck.jetmusicbox.theme.MyTheme
import denis.beck.jetmusicbox.theme.ThemeStyle

@Composable
fun MyButton(text: String, onClick: () -> Unit = {}) = Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
    contentPadding = PaddingValues(),
    modifier = Modifier
        .fillMaxWidth()
        .height(44.dp),
    elevation = ButtonDefaults.elevation(
        defaultElevation = 8.dp,
        pressedElevation = 2.dp,
        disabledElevation = 0.dp
    ),
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colors.primary,
                        MaterialTheme.colors.primaryVariant
                    )
                )
            )
    ) {
        Text(
            text = text.uppercase(),
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onPrimary,
        )
    }
}

@Composable
@Preview
private fun MyButtonDark_Preview() {
    MyTheme(ThemeStyle.Dark) {
        MyButton(text = "Button")
    }
}

@Composable
@Preview
private fun MyButtonLight_Preview() {
    MyTheme(ThemeStyle.Light) {
        MyButton(text = "Button")
    }
}