package email.aghajani.pixabay.ui.features.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PostsScreen() {
    val viewModel = hiltViewModel<PostsViewModel>()

    val posts = viewModel.posts.collectAsState()

    LazyColumn {
        items(
            items = posts.value,
            key = { it.id },
        ) { post ->
            Text(
                modifier = Modifier.height(75.dp),
                text = post.user.userName,
            )
            Divider()
        }
        item {
            Column(
                modifier = Modifier
                    .fillParentMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Refresh Loading"
                )

                CircularProgressIndicator(color = Color.Black)
            }

        }
    }
}