package email.aghajani.data.remote.datasource.image

import email.aghajani.data.remote.dto.mapper.toEntity
import email.aghajani.data.remote.dto.response.PostDto
import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.ImageEntity
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.entities.params.FetchImageParams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ImageRemoteDataSourceImpl(

): ImageRemoteDataSource {

    override suspend fun fetch(params: FetchImageParams): Flow<PixabayResult<List<PostEntity>>> = flow {
        PixabayResult.Success(data = listOf(
            PostDto().toEntity(),
            PostDto().toEntity(),
        ))
    }
}