package denis.beck.jetmusicbox.screens.authentication.login.models

import denis.beck.jetmusicbox.core.viewmodel.UiEvent

sealed class SignInEvent: UiEvent {
    object SignInButtonClick: SignInEvent()
}