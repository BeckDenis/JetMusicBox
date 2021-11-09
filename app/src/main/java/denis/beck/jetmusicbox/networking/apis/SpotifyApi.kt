package denis.beck.jetmusicbox.networking.apis

import retrofit2.http.GET

interface SpotifyApi {

    @GET("browse/new-releases")
    suspend fun getNewReleases()

}