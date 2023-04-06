package email.aghajani.data.repositories

import email.aghajani.data.remote.datasource.image.ImageRemoteDataSource
import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.entities.params.FetchImageParams
import email.aghajani.domain.repositories.image.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageRemoteDataSource: ImageRemoteDataSource,
): ImageRepository {
    override suspend fun getImage(params: FetchImageParams): Flow<PixabayResult<List<PostEntity>>> =
        imageRemoteDataSource.fetch(params)

    override suspend fun getImageById(id: Long): PixabayResult<PostEntity> =
        imageRemoteDataSource.fetchById(id)

}