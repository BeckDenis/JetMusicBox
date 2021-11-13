package denis.beck.jetmusicbox.screens.authentication.web.models

import denis.beck.jetmusicbox.core.viewmodel.UiState

sealed class AuthWebState : UiState {
    object Loading : AuthWebState()
    object Idle : AuthWebState()
    object NoConnection : AuthWebState()
    object Authorized : AuthWebState()
}