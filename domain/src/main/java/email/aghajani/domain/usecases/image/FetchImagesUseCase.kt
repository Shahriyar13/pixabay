package email.aghajani.domain.usecases.image

import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.params.FetchImageParams
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.repositories.image.ImageRepository
import email.aghajani.domain.usecases.FlowUseCase
import kotlinx.coroutines.flow.Flow

class FetchImagesUseCase(
    private val repository: ImageRepository
): FlowUseCase<FetchImageParams, List<PostEntity>>() {
    override suspend fun execute(param: FetchImageParams): Flow<PixabayResult<List<PostEntity>>> = repository.getImage(param)
}