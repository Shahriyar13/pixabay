package email.aghajani.data.remote.dto.mapper

import email.aghajani.data.remote.dto.response.PostDto
import email.aghajani.domain.entities.ImageEntity
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.entities.UserEntity
import email.aghajani.domain.entities.enums.MediaTypeEnum

fun PostDto.toEntity() = PostEntity(
    id = id,
    pageURL = pageURL,
    type = MediaTypeEnum.valueOf(type),
    tags = tags.takeIf { it.isNotEmpty() && it.contains(",") }
        ?.split(",")?.map { it.trim() } ?: emptyList(),
    imagePreview = ImageEntity(
        url = previewURL,
        width = previewWidth,
        height = previewHeight,
    ),
    imageWebFormat = ImageEntity(
        url = webformatURL,
        width = webformatWidth,
        height = webformatHeight,
    ),
    imageLarge = ImageEntity(
        url = largeImageURL,
        width = imageWidth,
        height = imageHeight,
    ),
    views = views,
    downloads = downloads,
    collections = collections,
    likes = likes,
    comments = comments,
    user = UserEntity(
      id = user_id,
      userName = user,
      imageUrl = userImageURL
    ),
)