package email.aghajani.data.remote.dto.mapper

import email.aghajani.data.remote.dto.response.ImageDto
import email.aghajani.domain.entities.ImageEntity

fun ImageDto.mapToEntity() = ImageEntity(
    id = id,
    previewImageUrl = previewURL,
    imageUrl = largeImageURL,//TODO: add all params
)