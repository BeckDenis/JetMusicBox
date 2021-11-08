package denis.beck.jetmusicbox.screens.authentication.login.models

sealed class LoginUiState {
    object Idle: LoginUiState()
    object Authorized: LoginUiState()
}