package email.aghajani.domain.usecases.image

import email.aghajani.domain.entities.params.FetchImageParams
import email.aghajani.domain.entities.ImageEntity
import email.aghajani.domain.repositories.image.ImageRepository
import email.aghajani.domain.usecases.FlowUseCase
import kotlinx.coroutines.flow.Flow

class FetchImagesUseCase(
    private val repository: ImageRepository
): FlowUseCase<FetchImageParams, ImageEntity>() {
    override suspend fun execute(param: FetchImageParams): Flow<ImageEntity> = repository.getImage(param)
}