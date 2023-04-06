package email.aghajani.domain.usecases.image

import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.repositories.image.ImageRepository
import email.aghajani.domain.usecases.BaseUseCase
import javax.inject.Inject

class FetchPostByIdUseCase @Inject constructor(
    private val repository: ImageRepository
): BaseUseCase<Long, PostEntity>() {
    override suspend fun execute(param: Long): PixabayResult<PostEntity> = repository.getImageById(param)
}