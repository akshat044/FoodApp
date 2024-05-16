package com.akshat.food.RoomDatabase.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akshat.food.RoomDatabase.Dao.Cart_dao
import com.akshat.food.RoomDatabase.entity.Cart_entity


@Database(
    entities = [Cart_entity::class],
    version = 2
)
 abstract  class Database:RoomDatabase() {

     abstract val dao: Cart_dao

 }