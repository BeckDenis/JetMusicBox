package denis.beck.jetmusicbox.screens.dashboard.main.models

import denis.beck.jetmusicbox.core.viewmodel.UiState
import denis.beck.jetmusicbox.networking.responses.AlbumResponse
import denis.beck.jetmusicbox.networking.responses.PlaylistResponse

sealed class MainState : UiState {
    object Loading : MainState()
    data class Idle(
        val albums: List<AlbumResponse>? = null,
        val playlists: List<PlaylistResponse>? = null
    ) : MainState()
}