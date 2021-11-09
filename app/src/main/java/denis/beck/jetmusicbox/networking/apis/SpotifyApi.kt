package denis.beck.jetmusicbox.networking.apis

import denis.beck.jetmusicbox.networking.responses.FeaturedPlaylistsResponse
import denis.beck.jetmusicbox.networking.responses.NewReleasesResponse
import retrofit2.http.GET

interface SpotifyApi {

    @GET("browse/new-releases")
    suspend fun getNewReleases() : NewReleasesResponse

    @GET("browse/featured-playlists")
    suspend fun getFeaturedPlaylists() : FeaturedPlaylistsResponse

}