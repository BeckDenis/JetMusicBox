package denis.beck.jetmusicbox.repositories.playlists

import denis.beck.jetmusicbox.networking.ResponseHandler
import denis.beck.jetmusicbox.networking.apis.SpotifyApi
import javax.inject.Inject

class PlaylistsRepositoryImpl @Inject constructor(
    private val responseHandler: ResponseHandler,
    private val spotifyApi: SpotifyApi
) : PlaylistsRepository {

    override suspend fun getFeaturedPlaylist() =
        responseHandler.handleResult(spotifyApi.getFeaturedPlaylists())

}