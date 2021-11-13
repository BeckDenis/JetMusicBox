package denis.beck.jetmusicbox.screens.authentication.web

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.managers.auth.AuthManager
import denis.beck.jetmusicbox.screens.authentication.web.models.AuthWebState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthWebViewModel @Inject constructor(private val authManager: AuthManager) : ViewModel() {

    private val _uiState = MutableLiveData<AuthWebState>(AuthWebState.Loading)
    val uiState: LiveData<AuthWebState> = _uiState

    fun authorize(code: String) {
        viewModelScope.launch {
            val isAuthorize = authManager.authorize(code)
            if (isAuthorize) {
                _uiState.postValue(AuthWebState.Authorized)
            }
        }
    }

}