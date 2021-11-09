package denis.beck.jetmusicbox.repositories.albums

import denis.beck.jetmusicbox.networking.responses.NewReleasesResponse

interface AlbumsRepository {
    suspend fun getNewReleases() : NewReleasesResponse
}