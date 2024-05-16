package com.akshat.food.network


import com.akshat.food.model.categorydetail.categorydetail
import retrofit2.http.GET
import retrofit2.http.Query

interface List_by_continents {
    @GET("filter.php")
    suspend fun getcontinentaldetail (
        @Query("a")name:String
    ): categorydetail
}