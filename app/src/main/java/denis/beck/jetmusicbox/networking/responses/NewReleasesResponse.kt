package denis.beck.jetmusicbox.networking.responses

import kotlinx.serialization.SerialName

data class NewReleasesResponse(
    @SerialName("albums") val albums: Albums
)

data class Albums(
    @SerialName("href") val href: String,
    @SerialName("items") val items: List<Album>,
    @SerialName("limit") val limit: Int,
    @SerialName("next") val next: String,
    @SerialName("offset") val offset: Int,
    @SerialName("previous") val previous: String,
    @SerialName("total") val total: Int,
)

data class Album(
    @SerialName("album_type") val albumType: String,
    @SerialName("artists") val artists: List<Artist>,
    @SerialName("available_markets") val availableMarkets: List<String>,
    @SerialName("external_urls") val externalUrl: ExternalUrl,
    @SerialName("href") val href: String,
    @SerialName("id") val id: String,
    @SerialName("images") val images: List<Images>,
    @SerialName("name") val name: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("release_date_precision") val releaseDatePrecision: String,
    @SerialName("total_tracks") val totalTracks: Int,
    @SerialName("type") val type: String,
    @SerialName("uri") val uri: String,
)

data class Artist(
    @SerialName("external_urls") val externalUrl: ExternalUrl,
    @SerialName("href") val href: String,
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("type") val type: String,
    @SerialName("uri") val uri: String,
)

data class ExternalUrl(
    @SerialName("spotify") val spotify: String,
)

data class Images(
    @SerialName("height") val height: Int,
    @SerialName("url") val url: String,
    @SerialName("width") val width: Int,
)