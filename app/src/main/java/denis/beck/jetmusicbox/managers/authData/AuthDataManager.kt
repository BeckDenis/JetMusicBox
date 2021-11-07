package denis.beck.jetmusicbox.managers.authData

import denis.beck.jetmusicbox.data.AuthData

interface AuthDataManager {

    suspend fun getAuthData(): AuthData

    suspend fun setAuthData(value: AuthData)

}