package denis.beck.jetmusicbox.networking

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Failure(
        val exception: Throwable,
        val message: String? = exception.message
    ) : Result<Nothing>()
}
