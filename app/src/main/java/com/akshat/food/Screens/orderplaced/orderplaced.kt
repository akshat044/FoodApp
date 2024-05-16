package com.akshat.food.Screens.orderplaced

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.akshat.food.R

import kotlinx.coroutines.delay

@Composable
fun orderplaced(detail: NavHostController, nav: NavHostController) {
val scale = remember {
    androidx.compose.animation.core.Animatable(0f)
}




    LaunchedEffect(key1 = null){
scale.animateTo(
    targetValue = 0.8f
    , animationSpec = tween(
        durationMillis = 2000,
        easing = {
            OvershootInterpolator(3f)
                .getInterpolation(it)
        }
    )
    ,

)
        delay(3000)

      detail.popBackStack()



    }
    Column(modifier = Modifier.fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Surface(modifier = Modifier
            .padding(10.dp)
            .size(250.dp)
            .scale(scale.value)) {
            Image(painter = painterResource(id = R.drawable.verify), contentDescription = "")
        }
        Surface {
            Text(
                text = "Order Placed", modifier = Modifier.padding(20.dp))
        }
    }

    
    
}

