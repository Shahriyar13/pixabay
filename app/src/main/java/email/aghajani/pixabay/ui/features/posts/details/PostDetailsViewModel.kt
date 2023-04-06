package email.aghajani.pixabay.ui.features.posts.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import email.aghajani.domain.common.PixabayResult
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.usecases.image.FetchPostByIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val fetchPostByIdUseCase: FetchPostByIdUseCase,
): ViewModel() {

    fun setPostId(postId: Long?) {
        postId?.let {
            viewModelScope.launch {
                getPostById(it)
            }
        }
    }

    private suspend fun getPostById(postId: Long) {
        fetching.value = true
        when (val result = fetchPostByIdUseCase.execute(postId)) {
            is PixabayResult.Success -> {
                post.value = result.data
                fetching.value = false
            }
            is PixabayResult.Error -> {
                error.value = result.errorMessage
                fetching.value = false
            }
            else -> {
                error.value = "Unknown Error"
                fetching.value = false
            }
        }
    }

    val post: MutableState<PostEntity?> = mutableStateOf(null)

    var fetching: MutableState<Boolean> = mutableStateOf(false)

    var error: MutableState<String?> = mutableStateOf(null)


}