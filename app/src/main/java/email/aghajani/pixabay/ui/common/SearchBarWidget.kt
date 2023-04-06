package email.aghajani.pixabay.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
@Composable
fun SearchBarWidget(
    query: String,
    onQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    onSearchKeyPressed: () -> Unit = {},
    label: String = "Search",
) {
    val focusManager = LocalFocusManager.current

    Box(
        modifier = modifier.padding(8.dp),
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = { onQueryChanged(it) },
            placeholder = if (placeholder != null) { { Text(placeholder) } } else { null },
            label =  { Text(label) },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = true,
                keyboardType = KeyboardType.Ascii,
                imeAction = ImeAction.Search,
            ),
            singleLine = true,
            shape = TextFieldDefaults.filledShape,
            keyboardActions = KeyboardActions(onSearch = {
                focusManager.clearFocus()
                onSearchKeyPressed()
            }),
            textStyle = TextStyle(fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth().padding(0.dp),
        )
    }
}