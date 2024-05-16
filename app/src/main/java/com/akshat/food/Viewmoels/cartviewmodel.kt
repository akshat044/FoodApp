package com.akshat.food.Viewmoels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshat.food.RoomDatabase.entity.Cart_entity
import com.akshat.food.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class cartviewmodel @Inject constructor(private val repository: AppRepository)  :ViewModel(){
    val isempty: MutableStateFlow<Int> = MutableStateFlow(0)
    init {
        viewModelScope.launch {
            repository.getrowcount().collect {
                isempty.value = it
            }
        }

    }

// get cart

    val cart: MutableStateFlow<List<Cart_entity>> = MutableStateFlow(emptyList())
    init {
        viewModelScope.launch {
            repository.getcart().collect {
                cart.value = it
            }
        }

    }

    // delete from cart

    fun delete(cartEntity: Cart_entity) = viewModelScope.launch {
        repository.delete(cartEntity)
    }

    fun add(cartEntity: Cart_entity) = viewModelScope.launch {
        repository.inserttocart(cartEntity)
    }



}