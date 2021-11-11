package denis.beck.jetmusicbox.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import denis.beck.jetmusicbox.extensions.zipByPairs

@Composable
fun <T> DoubleRow(
    albums: Iterable<T>,
    contentPadding: PaddingValues = PaddingValues(start = 16.dp, end = 16.dp),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(16.dp),
    verticalSpace: Dp = 8.dp,
    content: @Composable (T) -> Unit
) {
    val listOfPairs = albums.zipByPairs()
    LazyRow(
        contentPadding = contentPadding,
        horizontalArrangement = horizontalArrangement
    ) {
        items(
            items = listOfPairs
        ) { item ->
            Column() {
                content(item.first)
                Spacer(modifier = Modifier.size(verticalSpace))
                content(item.second)
            }
        }
    }
}