package denis.beck.jetmusicbox.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denis.beck.jetmusicbox.BuildConfig
import denis.beck.jetmusicbox.networking.AuthInterceptor
import denis.beck.jetmusicbox.networking.BaseInterceptor
import denis.beck.jetmusicbox.networking.apis.AuthApi
import denis.beck.jetmusicbox.networking.apis.SpotifyApi
import denis.beck.jetmusicbox.networking.constants.ContentTypes
import denis.beck.jetmusicbox.repositories.authData.AuthDataRepository
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    private val contentType = ContentTypes.applicationJson.toMediaType()

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    @Named(value = RetrofitType.Auth)
    fun provideAuthRetrofit(
        @Named(value = RetrofitType.Auth) okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.authURL)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(okHttpClient)
            .build()
    }

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    @Named(value = RetrofitType.Base)
    fun provideBaseRetrofit(
        @Named(value = RetrofitType.Base) okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.baseURL)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Named(value = RetrofitType.Auth)
    fun provideAuthOkHttpClient(
        authInterceptor: AuthInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    // Todo: Add Authenticator to refresh access token
    @Provides
    @Named(value = RetrofitType.Base)
    fun provideBaseOkHttpClient(
        baseInterceptor: BaseInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(baseInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideAuthInterceptor() = AuthInterceptor()

    @Provides
    fun provideBaseInterceptor(authDataRepository: AuthDataRepository) =
        BaseInterceptor(authDataRepository)

    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun authApi(
        @Named(value = RetrofitType.Auth) retrofit: Retrofit,
    ): AuthApi = retrofit.create(AuthApi::class.java)

    @Singleton
    @Provides
    fun spotifyApi(
        @Named(value = RetrofitType.Base) retrofit: Retrofit,
    ): SpotifyApi = retrofit.create(SpotifyApi::class.java)

}