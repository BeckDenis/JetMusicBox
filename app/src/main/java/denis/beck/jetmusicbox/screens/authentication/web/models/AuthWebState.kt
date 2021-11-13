package denis.beck.jetmusicbox.screens.authentication.web.models

sealed class AuthWebState {
    object Loading: AuthWebState()
    object Idle: AuthWebState()
    object NoConnection: AuthWebState()
    object Authorized: AuthWebState()
}