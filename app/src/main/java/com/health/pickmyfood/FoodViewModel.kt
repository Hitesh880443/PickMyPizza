package com.health.pickmyfood

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodViewModel(private val foodRepo : FoodRepo) : ViewModel() {

    private val _myPizza :  MutableLiveData<FoodItem> = MutableLiveData()
    val myPizza : LiveData<FoodItem> = _myPizza

    fun pickMyPizza() {
        _myPizza.value = foodRepo.getFoodItem()
    }

}