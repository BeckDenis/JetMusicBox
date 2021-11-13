package denis.beck.jetmusicbox.screens.authentication.login.models

import denis.beck.jetmusicbox.core.viewmodel.UiSideEffect

sealed class SignInSideEffect : UiSideEffect {


    sealed class Navigation : SignInSideEffect() {
        object ToMain: Navigation()
        object ToAuthWeb : Navigation()
    }
}