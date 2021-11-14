package denis.beck.jetmusicbox.screens.authentication.web.models

import denis.beck.jetmusicbox.core.viewmodel.UiEvent

sealed class AuthWebEvent : UiEvent {
    data class PageChangedState(val isLoading: Boolean) : AuthWebEvent()
    data class CodeReceived(val code: String): AuthWebEvent()
    object UserAuthorized : AuthWebEvent()
}