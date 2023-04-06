package email.aghajani.pixabay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import email.aghajani.pixabay.ui.features.posts.PostsScreen
import email.aghajani.pixabay.ui.features.posts.details.PostDetailsScreen
import email.aghajani.pixabay.ui.theme.PixabayTheme

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixabayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = Roots.PostsScreenPath) {
                        composable(Roots.PostsScreenPath) { PostsScreen(navController) }
                        composable(
                            route = "${Roots.PostDetailsScreenPath}/{POST_ID}",
                            arguments = listOf(navArgument("POST_ID") {type = NavType.LongType})
                        ) {backStackEntry ->
                            val postId = backStackEntry.arguments?.getLong("POST_ID")

                            postId?.let {
                                PostDetailsScreen(postId, navController)
                            }
                        }
                    }
                }
            }
        }
    }
}