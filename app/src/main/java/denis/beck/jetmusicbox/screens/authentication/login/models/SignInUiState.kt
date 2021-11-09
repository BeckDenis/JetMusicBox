package denis.beck.jetmusicbox.screens.authentication.login.models

sealed class SignInUiState {
    object AuthChecking: SignInUiState()
    object Idle: SignInUiState()
    object Authorized: SignInUiState()
}