package email.aghajani.pixabay.ui.features.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import email.aghajani.domain.entities.PostEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postsPagingSource: PostsPagingSource,
): ViewModel() {

    private val _search = MutableStateFlow("Fruits")
    val search = _search.asStateFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = "",
        )

    private val _isSearchShowing = MutableStateFlow(false)

    val isSearchShowing = _isSearchShowing.asStateFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = false,
        )

    fun setSearch(query: String) {
        _search.value = query
    }

    fun toggleIsSearchShowing() {
        _isSearchShowing.value = !_isSearchShowing.value
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val posts: Flow<PagingData<PostEntity>> = search.debounce(1000).flatMapLatest { query ->
        postsPagingSource.searchParams.query = query
        Pager(
            PagingConfig(
                pageSize = 10,
                prefetchDistance = 2,
                initialLoadSize = 10,
                enablePlaceholders = true
            ), initialKey = 1
        ) { postsPagingSource }.flow.cachedIn(viewModelScope)
    }
}