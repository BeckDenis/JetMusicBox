package denis.beck.jetmusicbox.networking.responses

import kotlinx.serialization.SerialName

data class NewReleasesResponse(
    @SerialName("albums") val albums: Albums
)

data class Albums(
    @SerialName("href") val href: String,
    @SerialName("items") val items: List<Items>,
    @SerialName("limit") val limit: Int,
    @SerialName("next") val next: String,
    @SerialName("offset") val offset: Int,
    @SerialName("previous") val previous: String,
    @SerialName("total") val total: Int,
)

data class Items(
    @SerialName("album_type") val album_type: String,
    @SerialName("artists") val artists: List<Artists>,
    @SerialName("available_markets") val available_markets: List<String>,
    @SerialName("external_urls") val external_urls: ExternalUrls,
    @SerialName("href") val href: String,
    @SerialName("id") val id: String,
    @SerialName("images") val images: List<Images>,
    @SerialName("name") val name: String,
    @SerialName("release_date") val release_date: String,
    @SerialName("release_date_precision") val release_date_precision: String,
    @SerialName("total_tracks") val total_tracks: Int,
    @SerialName("type") val type: String,
    @SerialName("uri") val uri: String,
)

data class Artists(
    @SerialName("external_urls") val external_urls: ExternalUrls,
    @SerialName("href") val href: String,
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("type") val type: String,
    @SerialName("uri") val uri: String,
)

data class ExternalUrls(
    @SerialName("spotify") val spotify: String,
)

data class Images(
    @SerialName("height") val height: Int,
    @SerialName("url") val url: String,
    @SerialName("width") val width: Int,
)