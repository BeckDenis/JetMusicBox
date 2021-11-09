package denis.beck.jetmusicbox.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denis.beck.jetmusicbox.repositories.albums.AlbumsRepository
import denis.beck.jetmusicbox.repositories.albums.AlbumsRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    @Singleton
    abstract fun provideAlbumsRepository(albumsRepositoryImpl: AlbumsRepositoryImpl): AlbumsRepository

}