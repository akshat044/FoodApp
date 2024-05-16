package com.akshat.food.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.delay

@Composable
fun textchange(texts:List<String>,transitiondelay:Long  = 2000L){
 var currentIndex =  remember {
     mutableStateOf(0)
 }
    LaunchedEffect(Unit){
        while (true){
            delay(transitiondelay)
            currentIndex.value  = (currentIndex.value+1)%texts.size
        }
    }
    Text(text = texts[currentIndex.value],
        fontWeight = FontWeight.Light)
}