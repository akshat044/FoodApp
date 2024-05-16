package com.akshat.food.network

import com.akshat.food.model.by_first_letter.first_letter
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface list_api {
@GET("api/json/v1/1/search.php")
suspend fun getlist(
    @Query("f")firstletter:String
): first_letter


}