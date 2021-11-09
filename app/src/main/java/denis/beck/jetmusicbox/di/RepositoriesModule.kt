package denis.beck.jetmusicbox.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denis.beck.jetmusicbox.repositories.albums.AlbumsRepository
import denis.beck.jetmusicbox.repositories.albums.AlbumsRepositoryImpl
import denis.beck.jetmusicbox.repositories.authData.AuthDataRepository
import denis.beck.jetmusicbox.repositories.authData.AuthDataRepositoryImpl
import denis.beck.jetmusicbox.repositories.playlists.PlaylistsRepository
import denis.beck.jetmusicbox.repositories.playlists.PlaylistsRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    @Singleton
    abstract fun provideAlbumsRepository(
        albumsRepositoryImpl: AlbumsRepositoryImpl
    ): AlbumsRepository

    @Binds
    @Singleton
    abstract fun providePlaylistsRepository(
        playlistsRepositoryImpl: PlaylistsRepositoryImpl
    ): PlaylistsRepository

    @Binds
    @Singleton
    abstract fun provideAuthDataRepository(
        authDataManagerImpl: AuthDataRepositoryImpl
    ): AuthDataRepository

}