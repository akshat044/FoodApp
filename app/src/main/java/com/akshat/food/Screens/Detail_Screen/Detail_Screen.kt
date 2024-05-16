package com.akshat.food.Screens.Detail_Screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.akshat.food.Navigation.Navigation_Screen_Data.screens
import com.akshat.food.RoomDatabase.entity.Cart_entity
import com.akshat.food.Viewmoels.Detailscreenviewmodel
import com.akshat.food.data.DataOrException


@Composable
fun DetailScreen(
    detailscreenviewmodel: Detailscreenviewmodel,
    nav: NavHostController,
    s: String?,
    detail: NavHostController
) {
val radiobutton = remember {
    mutableStateOf(0)
}



    val detaildata = produceState(
        initialValue = DataOrException(loading = true)
    ) {
        value = s?.let {
            detailscreenviewmodel.getmealdata(it)
        }!!
    }.value
    val x = detaildata.data?.meals







    x?.get(0)?.let {
        val check = detailscreenviewmodel.isMealInCart(it.idMeal).collectAsState(initial = false)
      val cartdata = detailscreenviewmodel.getonedata(it.idMeal).collectAsState(
          initial = null
      )
        val x = cartdata.value?.add
        Log.d("wkjcccccccccccccccccccccccccccccm" ,x.toString())

        val addvalue = remember {
            mutableStateOf(if (x!=null) x
            else 0)
        }

        Surface(modifier = Modifier.fillMaxSize()) {

            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(start = 6.dp, end = 6.dp)
                ) {


                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "",
                        modifier = Modifier
                            .rotate(90f)
                            .clickable {
                                detail.popBackStack()
                            }
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    Surface(shadowElevation = 5.dp, shape = CircleShape) {
                        Icon(
                            imageVector = Icons.Filled.FavoriteBorder, contentDescription = "",
                            tint = Color.Red, modifier = Modifier.padding(4.dp)
                        )

                    }

                    Spacer(modifier = Modifier.weight(0.1f))
                    Surface(shadowElevation = 5.dp, shape = CircleShape) {
                        Icon(
                            imageVector = Icons.Outlined.Share, contentDescription = "",
                            tint = Color.Black, modifier = Modifier.padding(4.dp)
                        )
                    }
                }


                    Column(
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                            .verticalScroll(rememberScrollState())
                    ) {


                        Surface(
                            modifier = Modifier,
                            color = Color.White,
                            shadowElevation = 4.dp,
                            shape = RoundedCornerShape(20.dp)

                        ) {
                            Column {


                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(350.dp)

                                ) {

                                    val y = it.strMealThumb.let {
                                        Image(
                                            painter = rememberImagePainter(
                                                data = it
                                            ),
                                            contentDescription = "",
                                            contentScale = ContentScale.FillBounds
                                        )
                                    }

                                }


                                Surface {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp)
                                    ) {


                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(0.dp)
                                        ) {
                                            it.strMeal?.let {

                                                Text(
                                                    text = it, style = MaterialTheme.typography.h5,
                                                )
                                            }

                                        }

                                        it.strArea?.let {
                                            Text(
                                                text = it,
                                                fontWeight = FontWeight.Light
                                            )
                                        }


                                        Text(text = it.strCategory)
                                        Text(text = "Tags- " +  if (it.strTags!=null) it.strTags
                                        else "null")
                                    }


                                }


                            }

                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth(), shadowElevation = 20.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                               Text(text = "Ingridents-")
                                Text(text = it.strIngredient1 + ", " + it.strIngredient2 +
                                        it.strIngredient3 +", "+ it.strIngredient4+
                                        it.strIngredient5 +", "+ it.strIngredient6+
                                        it.strIngredient7 +", "+ it.strIngredient8+
                                        it.strIngredient9 +", "+ it.strIngredient10,
                                    fontWeight = FontWeight.Light)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Surface(
                            modifier = Modifier.fillMaxWidth(), shadowElevation = 20.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {

                                Row(modifier = Modifier
                                    .height(40.dp)
                                    .fillMaxWidth()
                                    .clickable { radiobutton.value = 0 }, verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween) {

                                    Text(text = "Full Plate")
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(text = "₹200")
                                    RadioButton(selected =  (radiobutton.value==0), onClick = {
                                        radiobutton.value = 0
                                    }, colors = RadioButtonDefaults.colors(Color.Red))

                                }
                                Divider()
                                Row(modifier = Modifier
                                    .height(40.dp)
                                    .fillMaxWidth()
                                    .clickable { radiobutton.value = 1 },verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween) {
                                 Text(text ="Half Plate")
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(text = "₹100")
RadioButton(selected = radiobutton.value==1, onClick = { radiobutton.value = 1 }
    , colors = RadioButtonDefaults.colors(Color.Red))
                                }

                            }


                        }
                        Spacer(modifier = Modifier.height(10.dp))


                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp), shadowElevation = 20.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(10.dp)
                                , verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                Surface(color = Color.Red
                                , shape = RoundedCornerShape(10.dp),

                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {

                                        Icon(
                                            imageVector = Icons.Filled.KeyboardArrowUp,
                                            contentDescription = "",
                                            modifier = Modifier
                                                .rotate(-90f)
                                                .clickable {
                                                    if (addvalue.value!! > 0)
                                                        addvalue.value = addvalue.value!! - 1

                                                    addvalue.value?.let { it1 ->
                                                        Cart_entity(
                                                            add = it1,
                                                            img = it.strMealThumb,
                                                            name = it.strMeal,
                                                            id = it.idMeal
                                                        )
                                                    }?.let { it2 ->
                                                        detailscreenviewmodel.addtocart(
                                                            it2
                                                        )
                                                    }

                                                },
                                            tint = Color.White,
                                        )
                                        Text(
                                            text = if (!check.value)"Add"
                                            else cartdata.value?.add.toString(),

                                            modifier = Modifier.padding(10.dp),
                                            color = Color.White
                                        )

                                        Icon(
                                            imageVector = Icons.Filled.KeyboardArrowUp,
                                            contentDescription = "",
                                            modifier = Modifier
                                                .rotate(90f)
                                                .clickable {
                                                    addvalue.value = addvalue.value!! + 1
                                                    addvalue.value?.let { it1 ->
                                                        Cart_entity(
                                                            add = it1,
                                                            img = it.strMealThumb,
                                                            name = it.strMeal,
                                                            id = it.idMeal
                                                        )
                                                    }?.let { it2 ->
                                                        detailscreenviewmodel.addtocart(
                                                            it2
                                                        )
                                                    }

                                                },
                                          tint = Color.White
                                        )
                                    }
                                }
                                Surface(color = if (!check.value) Color.Red
                                    else Color.Green
                                    , shape = RoundedCornerShape(10.dp)
                                , modifier = Modifier.clickable {
                                    if (!check.value){
                                        detailscreenviewmodel.addtocart(
                                            Cart_entity(add = 1,
                                                img = it.strMealThumb
                                            , name = it.strMeal,
                                                id = it.idMeal)
                                        )
                                    }
                                        else{
                                            nav.navigate(screens.Cart.name)
                                        detail.popBackStack()

                                        }



                                    }

                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(text = if (!check.value) "Add to Cart"
                                            else "Go to Cart",
                                            modifier = Modifier.padding(10.dp), color = Color.White
                                       , fontWeight = FontWeight.Bold )
                                    }


                                }

                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))


                        Surface(
                            modifier = Modifier.fillMaxWidth(), shadowElevation = 20.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                        Text(text = "Try at home-")
Spacer(modifier = Modifier.height(10.dp))
                            Text(text = it.strInstructions,
                                modifier = Modifier, fontWeight = FontWeight.Light)
                        }

                        }
                    }

                }
            }
        }
    }
