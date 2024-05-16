package com.akshat.food.network

import com.akshat.food.model.categories.categories
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface Category_Api {
    @GET("categories.php")
    suspend fun getcategories(): categories

}