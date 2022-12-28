package com.example.recyclerview_assignment_2.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.recyclerview_assignment_2.R
import com.example.recyclerview_assignment_2.data.Product
import com.example.recyclerview_assignment_2.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val product1 = intent.getSerializableExtra("product1") as Product?
        val product2 = intent.getSerializableExtra("product2") as Product?
        val product3 = intent.getSerializableExtra("product3") as Product?
        val product4 = intent.getSerializableExtra("product4") as Product?

        product1?.let {
            setProductData(product1)
        }
        product2?.let {
            setProductData(product2)
        }
        product3?.let {
            setProductData(product3)
        }
        product4?.let {
            setProductData(product4)
        }

    }

    @SuppressLint("SetTextI18n")
    private fun setProductData(product: Product) {
        Glide.with(this)
            .load(product.productImage)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.ic_default_image)
            .into(binding.imgProduct)

        binding.txtProductName.text = "Name: ${product.productName}"
        binding.txtProductPrice.text = "${product.productPrice}$"
        binding.ratingProduct.rating = product.productRating
        binding.txtProductQuantity.text = "Quantity: ${product.productQuantity}"
    }
}