package denis.beck.jetmusicbox.di

import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class Named(val value: RetrofitType) {
}

enum class RetrofitType {
    Auth, Base,
}