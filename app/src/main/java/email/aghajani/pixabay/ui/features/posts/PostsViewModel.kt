package email.aghajani.pixabay.ui.features.posts

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.entities.enums.OrderEnum
import email.aghajani.domain.entities.params.FetchImageParams
import email.aghajani.domain.usecases.image.FetchImagesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val fetchImagesUseCase: FetchImagesUseCase,
): ViewModel() {

    private val fetchImageParams = FetchImageParams("Fruits")

    private val _posts: MutableStateFlow<List<PostEntity>> = MutableStateFlow(emptyList())
    val posts: StateFlow<List<PostEntity>> get() = _posts

    private var _loading by mutableStateOf(false)
    val loading = derivedStateOf { _loading }

    private var _error by mutableStateOf<String?>(null)
    val error = derivedStateOf { _error }

    init {
        getImages(fetchImageParams)
    }

    fun changeParams(
        query: String? = fetchImageParams.query,
        order: OrderEnum = fetchImageParams.order,
        isSafeSearchOn: Boolean = fetchImageParams.isSafeSearch,
    ) {
        _posts.value = mutableListOf()
        fetchImageParams.page = 1

        fetchImageParams.query = query
        fetchImageParams.order = order
        fetchImageParams.isSafeSearch = isSafeSearchOn

        getImages(fetchImageParams)
    }

    private fun getImages(params: FetchImageParams) {
        _loading = true
        viewModelScope.launch {
            when (val res = fetchImagesUseCase.execute(params)) {
                is PixabayResult.Success<*> -> {
                    if (fetchImageParams.page == 1) {
                        _posts.value = (res.data as? List<PostEntity> ?: emptyList())
                    } else {
                        _posts.value += (res.data as? List<PostEntity> ?: emptyList())
                    }
                    _loading = false
                }
                is PixabayResult.Error<*> -> {
                    _error = res.errorMessage
                    _loading = false
                }
                else -> {
                    _error = "Error"
                    _loading = false
                }
            }
        }
    }
}