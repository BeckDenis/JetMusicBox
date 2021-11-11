package denis.beck.jetmusicbox.screens.dashboard.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import denis.beck.jetmusicbox.networking.responses.AlbumResponse
import denis.beck.jetmusicbox.screens.dashboard.main.models.MainUiState
import denis.beck.jetmusicbox.views.DoubleRow
import denis.beck.jetmusicbox.views.Label
import denis.beck.jetmusicbox.views.MyText

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val uiState = viewModel.uiState.observeAsState(initial = MainUiState.Loading)

    when (val currentState = uiState.value) {
        is MainUiState.Idle -> MainScreenUI_Idle(currentState.albums)
    }
}

@Composable
fun MainScreenUI_Idle(albums: List<AlbumResponse>) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState),
    ) {
        Label(text = "New Releases") {
            DoubleRow(albums) { album ->
                Album(album)
            }
        }
    }
}


@Composable
private fun Album(album: AlbumResponse) {
    Image(
        painter = rememberImagePainter(album.images.first().url),
        contentDescription = null,
        modifier = Modifier
            .size(128.dp)
            .clip(MaterialTheme.shapes.medium)
    )

    MyText(
        text = album.name,
        lines = 2,
        style = MaterialTheme.typography.subtitle2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .width(128.dp)
    )
}