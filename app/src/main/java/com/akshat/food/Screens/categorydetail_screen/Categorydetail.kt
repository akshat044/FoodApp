package com.akshat.food.Screens.categorydetail_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.akshat.food.Navigation.Navigation_Screen_Data.screens
import com.akshat.food.Viewmoels.Categorydetailscreenviewmodel
import com.akshat.food.Viewmoels.Continentaldetailviewmodel
import com.akshat.food.data.DataOrException
import com.akshat.food.model.categorydetail.CategoryMeal

@Composable
fun categorydetail(
    viewmodel: Categorydetailscreenviewmodel,
    Continentaldetailviewmodel: Continentaldetailviewmodel,
    detail: NavHostController,
    contt: String?,
    name: String,
){


    if (contt != null) {


        val Categorystate = produceState(initialValue = DataOrException(loading = true)) {
            value = contt.let {
                viewmodel.getcategorydetail(it)
            }
        }.value


        val Continetalstate = produceState(initialValue = DataOrException(loading = true)) {
            value = contt.let {
                Continentaldetailviewmodel.getcontinentaldetail(it)
            }
        }.value



        if (name == "continent"){ Continetalstate
            .data?.meals?.let {

                    Surface(modifier = Modifier.fillMaxSize()) {


                        Column {

                            androidx.compose.material3.Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp),
                                shadowElevation = 10.dp,
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Icon(imageVector = Icons.Filled.KeyboardArrowUp,
                                        contentDescription = "",
                                        modifier = Modifier.rotate(-90f).clickable {
                                            detail.popBackStack()
                                        })


                                    if (contt != null) {
                                        Text(
                                            text = contt,
                                            modifier = Modifier.padding(start = 20.dp),
                                            style = MaterialTheme.typography.h5
                                        )
                                    }
                                }


                            }

                            LazyColumn() {
                                items(it) {
                                    listproduce(meal = it, detail = detail)

                                }


                            }


                        }
                    }
                }
            }



        else{
            Categorystate
                .data?.meals?.let {

                    Surface(modifier = Modifier.fillMaxSize()) {


                        Column {

                            androidx.compose.material3.Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp),
                                shadowElevation = 10.dp,
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Icon(imageVector = Icons.Filled.KeyboardArrowUp,
                                        contentDescription = "",
                                        modifier = Modifier.rotate(-90f).clickable {
                                            detail.popBackStack()
                                        })


                                    Text(
                                        text = contt,
                                        modifier = Modifier.padding(start = 20.dp),
                                        style = MaterialTheme.typography.h5
                                    )
                                }


                            }

                            LazyColumn() {
                                items(it) {
                                    listproduce(meal = it, detail = detail)

                                }


                            }


                        }
                    }
                }
        }
        }
    }

@Composable
fun listproduce(meal: CategoryMeal, detail: NavHostController) {
    val id = meal.idMeal
    Column {


        androidx.compose.material3.Surface(
            modifier = Modifier
                .padding(10.dp)

                .clickable {
                    Log.d("idddddddddddddddddddd", id)
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
                androidx.compose.material3.Surface(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp)
                ) {

                    Row(
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = meal.strMeal,)





                        androidx.compose.material3.Surface(
                            color = Color.Red,
                            modifier = Modifier
                        ) {


                            Text(
                                text = "Add to cart",
                                color = Color.White,
                                modifier = Modifier.padding(5.dp)
                            )

                        }


                    }


                }
            }
        }
    }
}