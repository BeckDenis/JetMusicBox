package denis.beck.jetmusicbox.networking.apis

import denis.beck.jetmusicbox.BuildConfig
import denis.beck.jetmusicbox.networking.constants.GrantTypes
import denis.beck.jetmusicbox.networking.constants.Queries
import denis.beck.jetmusicbox.networking.responses.AuthResponse
import denis.beck.jetmusicbox.networking.responses.RefreshResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("/api/token")
    suspend fun accessToken(
        @Field(Queries.code) code: String,
        @Field(Queries.redirectUri) redirectUri: String = BuildConfig.redirectURI,
        @Field(Queries.grantType) grantType: String = GrantTypes.authorizationCode
    ) : AuthResponse

    @FormUrlEncoded
    @POST("/api/token")
    suspend fun refreshToken(
        @Field(Queries.refreshToken) refreshToken: String,
        @Field(Queries.clientId) clientId: String = BuildConfig.clientId,
        @Field(Queries.grantType) grantType: String = GrantTypes.refreshToken
    ) : RefreshResponse

}