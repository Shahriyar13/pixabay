package email.aghajani.data.remote.datasource.image

import email.aghajani.data.remote.dto.mapper.mapToEntity
import email.aghajani.data.remote.dto.response.ImageDto
import email.aghajani.domain.entities.ImageEntity
import email.aghajani.domain.entities.params.FetchImageParams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ImageRemoteDataSourceImpl(

): ImageRemoteDataSource {

    override suspend fun fetch(params: FetchImageParams): Flow<ImageEntity> = flow {
        ImageDto().mapToEntity()
        ImageDto().mapToEntity()
        ImageDto().mapToEntity()
    }
}