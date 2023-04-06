package email.aghajani.domain.common

sealed class PixabayResult<out T> {

    data class Success<T>(val data: T?) : PixabayResult<T>()

    //receiving data has been failed :(
    data class Error<T>(val errorMessage: String) : PixabayResult<T>()
}
