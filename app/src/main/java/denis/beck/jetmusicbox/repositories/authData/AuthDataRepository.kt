package denis.beck.jetmusicbox.repositories.authData

import denis.beck.jetmusicbox.core.models.AuthData

interface AuthDataRepository {

    suspend fun getAuthData(): AuthData

    suspend fun setAuthData(value: AuthData)

}