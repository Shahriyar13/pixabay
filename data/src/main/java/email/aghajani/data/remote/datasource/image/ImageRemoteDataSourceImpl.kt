package email.aghajani.data.remote.datasource.image

import email.aghajani.data.di.IoDispatcher
import email.aghajani.data.remote.Converter
import email.aghajani.data.remote.api.ImageApi
import email.aghajani.data.remote.dto.mapper.toEntity
import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.entities.params.FetchImageParams
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ImageRemoteDataSourceImpl @Inject constructor(
    private val imageApi: ImageApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
): ImageRemoteDataSource {

    override suspend fun fetch(params: FetchImageParams): Flow<PixabayResult<List<PostEntity>>> =
        flow {
            val res = imageApi.fetchImages(
                query = params.query,
                page = params.page,
                order = params.order,
                perPage = params.perPage,
            )
            when (val result =
                Converter.createFromResponse(res)) {
                is PixabayResult.Success -> emit(PixabayResult.Success(result.data?.map { it.toEntity() }))
                is PixabayResult.Error -> emit(PixabayResult.Error(result.errorMessage))
                else -> emit(PixabayResult.Error("Unknown"))
            }
        }.flowOn(ioDispatcher)
}