package denis.beck.jetmusicbox.repositories.playlists

import denis.beck.jetmusicbox.networking.responses.FeaturedPlaylistsResponse

interface PlaylistsRepository {
    suspend fun getFeaturedPlaylist() : FeaturedPlaylistsResponse
}