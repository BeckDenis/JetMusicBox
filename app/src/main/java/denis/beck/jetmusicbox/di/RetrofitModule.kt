package denis.beck.jetmusicbox.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import denis.beck.jetmusicbox.BuildConfig
import denis.beck.jetmusicbox.networking.AuthInterceptor
import denis.beck.jetmusicbox.networking.apis.AuthApi
import denis.beck.jetmusicbox.networking.apis.ContentTypes
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
        @Named(value = RetrofitType.Auth) okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.authURL)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Named(value = RetrofitType.Auth)
    fun provideAuthOkHttpClient(
        authInterceptor: AuthInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideAuthInterceptor() = AuthInterceptor()

    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun authApi(
        @Named(value = RetrofitType.Auth) retrofit: Retrofit
    ): AuthApi = retrofit.create(AuthApi::class.java)

}