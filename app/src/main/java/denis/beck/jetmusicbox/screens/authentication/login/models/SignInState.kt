package denis.beck.jetmusicbox.screens.authentication.login.models

import denis.beck.jetmusicbox.core.viewmodel.UiState

sealed class SignInState : UiState {
    object AuthChecking: SignInState()
    object Idle: SignInState()
}