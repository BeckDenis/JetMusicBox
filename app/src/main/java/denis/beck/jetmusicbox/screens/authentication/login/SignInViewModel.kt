package denis.beck.jetmusicbox.screens.authentication.login

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denis.beck.jetmusicbox.core.viewmodel.BaseViewModel
import denis.beck.jetmusicbox.managers.auth.AuthManager
import denis.beck.jetmusicbox.screens.authentication.login.models.SignInEffect
import denis.beck.jetmusicbox.screens.authentication.login.models.SignInEvent
import denis.beck.jetmusicbox.screens.authentication.login.models.SignInState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(authManager: AuthManager) :
    BaseViewModel<SignInEvent, SignInState, SignInEffect>() {

    init {
        viewModelScope.launch(Dispatchers.IO) { checkAuth(authManager) }
    }

    private suspend fun checkAuth(authManager: AuthManager) {
        if (authManager.isAuthorize()) {
            setEffect { SignInEffect.Navigation.ToMain }
        } else {
            setState { SignInState.Idle }
        }
    }

    override fun setInitialState() = SignInState.AuthChecking

    override fun handleEvents(event: SignInEvent) {
        when (event) {
            is SignInEvent.SignInButtonClick -> setEffect {
                SignInEffect.Navigation.ToAuthWeb
            }
        }
    }

}