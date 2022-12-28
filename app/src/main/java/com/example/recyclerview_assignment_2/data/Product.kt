package com.example.recyclerview_assignment_2.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

/*Create a simple application where there will be two activities.

Divide equally the first activity into 4 parts (vertically).
Every part will have a horizontal product_list using recyclerview.
Every product_list will contain 3 children
(product_img, product_name, rating).

If a specific product_item is pressed, it will navigate to the second activity.
In this second activity, display the productInfo
(product_img, product_name, product_price, rating, product_quantity),
which comes from the first activity.*/

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val productName: String,
    val productImage: String,
    val productRating: Float,
    val productPrice: Double,
    val productQuantity: Int
):Serializable
