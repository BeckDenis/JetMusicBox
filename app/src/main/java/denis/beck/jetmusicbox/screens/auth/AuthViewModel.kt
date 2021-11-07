package denis.beck.jetmusicbox.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.managers.auth.AuthManager
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authManager: AuthManager) : ViewModel() {

    fun authorize(code: String) {
        viewModelScope.launch {
            authManager.authorize(code)
        }
    }

}