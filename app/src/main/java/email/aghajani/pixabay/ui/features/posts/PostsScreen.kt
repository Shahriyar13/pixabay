package email.aghajani.pixabay.ui.features.posts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun PostsScreen(
) {
    val viewModel: PostsViewModel = hiltViewModel()

    val posts = viewModel.posts.collectAsState()

    LazyColumn {
        items(
            items = posts.value,
            key = { it.id },
        ) { post ->
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.TopCenter,
                model = post.imagePreview.url,
                contentDescription = post.tags.toString(),
                contentScale = ContentScale.FillWidth,
            )
            Text(
                modifier = Modifier.height(75.dp),
                text = post.user.userName,
            )
            Divider()
        }
        if (viewModel.loading.value) item {
            Column(
                modifier = if (viewModel.fetchImageParams.page == 1) Modifier.fillParentMaxSize() else Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Loading"
                )
                CircularProgressIndicator(color = Color.Black)
            }
        }
    }
}