package email.aghajani.pixabay.ui.features.posts

import androidx.paging.PagingSource
import androidx.paging.PagingState
import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.entities.params.FetchImageParams
import email.aghajani.domain.usecases.image.FetchImagesUseCase

class PostsPagingSource(
    private val fetchImagesUseCase: FetchImagesUseCase,
): PagingSource<Int, PostEntity>() {

    val searchParams = FetchImageParams(
        query = null,
        page = 1,
        perPage = 10,
    )

    override fun getRefreshKey(state: PagingState<Int, PostEntity>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostEntity> {
        lateinit var response: LoadResult<Int, PostEntity>
        searchParams.page = params.key ?: 1
        searchParams.perPage = params.loadSize

        fetchImagesUseCase.execute(
            FetchImageParams(
                query = searchParams.query,
                page = params.key ?: 1,
                perPage = params.loadSize
            )
        ).collect { result ->
            val nextPage = params.key ?: 1
            when (result) {
                is PixabayResult.Success -> {
                    response = LoadResult.Page(
                        data = result.data ?: emptyList(),
                        prevKey = if (nextPage == 1) null else nextPage - 1,
                        nextKey = if (result.data?.isEmpty() == true) null else (params.key
                            ?: 1) + 1
                    )
                }
                is PixabayResult.Error -> {
                    response = LoadResult.Error(Exception(result.errorMessage))
                }
                else -> {
                    response = LoadResult.Error(Exception("Unknown Error"))
                }
            }
        }
        return response
    }
}

//        val result = fetchImagesUseCase.execute(
//            FetchImageParams(
//                query = null,
//                page = params.key ?: 1,
//                perPage = params.loadSize
//            )
//        )
//        result.collect()
//        val nextPage = params.key ?: 1
//        when (result) {
//            is PixabayResult.Success<*> -> {
//                LoadResult.Page(
//                    data = (result.data as? List<*>)?.filterIsInstance(PostEntity::class.java) ?: emptyList(),
//                    prevKey = if (nextPage == 1) null else nextPage - 1,
//                    nextKey = if ((result.data as? List<*>)?.isEmpty() == true) null else (params.key
//                        ?: 1) + 1
//                )
//            }
//            is PixabayResult.Error<*> -> {
//                LoadResult.Error(Exception(result.errorMessage))
//            }
//            else -> {
//                LoadResult.Error(Exception("Unknown Error"))
//            }
//        }