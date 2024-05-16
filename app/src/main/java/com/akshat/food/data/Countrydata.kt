package com.akshat.food.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

data class Countrydata(
    val Countryname:String,
    val image:String
)
val x = listOf(
    Countrydata(
        "American",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Soul_Food_at_Powell%27s_Place.jpg/270px-Soul_Food_at_Powell%27s_Place.jpg"  ),
    Countrydata(
        "British",
        "https://www.thomascook.in/blog/wp-content/uploads/2015/09/italy-chicken-parmesan.jpg"   ),
    Countrydata(
        "Canadian",
        "https://www.hostelworld.com/blog/wp-content/uploads/2017/06/Ultimate-Guide-to-Canadian-Food-Bannock-@torebergengen.jpg" ),
    Countrydata(
        "Chinese",
        "https://www.thomascook.in/blog/wp-content/uploads/2015/09/china-peking-duck.jpg"
    ),
    Countrydata(
        "Croatian",
        "https://d2rdhxfof4qmbb.cloudfront.net/wp-content/uploads/20190723152844/Preparing-and-Cooking-of-octopus-in-traditional-Croatian-peka-Sa.jpg"
    ),
    Countrydata(
        "Dutch",
        "https://www.holidify.com/images/cmsuploads/compressed/FoodsofNetherlands_20230626171307.jpg"
    ),
    Countrydata(
        "Egyptian",
        "https://images.memphistours.com/large/5f00f990272320282d98da1928fd8324.jpg"
    ),
    Countrydata(
        "Filipino",
        "https://img.traveltriangle.com/blog/wp-content/uploads/2018/08/shutterstock_677573950.jpg"
    ),
    Countrydata(
        "French",
        "https://www.thomascook.in/blog/wp-content/uploads/2015/09/Vietnam-Bun-Cha.jpg"
    ),
    Countrydata(
        "Greek",
        "https://www.greekality.com/wp-content/uploads/2022/01/moussaka.png"
    ),
    Countrydata(
        "Indian",
        "https://static.toiimg.com/photo/72023714.cms"
    ),
    Countrydata(
        "Irish",
        "https://hips.hearstapps.com/hmg-prod/images/irish-sausage-and-champ-horizontal-1676062816.jpg"
    ),
    Countrydata(
        "Italian",
        "https://cdn.sightseeingtoursitaly.com/wp-content/uploads/2019/06/Famous-Italian-dishes.jpg"
    ),
    Countrydata(
        "Jamaican",
        "https://www.beaches.com/blog/content/images/2020/03/Jamaican-Brown-Stew-Chicken.jpg"
    ),
    Countrydata(
        "Japanese",
        "https://www.thomascook.in/blog/wp-content/uploads/2015/09/japan-sushi.jpg"
    ),
    Countrydata(
        "Kenyan",
        "https://images.saymedia-content.com/.image/t_share/MTc0NDI3ODYxNzA3NDY2MDg4/30-foods-you-should-eat-in-kenya.jpg"
    ),
    Countrydata(
        "Malaysian",
        "https://media.cnn.com/api/v1/images/stellar/prod/130614114257-malaysia-food.jpg?q=w_1200,h_800,x_0,y_0,c_fill"
    ),
    Countrydata(
        "Mexican",
        "https://www.thomascook.in/blog/wp-content/uploads/2015/09/mexico-tamales.jpg"
    ),
    Countrydata(
        "Moroccan",
        "https://www.willflyforfood.net/wp-content/uploads/2021/09/moroccan-food-kaab-el-ghzal.jpg.webp"
    ),
    Countrydata(
        "Polish",
        "https://media.cnn.com/api/v1/images/stellar/prod/200811115525-04-best-polish-foods.jpg?q=w_1600,h_900,x_0,y_0,c_fill/h_618"
    ),
    Countrydata(
        "Portuguese",
        "https://www.hfhotels.com/conteudos/hf-hotels-melhor-comida-portuguesa-pasteis-belem.jpg"
    ),
    Countrydata(
        "Russian",
        "https://i0.wp.com/www.trafalgar.com/real-word/wp-content/uploads/sites/3/2020/02/blini-russian-pancakes.jpg?resize=910%2C607&ssl=1"
    ),
    Countrydata(
        "Spanish",
        "https://www.thomascook.in/blog/wp-content/uploads/2015/09/Spain-Paella.jpg"
    ),
    Countrydata(
        "Thai",
        "https://www.thomascook.in/blog/wp-content/uploads/2015/09/Thailand-Tom-Yum-Goong.jpg"
    ),
    Countrydata(
        "Tunisian",
        "https://www.willflyforfood.net/wp-content/uploads/2022/01/tunisian-food-chakchouka.jpg.webp"
    ),
    Countrydata(
        "Turkish",
        "https://www.thomascook.in/blog/wp-content/uploads/2015/09/Turkey-Lahmacun.jpg"
    ),
    Countrydata(
        "Unknown",
        "https://img.veenaworld.com/wp-content/uploads/2021/09/Top-10-Most-Iconic-Foods-to-Eat-in-Italy.jpg"
    ),
    Countrydata(
        "Vietnamese",
        "https://www.thomascook.in/blog/wp-content/uploads/2015/09/Thailand-Tom-Yum-Goong.jpg"
    )
)




@Composable
fun CountryData(){
Surface {
    Column {

        var l = 0;



  for (
   m in 0..x.size-3
  ){
      Row (modifier = Modifier.fillMaxWidth()
          .padding(bottom = 0.dp),
          horizontalArrangement = Arrangement.SpaceEvenly){
        if (l< x.size){
         area(l = l)

            l++
area(l = l)
      }}
      l+=1



  }
}}}
@Composable
fun area(l: Int) {
Surface(modifier = Modifier
    .padding(bottom =  50.dp)
    .clip(RoundedCornerShape(0.dp))
  ) {
    Column(modifier = Modifier.padding(0.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(modifier = Modifier.size(150.dp
            ).clip(RoundedCornerShape(20.dp))
            ) {


            Image(
                painter = rememberAsyncImagePainter(model = x[l].image),
                contentDescription = "", contentScale = ContentScale.Crop
            )
        }

        Text(text = x[l].Countryname, modifier = Modifier.padding(top = 10.dp)
        , fontFamily = FontFamily.Default
        , fontWeight = FontWeight.Light,
            )
    }

}


}



