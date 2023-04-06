package email.aghajani.pixabay.ui.features.posts.details

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import email.aghajani.domain.entities.UserEntity
import email.aghajani.pixabay.ui.common.TextWithVectorIcon

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun PostDetailsScreen(
    postId: Long,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PostDetailsViewModel = hiltViewModel(),
) {

    viewModel.setPostId(postId)
    val post by viewModel.post

    Scaffold(
        topBar = {
            TopAppBar(
                title = { post?.let { UserInfo(user = it.user) } },
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }

                    }
                }
            )
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues),
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f / 1f, true)
                    .background(Color.Black),
                alignment = Alignment.Center,
                model = post?.imageLarge?.url,
                contentDescription = post?.tags.toString(),
                contentScale = ContentScale.FillWidth,
            )

            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                Row(
                    modifier = Modifier
                        .background(Color.Black.copy(alpha = 0.3f))
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextWithVectorIcon(
                        text = post?.likes.toString(),
                        textColor = Color.White,
                        vectorImage = Icons.Default.ThumbUp,
                    )
                    TextWithVectorIcon(
                        text = post?.downloads.toString(),
                        textColor = Color.White,
                        vectorImage = Icons.Default.ShoppingCart,
                    )
                }
            }
        }
    }
}

@Composable
fun UserInfo(user: UserEntity, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        AsyncImage(
            modifier = Modifier
                .size(25.dp)
                .border(2.dp, Color.Gray, CircleShape)
                .clip(CircleShape)
                .padding(horizontal = 4.dp)
                .background(Color.Gray),
            alignment = Alignment.Center,
            model = user.imageUrl,
            contentDescription = user.userName,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = user.userName,
        )
    }
}