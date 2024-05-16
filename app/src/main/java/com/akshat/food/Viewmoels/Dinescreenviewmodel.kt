package com.akshat.food.Viewmoels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshat.food.RoomDatabase.entity.Cart_entity
import com.akshat.food.model.by_first_letter.Meal
import com.akshat.food.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Dinescreenviewmodel  @Inject constructor(private val repository: AppRepository) :ViewModel() {


    val listStateFlow: MutableStateFlow<List<List<Meal>>> = MutableStateFlow(emptyList())
    init {
        getInitialData()
    }

    private fun getInitialData() {


        for (x in 'b'..'z') { // Adjusted to start from 'b' since 'a' is already fetched
            viewModelScope.launch {
                val data = repository.getbyfirstletter(x.toString()).data
                data?.let {
                    listStateFlow.value = listStateFlow.value.toMutableList().apply { add(it) }
                }
            }
        }
    }
    val cart: MutableStateFlow<List<Cart_entity>> = MutableStateFlow(emptyList())
    init {
        viewModelScope.launch {
            repository.getcart().collect() {
                cart.value = it
            }
        }

    }



    // add to cart
    fun addtocart(cartEntity: Cart_entity)  = viewModelScope.launch {
        repository.inserttocart(cartEntity)
    }



    fun isMealInCart(mealId: String): Flow<Boolean> {
        return repository.isMealInCart(mealId)
    }


}