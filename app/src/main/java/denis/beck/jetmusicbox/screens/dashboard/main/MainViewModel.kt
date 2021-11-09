package denis.beck.jetmusicbox.screens.dashboard.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.repositories.albums.AlbumsRepository
import denis.beck.jetmusicbox.repositories.playlists.PlaylistsRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    albumsRepository: AlbumsRepository,
    playlistsRepository: PlaylistsRepository,
) : ViewModel() {
    init {
        viewModelScope.launch {
            // Todo: Add global error handler
            try {
                albumsRepository.getNewReleases()
                playlistsRepository.getFeaturedPlaylist()
            } catch (e: Exception) {
                Timber.e(e.message)
            }
        }
    }
}