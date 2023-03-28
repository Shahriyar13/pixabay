package email.aghajani.data.remote.dto.response

data class ServerResponseDto(
    val total: Long,
    val totalHits: Long,
    val hits: List<PostDto>
)
