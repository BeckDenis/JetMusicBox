package denis.beck.jetmusicbox.repositories.albums

interface AlbumsRepository {
    suspend fun getNewReleases()
}