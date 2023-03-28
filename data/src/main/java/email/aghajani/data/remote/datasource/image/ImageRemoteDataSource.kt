package email.aghajani.data.remote.datasource.image

import email.aghajani.domain.entities.ImageEntity
import email.aghajani.domain.entities.params.FetchImageParams
import kotlinx.coroutines.flow.Flow

interface ImageRemoteDataSource {
    suspend fun fetch(params: FetchImageParams): Flow<ImageEntity>
}