package email.aghajani.data.remote.dto.response

data class PostDto(
    val id: Long,
    val pageURL: String,
    val type: String,
    val tags: String,
    val previewURL: String,
    val previewWidth: Int,
    val previewHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int,
    val webformatHeight: Int,
    val largeImageURL: String,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val views: Long,
    val downloads: Long,
    val collections: Long,
    val likes: Long,
    val comments: Long,
    val user_id: Long,
    val user: String,
    val userImageURL: String,
) {
    constructor(): this(
        0,
        "",
        "",
        "",
        "",
        1,
        2,
        "",
        2,
        3,
        "",
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        11,
        100,
        "user",
        "",
    )//TODO: Remove
}
