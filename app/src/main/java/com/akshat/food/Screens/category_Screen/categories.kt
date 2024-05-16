package com.akshat.food.Screens.category_Screen

import ImageList
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.akshat.food.R
import com.akshat.food.Navigation.Navigation_Screen_Data.screens

import com.example.foodpanda.Viewmoels.Categoryviewmodel
import com.akshat.food.data.Countrydata
import com.akshat.food.data.x
import com.akshat.food.model.categories.Category





@SuppressLint("ProduceStateDoesNotAssignValue")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories(viemodel: Categoryviewmodel, detail: NavHostController,) {


    val imagedisplay = listOf(
    "https://www.shutterstock.com/image-vector/hamburger-ads-design-on-blackboard-260nw-1346026241.jpg",
        "https://img.freepik.com/premium-psd/french-fries-catch-up-catchup-foid-potato-tomato-social-media-post-template-design_462808-221.jpg",
        "https://previews.123rf.com/images/malyshok/malyshok2305/malyshok230500010/204342248-a-promotional-poster-of-noodle-soup-that-is-bursting-with-color-and-brightness-complete-with.jpg",
        "https://www.shutterstock.com/shutterstock/photos/1815037130/display_1500/stock-vector-delicious-fried-chicken-set-on-wooden-restaurant-table-concept-of-big-meal-in-d-illustration-1815037130.jpg",
"https://img.freepik.com/premium-psd/psd-template-instagram-post-banner-about-delicious-paneer-indian-food_824079-17.jpg"
    )



Surface(modifier = Modifier
    .fillMaxSize()

   ) {
    if (viemodel.categorydata.value.loading==true){
        CircularProgressIndicator()
    }

    else
Column(modifier = Modifier.fillMaxSize()) {



       Surface(modifier = Modifier
           .fillMaxWidth()
           .height(70.dp)
           .clip(RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
       ,
           color = Color(0xFF00006F)
       ) {

Row(modifier = Modifier.fillMaxSize(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically) {
    Text(text = "Panda Food",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 5.em
       )
}


       }


        LazyColumn(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
item { Spacer(modifier = Modifier.height(5.dp)) }

          item {
Surface(modifier = Modifier
    .fillMaxWidth()
    .height(200.dp)
, shape = RoundedCornerShape(20.dp)
) {


    ImageList(imageIds = imagedisplay)
}
          }

            item {
                Divider(modifier = Modifier.padding(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "What's On Your Mind",
                        style = TextStyle(fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold)
                    )
                }
            }
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {


                    if (viemodel.categorydata.value.data != null) {
                        val x = viemodel.categorydata.value.data!!

                        LazyHorizontalGrid(rows = GridCells.Fixed(2),) {

                            items(x) {
                                arrangementofcategories(item = it,detail)
                            }

                        }
                    }
                }
                // offers

                Divider(modifier = Modifier.padding(30.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {


                    Text(
                        text = "Explore",
                        style = TextStyle(fontFamily = FontFamily.Monospace),
                        modifier = Modifier.padding(bottom = 10.dp)
                        ,fontWeight = FontWeight.Bold
                    )

                }
Row(modifier = Modifier.fillMaxWidth()) {
    Surface(modifier = Modifier
        .size(180.dp)
        .weight(1f)
        .padding(10.dp)
    , color = Color.White
    , shadowElevation = 5.dp
    , shape = RoundedCornerShape(20.dp)
    ) {
Column(modifier = Modifier
    .fillMaxSize()
    .padding(20.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

Image(painter = painterResource(id = R.drawable.gift), contentDescription = "",
    modifier = Modifier.weight(2f))

    Text(text = "Offers"
    , fontWeight = FontWeight.Light,
        modifier = Modifier.weight(1f))
}


    }

    Surface(modifier = Modifier
        .size(180.dp)
        .weight(1f)
        .padding(10.dp)
        , color = Color.White
        , shadowElevation = 5.dp
        , shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painter = painterResource(id = R.drawable.restaurant), contentDescription ="",
                modifier = Modifier.weight(2f))

            Text(text = "Top 10 "
            , fontWeight = FontWeight.Light,
                modifier = Modifier.weight(1f))

        }


    }

    Surface(modifier = Modifier
        .size(180.dp)
        .weight(1f)
        .padding(10.dp)
        , color = Color.White
        , shadowElevation = 5.dp
        , shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

Image(painter = painterResource(id = R.drawable.crown), contentDescription = "",
    modifier = Modifier.weight(2f))

            Text(text = "Premium", modifier = Modifier.weight(1f)
            ,  fontWeight = FontWeight.Light)
        }


    }



}




                Divider(modifier = Modifier.padding(30.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {


                    Text(
                        text = "Continental Lover",
                        style = TextStyle(fontFamily = FontFamily.Monospace),
                        modifier = Modifier.padding(bottom = 10.dp),
                        fontWeight = FontWeight.Bold
                    )

                }
            }



            // for continentes
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {


                    LazyHorizontalGrid(rows = GridCells.Fixed(2),) {
                        items(x) {
                            countryaa(it,detail)


                        }


                    }


                }

                Divider(modifier = Modifier.padding(30.dp))
            }

        }
    }
        }
    }

@Composable
fun countryaa(x: Countrydata, detail: NavHostController){
    Surface(modifier = Modifier
        .size(150.dp)
        .padding(20.dp)
        .clickable {
            detail.navigate(route ="${screens.Categorydetailscreen.name}/continent/${x.Countryname}")
        }

    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

Surface(modifier = Modifier,
    shape = RoundedCornerShape(20.dp)
) {


    Image(
        painter = rememberImagePainter(data = x.image), contentDescription = "",
        contentScale = ContentScale.Fit
    )
}
            Text(text =x.Countryname,
                fontWeight = FontWeight.Light,
            )
        }
    }

}


@Composable
fun arrangementofcategories(item: Category, detail: NavHostController) {
Surface(modifier = Modifier
    .size(150.dp)
    .padding(20.dp)
    .clickable { detail.navigate(route = "${screens.Categorydetailscreen.name}/normal/${item.strCategory}") }
 ) {
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = rememberImagePainter(data = item.strCategoryThumb), contentDescription = "",
            contentScale = ContentScale.Fit
        )
        Text(
            text = item.strCategory,
            fontWeight = FontWeight.Light,
        )
    }
}}



