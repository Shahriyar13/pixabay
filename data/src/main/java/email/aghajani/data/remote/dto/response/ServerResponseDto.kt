package email.aghajani.data.remote.dto.response

data class ServerResponseDto<T>(
    val total: Long?,
    val totalHits: Long?,
    val hits: T?
)
