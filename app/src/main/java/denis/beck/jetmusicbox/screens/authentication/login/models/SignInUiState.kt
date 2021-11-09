package denis.beck.jetmusicbox.screens.authentication.login.models

sealed class SignInUiState {
    object Idle: SignInUiState()
    object Authorized: SignInUiState()
}