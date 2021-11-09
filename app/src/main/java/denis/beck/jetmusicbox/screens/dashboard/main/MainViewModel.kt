package denis.beck.jetmusicbox.screens.dashboard.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.repositories.albums.AlbumsRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(albumsRepository: AlbumsRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            // Todo: Add global error handler
            try {
                albumsRepository.getNewReleases()
            } catch (e: Exception) {
                Timber.e(e.message)
            }
        }
    }
}