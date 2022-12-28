package com.example.recyclerview_assignment_2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.recyclerview_assignment_2.data.Product
import com.example.recyclerview_assignment_2.data.ProductDatabase

class ProductViewModel(
    application: Application
): AndroidViewModel(application) {

    private val productDao = ProductDatabase.getDatabase(application).productDao()
    val getAllProducts: LiveData<List<Product>> = productDao.getAllProducts()
}