package com.akshat.food.Screens.Dine_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.akshat.food.Navigation.Navigation_Screen_Data.screens
import com.akshat.food.RoomDatabase.entity.Cart_entity
import com.akshat.food.Viewmoels.Dinescreenviewmodel
import com.akshat.food.components.textchange
import com.akshat.food.model.by_first_letter.Meal

@Composable
fun DineScreen(viewmodel: Dinescreenviewmodel, detail: NavHostController, nav: NavHostController) {





    val textList = listOf("Pork", "Chicken", "Veg")
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Top) {
            SearchBar(textList)

            val x =viewmodel.listStateFlow.collectAsState()



            LazyColumnContent( x.value.flatten(),detail,viewmodel,nav)
        }
    }
}


@Composable
fun SearchBar(textList: List<String>) {
    androidx.compose.material3.Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        color = Color.White,
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "",
                modifier = Modifier.padding(end = 5.dp),
                tint = Color.Red,
            )
            Text(
                text = "Search for ",
                fontWeight = FontWeight.Light
            )
            textchange(texts = textList)
        }
    }
}

@Composable
fun LazyColumnContent(
    data: List<Meal>?,
    detail: NavHostController,
    viewmodel: Dinescreenviewmodel,
    nav: NavHostController,
   ) {
    if (data != null) {
        LazyColumn(state = rememberLazyListState(),
            modifier = Modifier.padding(top = 5.dp)) {
            items(data) { meal ->
                ReproducingList(meal = meal,detail,viewmodel,nav)
            }
        }
    }
}


@Composable
fun ReproducingList(
    meal: Meal,
    detail: NavHostController,
    viewmodel: Dinescreenviewmodel,
    nav: NavHostController,

    ) {

    val mealId = meal.idMeal
    val isMealInCart  =  viewmodel.isMealInCart(mealId).collectAsState(initial = false)
    val id = meal.idMeal
    Surface(
        modifier = Modifier
            .padding(10.dp)

            .clickable {
                detail.navigate(screens.Detailscreen.name + "/$id")
            },
        shadowElevation = 20.dp,
        shape = RoundedCornerShape(20.dp)

    ) {
        
        
        
        Column {


            Image(
                painter = rememberImagePainter(data = meal.strMealThumb),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            )
            Surface(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    ,
                shape = RoundedCornerShape(20.dp)
            ) {

Row(modifier = Modifier,
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically) {




    Column(modifier = Modifier
        .weight(0.5f)
        .fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {


        Spacer(modifier =Modifier.weight(0.3f))

        Surface(color =  if (isMealInCart.value) Color.Green  else Color.Red, modifier = Modifier
            .weight(0.3f)
            .clickable {

               if (!isMealInCart.value){
                viewmodel.addtocart(
                    Cart_entity(
                        add = 1,
                        img = meal.strMealThumb,
                        id = meal.idMeal,
                        name = meal.strMeal
                    )
                )
            }
                else
                    nav.navigate(screens.Cart.name)
Log.d("jen","dnwd")

            } ) {



            Text(
                text = if (isMealInCart.value) "Go to Cart" else "Add to Cart"

               , color = Color.White, modifier = Modifier.padding(5.dp)
            )

        }
Spacer(modifier = Modifier.weight(0.1f))

        Text(text = "₹ 100", modifier = Modifier.weight(0.4f))

    }


    Column(modifier = Modifier
        .padding(10.dp)
        .weight(0.7f)) {
        Text(
            text = if (meal.strMeal.length<=20) meal.strMeal else
                meal.strMeal.substring(0,20)+"..",
            fontSize = 3.5.em
        )
        Text(
            text = meal.strArea,
            fontSize = 2.5.em,
            fontWeight = FontWeight.Light
        )
        Text(
            text =  if (meal.strIngredient1.length+meal.strIngredient2.length<=20)"Ingredients - ${meal.strIngredient1} , ${meal.strIngredient2}"
             else "Ingridents - ${meal.strIngredient1}...",

            fontSize = 2.5.em,
            fontWeight = FontWeight.Light
        )
    }
}
            }
        }
    }
}