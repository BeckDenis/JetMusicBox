package denis.beck.jetmusicbox.screens.login.models

sealed class LoginUiState {
    object Idle: LoginUiState()
    object Authorized: LoginUiState()
}