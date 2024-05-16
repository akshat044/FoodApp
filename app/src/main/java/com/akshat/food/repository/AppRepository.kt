package com.akshat.food.repository

import android.util.Log
import com.akshat.food.RoomDatabase.Dao.Cart_dao
import com.akshat.food.RoomDatabase.entity.Cart_entity
import com.akshat.food.data.DataOrException

import com.akshat.food.model.Detailmeal.mealdetail
import com.akshat.food.model.by_first_letter.Meal
import com.akshat.food.model.categories.Category
import com.akshat.food.model.categorydetail.categorydetail
import com.akshat.food.network.Category_Api
import com.akshat.food.network.List_by_continents
import com.akshat.food.network.Meal_by_Id_api
import com.akshat.food.network.list_api
import com.akshat.food.network.list_by_category
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppRepository @Inject constructor(private val categoryApi: Category_Api,
                                        private val listApi: list_api,
                                        private val MealApi: Meal_by_Id_api,
                                        private val listByCategory: list_by_category,
                                        private val listByContinents: List_by_continents,
                                        private val cartDao: Cart_dao
) {




    private val Categorydata = DataOrException<List<Category>,Boolean,Exception>()
// getting categorydata
  suspend fun getallCategories(): DataOrException<List<Category>, Boolean, Exception> {
        try {
            Categorydata.loading= true
            Categorydata.data = categoryApi.getcategories().categories
            if (Categorydata.data!=null){Categorydata.loading=false}
        }
        catch (exception:Exception

        ){
Categorydata.e = exception
            Log.d("Exception",exception.toString())
        }


return Categorydata
    }



//getting listof meals

    private val listdata =   DataOrException< List<Meal>,Boolean,Exception>()

    suspend fun getbyfirstletter(letter:String): DataOrException<List<Meal>, Boolean, Exception> {
        try {
            listdata.loading=true
            listdata.data = listApi.getlist(letter).meals
            if (listdata.data!=null) {listdata.loading= false}


        }
        catch (
            e:Exception
        ){
            listdata.e = e
            Log.d("Exception",e.toString())
        }

      return listdata
    }




// getting details of meal

    private val getmealdetail = DataOrException<mealdetail,Boolean,Exception>()

    suspend fun getmealdetail(id:String): DataOrException<mealdetail, Boolean, Exception> {
        try {
            getmealdetail.loading  = true
            getmealdetail.data  =  MealApi.getmealdetail(id)
            if (getmealdetail.data!=null) {getmealdetail.loading=false}

        }
        catch (E:Exception){
            getmealdetail.e =E
            Log.d("Exception",E.toString())
        }

        return getmealdetail
    }




    // getting categorydata
    private val getcategorydetail = DataOrException<categorydetail,Boolean,Exception>()

    suspend fun getcategorydetail(category:String): DataOrException<categorydetail, Boolean, Exception> {
        try {
            getcategorydetail.loading = true
            getcategorydetail.data = listByCategory.categorydata(category)
            getcategorydetail.loading = false
        }
        catch (e:Exception){
            getcategorydetail.e  = e
            Log.d("exception",e.toString())
        }

      return getcategorydetail
    }


    //getting continetal

    private val getcontinentaldetail = DataOrException<categorydetail,Boolean,Exception>()
    suspend fun getcontinentaldetail(category:String): DataOrException<categorydetail, Boolean, Exception> {
        try {
            getcontinentaldetail.loading = true

            getcontinentaldetail.data = listByContinents.getcontinentaldetail(category)
            getcontinentaldetail.loading = false
        }
        catch (e:Exception){
            getcontinentaldetail.e  = e
            Log.d("exception",e.toString())
        }

        return getcontinentaldetail



    }

    // room actions

    //insert
    suspend fun inserttocart(cartEntity: Cart_entity) = cartDao.adddata(cartEntity)


    //delete
    suspend fun delete(cartEntity: Cart_entity) = cartDao.delete(cartEntity)


    // getdetails

    fun getcart(): Flow<List<Cart_entity>> =cartDao.getallcartitem()


    // get rowcount

    fun getrowcount():Flow<Int>  =cartDao.getrowno()


    fun isMealInCart(mealId: String): Flow<Boolean> {
        return cartDao.isMealInCart(mealId)
    }

    fun onemealdata(id:String):Flow<Cart_entity>{
        return cartDao.onedata(id)
    }
}