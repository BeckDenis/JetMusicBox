package denis.beck.jetmusicbox.screens.dashboard.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.repositories.albums.AlbumsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(albumsRepository: AlbumsRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            albumsRepository.getNewReleases()
        }
    }
}