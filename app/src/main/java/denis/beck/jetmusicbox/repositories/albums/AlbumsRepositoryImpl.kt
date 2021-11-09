package denis.beck.jetmusicbox.repositories.albums

import denis.beck.jetmusicbox.networking.apis.SpotifyApi
import javax.inject.Inject

class AlbumsRepositoryImpl @Inject constructor(private val spotifyApi: SpotifyApi) :
    AlbumsRepository {

    override suspend fun getNewReleases() = spotifyApi.getNewReleases()

}