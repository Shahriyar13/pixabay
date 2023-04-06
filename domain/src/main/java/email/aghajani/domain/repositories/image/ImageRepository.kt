package email.aghajani.domain.repositories.image

import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.entities.params.FetchImageParams
import email.aghajani.domain.repositories.BaseRepository
import kotlinx.coroutines.flow.Flow

interface ImageRepository: BaseRepository {
    suspend fun getImage(params: FetchImageParams): Flow<PixabayResult<List<PostEntity>>>
    suspend fun getImageById(id: Long): PixabayResult<PostEntity>
}