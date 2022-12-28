package com.example.recyclerview_assignment_2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM product_table ORDER BY ID DESC")
    fun getAllProducts(): LiveData<List<Product>>
}