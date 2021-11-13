package denis.beck.jetmusicbox.screens.authentication.web.models

import denis.beck.jetmusicbox.core.viewmodel.UiSideEffect

sealed class AuthWebEffect : UiSideEffect {
    sealed class Navigate: AuthWebEffect() {
        object ToMain: Navigate()
    }
}