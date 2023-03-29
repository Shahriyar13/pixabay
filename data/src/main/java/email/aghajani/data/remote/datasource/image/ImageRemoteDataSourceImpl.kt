package email.aghajani.data.remote.datasource.image

import email.aghajani.data.remote.api.ImageApi
import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.entities.params.FetchImageParams
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ImageRemoteDataSourceImpl(
    private val imageApi: ImageApi,
    private val ioDispatcher: CoroutineDispatcher
): ImageRemoteDataSource {

    override suspend fun fetch(params: FetchImageParams): Flow<PixabayResult<List<PostEntity>>> = flow<PixabayResult<List<PostEntity>>> {
        imageApi.fetchImages(
            query = params.query,
            page = params.page,
            order = params.order,
            perPage = params.perPage,
        )
    }.flowOn(ioDispatcher)
}