package denis.beck.jetmusicbox.screens.auth.models

sealed class AuthWebUiState {
    object Loading: AuthWebUiState()
    object Idle: AuthWebUiState()
    object NoConnection: AuthWebUiState()
    object Authorized: AuthWebUiState()
}