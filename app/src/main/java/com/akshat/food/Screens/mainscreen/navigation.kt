package com.akshat.food.Screens.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.akshat.food.R

import com.akshat.food.Screens.Dine_screen.DineScreen
import com.akshat.food.Navigation.Navigation_Screen_Data.screens
import com.akshat.food.Screens.Cart_Screen.CartScreen
import com.example.foodpanda.Viewmoels.Categoryviewmodel
import com.akshat.food.Screens.category_Screen.Categories
import com.akshat.food.Viewmoels.cartviewmodel
import com.akshat.food.Viewmoels.Detailscreenviewmodel
import com.akshat.food.Viewmoels.Dinescreenviewmodel

@Composable
fun nav(
    detail: NavHostController,
    nav: NavHostController,
    categoryviewmodel: Categoryviewmodel,
    dinescreenviewmodel: Dinescreenviewmodel,
    detailscreenviewmodel: Detailscreenviewmodel,
    Cartviewmodel: cartviewmodel
) {


val selection = remember {
    mutableStateOf(0)
}

    Scaffold(
        bottomBar = {
NavigationBar(modifier = Modifier
    .padding(0.dp)
    .fillMaxWidth()
    .height(60.dp)
    .clip(RoundedCornerShape(topStartPercent = 25, topEndPercent = 25)), containerColor =  Color.White) {
    Row(modifier = Modifier.padding(7.dp)) {


        NavigationBarItem(
            selected = selection.value == 0,
            onClick = {
                selection.value = 0
                nav.navigate(screens.Categories.name)

            },
            icon = {

                Icon(imageVector = if (selection.value!=0) Icons.Outlined.Home
                    else Icons.Filled.Home
                    , contentDescription = "", modifier = Modifier,)
            })


        NavigationBarItem(
            selected = selection.value == 1,
            onClick = {
                selection.value = 1
                nav.navigate(screens.Dine.name)

            },
            icon = {
               Image(painter = painterResource(id = if (selection.value!=1) R.drawable.dinner__1_
               else R.drawable.food_tray), contentDescription = ""
               ,
               )
            })



        NavigationBarItem(
            selected = selection.value == 2,
            onClick = {
                selection.value = 2
                nav.navigate(screens.Cart.name)
            },
            icon = {
               Icon(imageVector = if (selection.value!=2) Icons.Outlined.ShoppingCart
                   else Icons.Filled.ShoppingCart, contentDescription = "", )
            })

    }

}


        }
    ) {

            paddingValues ->

        NavHost(navController =nav , startDestination = screens.Cart.name, modifier = Modifier.padding(paddingValues) ){

            composable(screens.Categories.name){
                Categories(viemodel = categoryviewmodel,detail)
                selection.value=0
            }
composable(screens.Dine.name){
DineScreen(viewmodel = dinescreenviewmodel, detail,nav)
    selection.value = 1
}
composable(screens.Cart.name){
CartScreen(Cartviewmodel,detail)
    selection.value  = 2
}
        }

    }

}