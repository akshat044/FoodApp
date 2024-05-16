package com.example.foodpanda.Viewmoels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshat.food.data.DataOrException
import com.akshat.food.model.categories.Category
import com.akshat.food.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class Categoryviewmodel @Inject constructor(private val repository: AppRepository):ViewModel()
{
    val categorydata:MutableState<DataOrException<List<Category>,
            Boolean, Exception>> = mutableStateOf(
                DataOrException(null,true,Exception(""))
            )
    init {
        getcategorydata()
    }

    private fun getcategorydata() {
        viewModelScope.launch {
           categorydata.value = repository.getallCategories()
        }


    }
}