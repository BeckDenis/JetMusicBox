package denis.beck.jetmusicbox.screens.dashboard.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.core.viewmodel.BaseViewModel
import denis.beck.jetmusicbox.networking.Result
import denis.beck.jetmusicbox.repositories.albums.AlbumsRepository
import denis.beck.jetmusicbox.repositories.playlists.PlaylistsRepository
import denis.beck.jetmusicbox.screens.dashboard.main.models.MainEffect
import denis.beck.jetmusicbox.screens.dashboard.main.models.MainEvent
import denis.beck.jetmusicbox.screens.dashboard.main.models.MainState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val albumsRepository: AlbumsRepository,
    private val playlistsRepository: PlaylistsRepository,
) : BaseViewModel<MainEvent, MainState, MainEffect>() {

    init {
        getFeaturedPlaylists()
        getNewReleases()
    }

    private fun getFeaturedPlaylists() {
        viewModelScope.launch {
            val result = playlistsRepository.getFeaturedPlaylist()
            val state = uiState.value
            if (result is Result.Success && state is MainState.Idle) setState {
                state.copy(playlists = result.data.playlists.items)
            }
        }
    }

    private fun getNewReleases() {
        viewModelScope.launch {
            val result = albumsRepository.getNewReleases()
            val state = uiState.value
            if (result is Result.Success && state is MainState.Idle) setState {
                state.copy(albums = result.data.albums.items)
            }
        }
    }

    override fun setInitialState() = MainState.Idle()

    override fun handleEvents(event: MainEvent) {
        TODO("Not yet implemented")
    }
}