package com.akshat.food.data
data class DataOrException<T, Boolean, E: Exception>(
    var data: T? = null,
    var loading: kotlin.Boolean = true,
    var e: E? = null)
