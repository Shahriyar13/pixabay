package email.aghajani.pixabay.ui.features.posts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import email.aghajani.domain.entities.PostEntity
import email.aghajani.domain.entities.UserEntity
import email.aghajani.pixabay.Roots
import email.aghajani.pixabay.ui.common.*


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun PostsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PostsViewModel = hiltViewModel()
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val search by viewModel.search.collectAsStateWithLifecycle()
    val isSearchBarVisible by viewModel.isSearchShowing.collectAsStateWithLifecycle()
    val res = viewModel.posts.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.wrapContentHeight(),
                title = {
                    if (isSearchBarVisible) {
                        SearchBarWidget(
                            query = search,
                            onQueryChanged = {
                                viewModel.setSearch(it)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = "Search",
                            placeholder = "Search products",
                            onSearchKeyPressed = {
                                viewModel.toggleIsSearchShowing()
                            }
                        )
                    } else {
                        Text(text = "Pixabay Images")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.toggleIsSearchShowing()
                        },
                    ) {
                        if (isSearchBarVisible) Icon(
                            Icons.Default.Close,
                            contentDescription = "Search"
                        )
                        else Icon(Icons.Default.Search, contentDescription = "Close Search")
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues),
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(count = res.itemCount) { index ->
                    res[index]?.let { post ->
                        PostItem(
                            post = post,
                            modifier = Modifier.padding(1.dp)
                        ) {
                            navController.navigate("${Roots.PostDetailsScreenPath}/${post.id}")
                        }
                    }
                }
                res.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            item { PageLoader(modifier = Modifier.fillMaxSize()) }
                        }
                        loadState.append is LoadState.Loading -> {
                            item { LoadingNextPageItem(modifier) }
                        }
                        loadState.append is LoadState.Error -> {
                            val error = res.loadState.append as LoadState.Error
                            item {
                                ErrorMessage(
                                    modifier = modifier,
                                    message = error.error.localizedMessage!!,
                                    onClickRetry = { retry() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PostItem(post: PostEntity, modifier: Modifier = Modifier, onClick: (PostEntity) -> Unit) {
    Box(
        modifier = modifier.clickable { onClick(post) }
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f / 1f, true)
                .background(Color.Black),
            alignment = Alignment.Center,
            model = post.imagePreview.url,
            contentDescription = post.tags.toString(),
            contentScale = ContentScale.FillWidth,
        )
        UserInfo(
            post.user,
            modifier = Modifier
                .background(Color.White.copy(alpha = 0.4f))
                .fillMaxWidth(),
        )
    }
}

@Composable
fun UserInfo(user: UserEntity, modifier: Modifier = Modifier) {
    TextWithVectorIcon(
        modifier = modifier,
        text = user.userName,
        vectorImage = Icons.Default.Person,
        textColor = Color.Black
    )
}