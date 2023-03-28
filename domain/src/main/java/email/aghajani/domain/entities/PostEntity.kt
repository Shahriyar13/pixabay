package email.aghajani.domain.entities

data class PostEntity(
    val id: Long,
    val pageURL: String,
    val type: String,
    val tags: String,
    val imagePreview: ImageEntity,
    val imageWebFormat: ImageEntity,
    val imageLarge: ImageEntity,
    val views: Long,
    val downloads: Long,
    val collections: Long,
    val likes: Long,
    val comments: Long,
)
