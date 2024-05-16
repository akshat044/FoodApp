package com.akshat.food.network

import com.akshat.food.model.Detailmeal.mealdetail
import retrofit2.http.GET
import retrofit2.http.Query

interface Meal_by_Id_api {

@GET("lookup.php")
suspend fun getmealdetail(
    @Query("i")id:String
): mealdetail



}