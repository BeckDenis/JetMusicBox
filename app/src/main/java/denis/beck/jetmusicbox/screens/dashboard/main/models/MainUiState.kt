package denis.beck.jetmusicbox.screens.dashboard.main.models

import denis.beck.jetmusicbox.networking.responses.AlbumResponse

sealed class MainUiState {
    object Loading: MainUiState()
    data class Idle(val albums: List<AlbumResponse>): MainUiState()
}