package email.aghajani.data.remote.datasource.image

import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.entities.params.FetchImageParams
import kotlinx.coroutines.flow.Flow

interface ImageRemoteDataSource {
    suspend fun fetch(params: FetchImageParams): Flow<PixabayResult<List<PostEntity>>>
}