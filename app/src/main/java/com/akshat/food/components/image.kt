import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import dagger.Provides
import kotlinx.coroutines.delay



val list = listOf(
    "https://www.thomascook.in/blog/wp-content/uploads/2015/09/Thailand-Tom-Yum-Goong.jpg",
    "https://img.veenaworld.com/wp-content/uploads/2021/09/Top-10-Most-Iconic-Foods-to-Eat-in-Italy.jpg",
    "https://www.thomascook.in/blog/wp-content/uploads/2015/09/Turkey-Lahmacun.jpg"
)


@SuppressLint("SuspiciousIndentation")
@Composable
fun ImageList(imageIds: List<String>, transitionDelay: Long = 2000L) {
    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(transitionDelay)
            currentIndex = (currentIndex + 1) % imageIds.size
        }
    }

    val currentImageId = imageIds[currentIndex]



            Image(
                painter =  coil.compose.rememberImagePainter(data = currentImageId),
                contentDescription = null,
                modifier = Modifier
                    ,
                contentScale = ContentScale.FillBounds
            )
        }






@Preview
@Composable
fun jend(){
    ImageList(imageIds = list)
}
