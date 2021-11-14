package denis.beck.jetmusicbox.screens.dashboard.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.networking.Result
import denis.beck.jetmusicbox.repositories.albums.AlbumsRepository
import denis.beck.jetmusicbox.repositories.playlists.PlaylistsRepository
import denis.beck.jetmusicbox.screens.dashboard.main.models.MainState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val albumsRepository: AlbumsRepository,
    private val playlistsRepository: PlaylistsRepository,
) : ViewModel() {

    private val _uiState = MutableLiveData<MainState>(MainState.Idle())
    val state: LiveData<MainState> = _uiState

    init {
        getFeaturedPlaylists()
        getNewReleases()
    }

    private fun getFeaturedPlaylists() {
        viewModelScope.launch {
            val result = playlistsRepository.getFeaturedPlaylist()
            val state = state.value
            if (result is Result.Success && state is MainState.Idle) {
                _uiState.postValue(state.copy(playlists = result.data.playlists.items))
            }
        }
    }

    private fun getNewReleases() {
        viewModelScope.launch {
            val result = albumsRepository.getNewReleases()
            val state = state.value
            if (result is Result.Success && state is MainState.Idle) {
                _uiState.postValue(state.copy(albums = result.data.albums.items))
            }
        }
    }
}