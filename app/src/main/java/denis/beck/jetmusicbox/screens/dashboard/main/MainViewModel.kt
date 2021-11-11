package denis.beck.jetmusicbox.screens.dashboard.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.repositories.albums.AlbumsRepository
import denis.beck.jetmusicbox.repositories.playlists.PlaylistsRepository
import denis.beck.jetmusicbox.screens.dashboard.main.models.MainUiState
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    albumsRepository: AlbumsRepository,
    playlistsRepository: PlaylistsRepository,
) : ViewModel() {

    private val _uiState = MutableLiveData<MainUiState>(MainUiState.Loading)
    val uiState: LiveData<MainUiState> = _uiState

    init {
        viewModelScope.launch {
            // Todo: Add global error handler
            try {
                val albums = async { albumsRepository.getNewReleases() }
                val playlists = async { playlistsRepository.getFeaturedPlaylist() }
                _uiState.postValue(
                    MainUiState.Idle(
                        albums = albums.await().albums.items,
                        playlists = playlists.await().playlists.items
                    )
                )
            } catch (e: Exception) {
                Timber.e(e.message)
            }
        }
    }
}