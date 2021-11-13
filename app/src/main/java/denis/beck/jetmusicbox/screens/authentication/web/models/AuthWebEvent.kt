package denis.beck.jetmusicbox.screens.authentication.web.models

import denis.beck.jetmusicbox.core.viewmodel.UiEvent

sealed class AuthWebEvent : UiEvent {
    object UserAuthorized : AuthWebEvent()
}