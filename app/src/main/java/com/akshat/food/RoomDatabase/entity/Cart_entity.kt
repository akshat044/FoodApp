package com.akshat.food.RoomDatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class Cart_entity(
    val add:Int,
    val img:String,
    val name:String,
    @PrimaryKey
    val id:String,
)
