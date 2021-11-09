package denis.beck.jetmusicbox.screens.dashboard.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import denis.beck.jetmusicbox.networking.responses.AlbumResponse
import denis.beck.jetmusicbox.screens.dashboard.main.models.MainUiState

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val uiState = viewModel.uiState.observeAsState(initial = MainUiState.Loading)

    when (val currentState = uiState.value) {
        is MainUiState.Idle -> MainScreenUI_Idle(currentState.albums)
    }
}

@Composable
fun MainScreenUI_Idle(albums: List<AlbumResponse>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyRow(contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(
                items = albums
            ) { album ->
                Column(modifier = Modifier.width(128.dp)) {
                    Image(
                        painter = rememberImagePainter(album.images.first().url),
                        contentDescription = null,
                        modifier = Modifier
                            .size(128.dp)
                            .clip(MaterialTheme.shapes.medium)
                    )
                    Text(text = album.name, maxLines = 2)
                }
            }
        }
    }
}