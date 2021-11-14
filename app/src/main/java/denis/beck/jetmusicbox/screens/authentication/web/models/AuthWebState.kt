package denis.beck.jetmusicbox.screens.authentication.web.models

import denis.beck.jetmusicbox.core.viewmodel.UiState

sealed class AuthWebState : UiState {
    data class Idle(val isLoading: Boolean) : AuthWebState()
    object NoConnection : AuthWebState()
}

fun AuthWebState.isLoading() = this == AuthWebState.Idle(isLoading = true)