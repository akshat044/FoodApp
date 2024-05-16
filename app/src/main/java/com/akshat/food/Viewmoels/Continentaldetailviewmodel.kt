package com.akshat.food.Viewmoels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshat.food.RoomDatabase.entity.Cart_entity
import com.akshat.food.data.DataOrException

import com.akshat.food.model.categorydetail.categorydetail
import com.akshat.food.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class Continentaldetailviewmodel @Inject constructor(private val repository: AppRepository):ViewModel() {

    suspend fun getcontinentaldetail(name:String): DataOrException<categorydetail, Boolean, Exception> {
        return repository.getcontinentaldetail(name)
    }

    val cart: MutableStateFlow<List<Cart_entity>> = MutableStateFlow(emptyList())
    init {
        viewModelScope.launch {
            repository.getcart().collect() {
                cart.value = it
            }
        }

    }


    fun isMealInCart(mealId: String): Flow<Boolean> {
        return repository.isMealInCart(mealId)
    }
    // add to cart
    fun addtocart(cartEntity: Cart_entity)  = viewModelScope.launch {
        repository.inserttocart(cartEntity)
    }

}