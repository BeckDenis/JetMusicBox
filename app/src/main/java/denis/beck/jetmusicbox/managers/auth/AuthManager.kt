package denis.beck.jetmusicbox.managers.auth

interface AuthManager {
    suspend fun authorize(code: String): Boolean
}