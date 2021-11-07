package denis.beck.jetmusicbox.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.repositories.AuthRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    fun authorize(code: String) {
        viewModelScope.launch {
            try {
                Timber.d(authRepository.authorize(code).toString())
            } catch (e: Exception) {
                Timber.e(e.message)
            }
        }
    }

}