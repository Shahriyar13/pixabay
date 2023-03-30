package email.aghajani.domain.entities

import email.aghajani.domain.entities.enums.MediaTypeEnum

data class PostEntity(
    val id: Long,
    val pageURL: String,
    val type: MediaTypeEnum,
    val tags: List<String>,
    val imagePreview: ImageEntity,
    val imageWebFormat: ImageEntity,
    val imageLarge: ImageEntity,
    val views: Long,
    val downloads: Long,
    val collections: Long,
    val likes: Long,
    val comments: Long,
    val user: UserEntity,
)
