package denis.beck.jetmusicbox.networking.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FeaturedPlaylistsResponse(
    @SerialName("message") val message: String,
    @SerialName("playlists") val playlists: PlaylistsResponse,
)

@Serializable
data class PlaylistsResponse(
    @SerialName("href") val href: String,
    @SerialName("items") val items: List<PlaylistResponse>,
    @SerialName("limit") val limit: Int,
    @SerialName("next") val next: String?,
    @SerialName("offset") val offset: Int,
    @SerialName("previous") val previous: String?,
    @SerialName("total") val total: Int,
)

@Serializable
data class PlaylistResponse(
    @SerialName("collaborative") val collaborative: Boolean,
    @SerialName("description") val description: String,
    @SerialName("external_urls") val external_urls: ExternalUrlResponse,
    @SerialName("href") val href: String,
    @SerialName("id") val id: String,
    @SerialName("images") val images: List<ImageResponse>,
    @SerialName("name") val name: String,
    @SerialName("owner") val owner: OwnerResponse,
    @SerialName("primary_color") val primaryColor: String?,
    @SerialName("public") val public: String?,
    @SerialName("snapshot_id") val snapshotId: String,
    @SerialName("tracks") val tracks: TrackResponse,
    @SerialName("type") val type: String,
    @SerialName("uri") val uri: String,
)

@Serializable
data class OwnerResponse(
    @SerialName("display_name") val displayName: String,
    @SerialName("external_urls") val externalUrls: ExternalUrlResponse,
    @SerialName("href") val href: String,
    @SerialName("id") val id: String,
    @SerialName("type") val type: String,
    @SerialName("uri") val uri: String,
)

@Serializable
data class TrackResponse(
    @SerialName("href") val href: String,
    @SerialName("total") val total: Int,
)