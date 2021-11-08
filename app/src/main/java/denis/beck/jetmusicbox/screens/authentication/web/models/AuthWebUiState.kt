package denis.beck.jetmusicbox.screens.authentication.web.models

sealed class AuthWebUiState {
    object Loading: AuthWebUiState()
    object Idle: AuthWebUiState()
    object NoConnection: AuthWebUiState()
    object Authorized: AuthWebUiState()
}