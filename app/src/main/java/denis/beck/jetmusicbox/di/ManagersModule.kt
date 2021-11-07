package denis.beck.jetmusicbox.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denis.beck.jetmusicbox.managers.auth.AuthManager
import denis.beck.jetmusicbox.managers.auth.AuthManagerImpl
import denis.beck.jetmusicbox.managers.authData.AuthDataManager
import denis.beck.jetmusicbox.managers.authData.AuthDataManagerImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class ManagersModule {

    @Binds
    abstract fun provideAuthManager(authManagerImpl: AuthManagerImpl): AuthManager

    @Binds
    @Singleton
    abstract fun provideAuthDataManager(authDataManagerImpl: AuthDataManagerImpl): AuthDataManager
}