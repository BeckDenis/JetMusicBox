package denis.beck.jetmusicbox.managers.auth

interface AuthManager {

    suspend fun isAuthorize(): Boolean

    suspend fun authorize(code: String): Boolean
}