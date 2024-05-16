import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun WritingTextAnimation(text: String, modifier: Modifier = Modifier) {
    var writtenText by remember { mutableStateOf("") }
    var isAnimating by remember { mutableStateOf(true) }

    LaunchedEffect(isAnimating) {
        while (true) {
            val textLength = text.length
            val animationSpec = TweenSpec<Float>(durationMillis = (textLength * 100).toFloat().toInt()) // Cast to Float
            val animatedValue = Animatable(0f) // Use Float

            // Animate writing text
            animatedValue.animateTo(textLength.toFloat(), animationSpec) { // Cast to Float
                val newText = text.take(12)
                writtenText = newText
            }

            // Pause before erasing text
            delay(1000)

            // Animate erasing text
            animatedValue.animateTo(0f, animationSpec) { // Use Float
                writtenText = ""
            }
        }
    }

    Surface(
        modifier = modifier.background(Color.White),
        color = Color.White
    ) {
        BasicTextField(
            value = TextFieldValue(writtenText),
            onValueChange = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun TextWritingAnimationScreen() {
    val text = "Hello, world!"
    Column(modifier = Modifier.fillMaxSize()) {
        WritingTextAnimation(text = text)
    }
}
