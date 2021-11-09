package denis.beck.jetmusicbox.screens.authentication.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.managers.auth.AuthManager
import denis.beck.jetmusicbox.screens.authentication.login.models.SignInUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(authManager: AuthManager) : ViewModel() {

    private val _uiState = MutableLiveData<SignInUiState>(SignInUiState.AuthChecking)
    val uiState: LiveData<SignInUiState> = _uiState

    init {
        viewModelScope.launch {
            if (authManager.isAuthorize()) {
                _uiState.postValue(SignInUiState.Authorized)
            } else {
                _uiState.postValue(SignInUiState.Idle)
            }
        }
    }

}