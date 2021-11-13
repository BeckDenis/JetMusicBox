package denis.beck.jetmusicbox.screens.authentication.web

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.core.viewmodel.BaseViewModel
import denis.beck.jetmusicbox.managers.auth.AuthManager
import denis.beck.jetmusicbox.screens.authentication.web.models.AuthWebEffect
import denis.beck.jetmusicbox.screens.authentication.web.models.AuthWebEvent
import denis.beck.jetmusicbox.screens.authentication.web.models.AuthWebState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthWebViewModel @Inject constructor(private val authManager: AuthManager) :
    BaseViewModel<AuthWebEvent, AuthWebState, AuthWebEffect>() {

    override fun setInitialState() = AuthWebState.Loading

    override fun handleEvents(event: AuthWebEvent) {
        when (event) {
            is AuthWebEvent.UserAuthorized -> setEffect {
                AuthWebEffect.Navigate.ToMain
            }
        }
    }

    fun authorize(code: String) {
        viewModelScope.launch {
            val isAuthorize = authManager.authorize(code)
            if (isAuthorize) setEvent(AuthWebEvent.UserAuthorized)
        }
    }

}