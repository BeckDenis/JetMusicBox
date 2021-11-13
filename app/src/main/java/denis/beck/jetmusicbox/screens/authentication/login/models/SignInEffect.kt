package denis.beck.jetmusicbox.screens.authentication.login.models

import denis.beck.jetmusicbox.core.viewmodel.UiSideEffect

sealed class SignInEffect : UiSideEffect {


    sealed class Navigation : SignInEffect() {
        object ToMain: Navigation()
        object ToAuthWeb : Navigation()
    }
}