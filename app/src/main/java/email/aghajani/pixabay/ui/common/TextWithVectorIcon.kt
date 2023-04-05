package email.aghajani.pixabay.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun TextWithVectorIcon(modifier: Modifier = Modifier, text: String, textColor: Color, vectorImage: ImageVector, vectorColor: Color = textColor) {
    Row(modifier = modifier.padding(2.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            imageVector = vectorImage,
            contentDescription = text,
            colorFilter = ColorFilter.tint(vectorColor),
            modifier = Modifier.size(20.dp).padding(horizontal = 3.dp)
        )
        Text(
            text = text,
            color = textColor,
        )
    }
}