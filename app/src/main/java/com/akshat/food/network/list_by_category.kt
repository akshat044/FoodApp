package com.akshat.food.network

import com.akshat.food.model.categorydetail.categorydetail
import retrofit2.http.GET
import retrofit2.http.Query

interface list_by_category {
    @GET("filter.php")
    suspend fun categorydata(
        @Query("c")category:String
    ): categorydetail
}