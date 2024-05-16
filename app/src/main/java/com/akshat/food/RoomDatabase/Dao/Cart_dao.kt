package com.akshat.food.RoomDatabase.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.akshat.food.RoomDatabase.entity.Cart_entity
import kotlinx.coroutines.flow.Flow

@Dao
interface Cart_dao {

    @Upsert
    suspend fun adddata(cartEntity: Cart_entity)

    @Delete
    suspend fun delete(cartEntity: Cart_entity)

    @Query("SELECT *  FROM cart")
    fun getallcartitem():Flow<List<Cart_entity>>

    @Query("SELECT COUNT(*) FROM cart")
    fun getrowno():Flow<Int>

    @Query("SELECT EXISTS (SELECT 1 FROM cart WHERE id = :mealId LIMIT 1)")
    fun isMealInCart(mealId: String): Flow<Boolean>

    @Query("SELECT * FROM cart  WHERE id = :id LIMIT 1")
    fun onedata(id:String):Flow<Cart_entity>

}