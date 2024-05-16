package com.akshat.food.Screens.Cart_Screen

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.akshat.food.Navigation.Navigation_Screen_Data.screens
import com.akshat.food.RoomDatabase.entity.Cart_entity
import com.akshat.food.Viewmoels.cartviewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun CartScreen(Cartviewmodel: cartviewmodel, detail: NavHostController) {
    val restaurantNames = listOf(
        "The Hungry Panda",
        "Bella Italia",
        "Tokyo Sushi House",
        "Spice Avenue",
        "The Cheesy Crust Pizzeria",
        "Golden Dragon Chinese Restaurant",
        "The Green Leaf Salad Bar",
        "La Fiesta Mexican Grill",
        "The Sizzling Steakhouse",
        "Ocean's Catch Seafood Restaurant",
        "Heavenly Desserts Bakery",
        "Sultan's Palace Middle Eastern Cuisine",
        "The Cozy Cafe",
        "Flavors of India",
        "BBQ Junction Grill House"
    )

    val itemscount = Cartviewmodel.isempty.collectAsState()
    val items = Cartviewmodel.cart.collectAsState()

    val totalprice = remember {
        mutableStateOf(0)
    }

       for (total  in 0.. items.value.size){


       }








    val coroutineScope = CoroutineScope(Dispatchers.IO)
    val coroutineScope1 = CoroutineScope(Dispatchers.IO)

Surface(modifier = Modifier.fillMaxSize()) {
    Column(modifier = Modifier.padding(top = 4.dp)) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(5.dp),
            shadowElevation = 5.dp
        , shape = RoundedCornerShape(5.dp)
        , color = Color(0xff00008B)
        ) {
Row(modifier = Modifier
    .fillMaxWidth()
    .padding(start = 4.dp, end = 4.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween) {
    Text(text = "My Cart", color = Color.White)

    Text(text = "Panda Food", color = Color.White)

Text(text = "Total Items - ${itemscount.value}", color = Color.White)
} }

   LazyColumn(){

       items(items.value){
           production(it,Cartviewmodel,coroutineScope,restaurantNames,coroutineScope1)

       }
   }

        Surface(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
         Surface {
             val x  = totalprice.value.toString()


         }

              Surface(color = Color.Red, shape = RoundedCornerShape(5.dp),
                  modifier = Modifier.clickable {
                      detail.navigate(screens.orderplaced.name)
                  }
              ) {
                  Text(text = "Place Order", color = Color.White,
                      modifier = Modifier.padding(10.dp))
              }



            }
        }

    }




}





}
@OptIn(DelicateCoroutinesApi::class)
@Composable
fun production(
    it: Cart_entity,
    Cartviewmodel: cartviewmodel,
    coroutineScope: CoroutineScope,
    restaurantNames: List<String>,
    coroutineScope1: CoroutineScope
) {
Surface(modifier = Modifier
    .fillMaxWidth()
    .padding(5.dp)) {
    Row(modifier = Modifier.fillMaxWidth()) {


        Column(modifier = Modifier.width(70.dp)) {


      Surface(modifier = Modifier.height(70.dp)) {
          Image(painter = rememberImagePainter(data = it.img), contentDescription = "")
      }
            Spacer(modifier = Modifier.height(5.dp))

       Surface(color = Color.Red) {
  Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
      modifier = Modifier.fillMaxWidth()) {


      Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = "",
          modifier = Modifier
              .rotate(180f)
              .clickable {
                  coroutineScope.launch {
                      if (it.add > 0)
                          Cartviewmodel.add(
                              Cart_entity(
                                  add = it.add - 1,
                                  img = it.img,
                                  name = it.name,
                                  id = it.id
                              )
                          )
                  }
              },
          tint = Color.White)


      Text(
          text = it.add.toString(), modifier = Modifier.padding(4.dp),
          color = Color.White
      )



      Icon(
          imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = "",
          tint = Color.White, modifier = Modifier        .clickable {

              coroutineScope.launch {
                  Cartviewmodel.add(
                      Cart_entity(
                          add =   it.add+1,
                          img = it.img,
                          name = it.name,
                          id = it.id
                      )
                  )
              }
          }
      )
  }
       }
        }

        Column(modifier = Modifier.padding(start = 20.dp)) {
            Text(text = it.name)

            Text(text = "Total Amount -  ₹"+(100*it.add).toString())

            Text(text = "Restaurant name - ${restaurantNames.random()}")

            Surface(color = Color.Red,
                modifier = Modifier.clickable {
                    coroutineScope1.launch {
                        Cartviewmodel.delete(
                            it
                        )

                    }

                }) {

                Text(text = "Remove From list", color = Color.White,
                    modifier = Modifier.padding(5.dp))
            }

        }




    }



}


}
