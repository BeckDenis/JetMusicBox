package denis.beck.jetmusicbox.screens.dashboard.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import denis.beck.jetmusicbox.networking.responses.AlbumResponse
import denis.beck.jetmusicbox.networking.responses.PlaylistResponse
import denis.beck.jetmusicbox.screens.dashboard.main.models.MainState
import denis.beck.jetmusicbox.views.DoubleRow
import denis.beck.jetmusicbox.views.Label
import denis.beck.jetmusicbox.views.MyText

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val uiState = viewModel.uiState

    when (val currentState = uiState.value) {
        is MainState.Idle -> MainScreenUI_Idle(currentState)
    }
}

@Composable
fun MainScreenUI_Idle(idleState: MainState.Idle) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState),
    ) {
        Label(text = "New Releases") {
            DoubleRow(idleState.albums ?: return@Label) { album ->
                Album(album)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Label(text = "Featured Playlists") {
            DoubleRow(idleState.playlists ?: return@Label) { playlist ->
                Playlist(playlist)
            }
        }
    }
}

@Composable
private fun Album(album: AlbumResponse) {
    Row(modifier = Modifier.width(250.dp)) {
        Image(
            painter = rememberImagePainter(album.images.first().url),
            contentDescription = null,
            modifier = Modifier
                .size(96.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        Column {
            MyText(text = album.name, lines = 2)
        }
    }
}


@Composable
private fun Playlist(playlist: PlaylistResponse) {
    Image(
        painter = rememberImagePainter(playlist.images.first().url),
        contentDescription = null,
        modifier = Modifier
            .size(128.dp)
            .clip(MaterialTheme.shapes.medium)
    )
}