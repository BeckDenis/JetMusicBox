package denis.beck.jetmusicbox.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import denis.beck.jetmusicbox.R

private val CaviarDreams = FontFamily(
    Font(R.font.caviar_dreams_regular, FontWeight.Normal),
    Font(R.font.caviar_dreams_bold, FontWeight.Bold)
)

val MyTypography = Typography(
    button = TextStyle(
        fontFamily = CaviarDreams,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
)