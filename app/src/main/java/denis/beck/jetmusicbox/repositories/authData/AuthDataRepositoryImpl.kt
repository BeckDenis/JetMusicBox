package denis.beck.jetmusicbox.repositories.authData

import android.content.Context
import androidx.datastore.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import denis.beck.jetmusicbox.data.AuthData
import denis.beck.jetmusicbox.data.AuthDataSerializer
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AuthDataRepositoryImpl @Inject constructor(@ApplicationContext appContext: Context) :
    AuthDataRepository {

    private val Context.authDataStore by dataStore(
        "auth_data.json",
        serializer = AuthDataSerializer
    )

    private val authDataStore = appContext.authDataStore

    override suspend fun getAuthData() = authDataStore.data.first()

    override suspend fun setAuthData(value: AuthData) {
        authDataStore.updateData { value }
    }

}