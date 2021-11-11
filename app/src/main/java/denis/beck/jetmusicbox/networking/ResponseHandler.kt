package denis.beck.jetmusicbox.networking

import retrofit2.HttpException
import javax.inject.Inject


class ResponseHandler @Inject constructor() {
    fun <T : Any> handleResult(data: T): Result<T> {
        return try {
            handleSuccess(data)
        } catch (e: Exception) {
            handleException(e)
        }
    }

    private fun <T : Any> handleSuccess(data: T): Result<T> {
        return Result.Success(data)
    }

    private fun <T : Any> handleException(e: Exception): Result<T> {
        return when (e) {
            is HttpException -> Result.Failure(e, getErrorMessage(e.code()))
            else -> Result.Failure(e, getErrorMessage(Int.MAX_VALUE))
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            401 -> "Unauthorised"
            404 -> "Not found"
            else -> "Something went wrong"
        }
    }
}