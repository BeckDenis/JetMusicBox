package denis.beck.jetmusicbox.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denis.beck.jetmusicbox.managers.auth.AuthManager
import denis.beck.jetmusicbox.managers.auth.AuthManagerImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class ManagersModule {

    @Binds
    abstract fun provideAuthManager(authManagerImpl: AuthManagerImpl): AuthManager

}