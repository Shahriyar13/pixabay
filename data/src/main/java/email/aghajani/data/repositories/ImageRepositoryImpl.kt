package email.aghajani.data.repositories

import email.aghajani.data.remote.datasource.image.ImageRemoteDataSource
import email.aghajani.domain.entities.ImageEntity
import email.aghajani.domain.entities.params.FetchImageParams
import email.aghajani.domain.repositories.image.ImageRepository
import kotlinx.coroutines.flow.Flow

class ImageRepositoryImpl(
    private val imageRemoteDataSource: ImageRemoteDataSource,
): ImageRepository {
    override suspend fun getImage(params: FetchImageParams): Flow<ImageEntity> = imageRemoteDataSource.fetch(params)
}