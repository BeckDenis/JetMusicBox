package denis.beck.jetmusicbox.views

import androidx.compose.foundation.layout.height
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun MyText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
    lines: Int? = null,
) {
    var _lineHeight = lineHeight

    if (lines != null) {
        _lineHeight = style.fontSize * 4 / 3
        modifier.height(with(LocalDensity.current) {
            (_lineHeight * lines).toDp()
        })
    }

    Text(
        text = text,
        modifier = modifier.setUpModifier(lines, _lineHeight),
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = _lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = lines ?: maxLines,
        onTextLayout = onTextLayout,
        style = style
    )
}

@Composable
private fun Modifier.setUpModifier(lines: Int?, _lineHeight: TextUnit): Modifier =
    if (lines != null) {
        this.height(with(LocalDensity.current) {
            (_lineHeight * lines).toDp()
        })
    } else this

