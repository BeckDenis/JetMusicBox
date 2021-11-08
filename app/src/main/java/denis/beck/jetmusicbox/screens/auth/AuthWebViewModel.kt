package denis.beck.jetmusicbox.screens.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.managers.auth.AuthManager
import denis.beck.jetmusicbox.screens.auth.models.AuthWebUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthWebViewModel @Inject constructor(private val authManager: AuthManager) : ViewModel() {

    private val _uiState = MutableLiveData<AuthWebUiState>(AuthWebUiState.Loading)
    val uiState: LiveData<AuthWebUiState> = _uiState

    fun authorize(code: String) {
        viewModelScope.launch {
            val isAuthorize = authManager.authorize(code)
            if (isAuthorize) {
                _uiState.postValue(AuthWebUiState.Authorized)
            }
        }
    }

}