package com.example.recyclerview_assignment_2.ui

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_assignment_2.adapter.ProductAdapter1
import com.example.recyclerview_assignment_2.adapter.ProductAdapter2
import com.example.recyclerview_assignment_2.adapter.ProductAdapter3
import com.example.recyclerview_assignment_2.adapter.ProductAdapter4
import com.example.recyclerview_assignment_2.data.Product
import com.example.recyclerview_assignment_2.databinding.ActivityProductBinding
import com.example.recyclerview_assignment_2.viewmodel.ProductViewModel
import com.example.recyclerview_assignment_2.viewmodel.ProductViewModelProviderFactory

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding

    private lateinit var productViewModel: ProductViewModel

    private val productAdapter1: ProductAdapter1 by lazy { ProductAdapter1() }
    private val productAdapter2: ProductAdapter2 by lazy { ProductAdapter2() }
    private val productAdapter3: ProductAdapter3 by lazy { ProductAdapter3() }
    private val productAdapter4: ProductAdapter4 by lazy { ProductAdapter4() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productViewModelProviderFactory = ProductViewModelProviderFactory(applicationContext as Application)
        productViewModel = ViewModelProvider(this,productViewModelProviderFactory)[ProductViewModel::class.java]

        setUpAllRecyclerViews()

        productAdapter1.setOnItemClickListener { sendData("product1", it) }
        productAdapter2.setOnItemClickListener { sendData("product2", it) }
        productAdapter3.setOnItemClickListener { sendData("product3", it) }
        productAdapter4.setOnItemClickListener { sendData("product4", it) }


        mockData()
    }

    private fun sendData(key: String, it: Product) {
        val intent = Intent(this, ProductDetailsActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(key, it)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun mockData() {
        val shoe1 = Product(0, "Superstar", "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/36b3b78628a04b09b525af41010dec7d_9366/Superstar_Shoes_White_GX9876_01_standard.jpg", 3.1f, 35.5, 23)
        val shoe2 = Product(0, "Barker", "https://cdn.shopify.com/s/files/1/0046/9139/4658/files/SS20_HOMEPAGE_MCCLEANPAIR_880x550_crop_center.jpg?v=1614334815", 5.0f, 110.0, 50)
        val shoe3 = Product(0, "Work Boots", "https://cdn.shopify.com/s/files/1/0504/6113/files/Mister-Safety-Shoes-Mobile-min_1_1.jpg?v=1632115773", 1.2f, 60.0, 34)
        val glass2 = Product(0, "LensCrafters", "https://assets.lenscrafters.com/is/image/LensCrafters/8053672808469__STD__shad__qt.png", 2.5f, 12.9, 122)
        val glass1 = Product(0, "Eye Wear", "https://cdn.shopify.com/s/files/1/0562/8903/4283/files/HOMEWOMANS_1024x1024.jpg?v=1667857675", 4.0f, 13.0, 45)
        val glass3 = Product(0, "Transparent Glass", "https://iris.ca/media/amasty/blog/BLG-202100723-Turko-5reasonstolovethetransparentframes-Main.jpg", 5.0f, 22.0, 12)
        val pant1 = Product(0, "Mens Jeans", "https://shodagor-uploads.s3.ap-south-1.amazonaws.com/uploads/all/mbrdw.jpg", 3.0f, 15.0, 39)
        val pant2 = Product(0, "Jeans, Dark Blue", "https://shodagor-uploads.s3.ap-south-1.amazonaws.com/uploads/all/mbrdw.jpg", 3.9f, 32.0, 66)
        val pant3 = Product(0, "Jeans, Bright", "https://shodagor-uploads.s3.ap-south-1.amazonaws.com/uploads/all/mbrdw.jpg", 4.5f, 25.0, 122)
        val tshirt1 = Product(0, "Mens, Yellow", "https://s3-eu-west-1.amazonaws.com/jhk-public/uploads/portadas/imagen/1267f5c160f406cd0a7a9a0e0afc33c0b16d2495.jpg", 4.5f, 8.5, 234)
        val tshirt2 = Product(0, "Mens, Water Splash", "https://fabrilife.com/image-gallery/61a794e19d4b4-square.jpg", 5.0f, 11.0, 121)
        val tshirt3 = Product(0, "Mens, Blue", "https://static05.jockey.in/uploads/dealimages/10081/zoomimages/move-blue-t-shirt-mv01-119.jpg", 3.1f, 9.8, 90)

        val shoes = listOf(shoe1, shoe2, shoe3,shoe1, shoe2, shoe3,shoe1, shoe2, shoe3,shoe1, shoe2, shoe3)
        val glasses = listOf(glass1, glass2, glass3,glass1, glass2, glass3,glass1, glass2, glass3,glass1, glass2, glass3)
        val pants = listOf(pant1, pant2, pant3,pant1, pant2, pant3,pant1, pant2, pant3,pant1, pant2, pant3)
        val tshirts = listOf(tshirt1, tshirt2, tshirt3,tshirt1, tshirt2, tshirt3,tshirt1, tshirt2, tshirt3,tshirt1, tshirt2, tshirt3)

        productAdapter1.differ.submitList(shoes)
        productAdapter2.differ.submitList(glasses)
        productAdapter3.differ.submitList(pants)
        productAdapter4.differ.submitList(tshirts)
    }

    private fun setUpAllRecyclerViews() {
        //could use single adapter, thought, it might look good different products on different recyclerview
        val rvProductList1 = binding.rvProductList1
        val rvProductList2 = binding.rvProductList2
        val rvProductList3 = binding.rvProductList3
        val rvProductList4 = binding.rvProductList4
        rvProductList1.adapter = productAdapter1
        rvProductList2.adapter = productAdapter2
        rvProductList3.adapter = productAdapter3
        rvProductList4.adapter = productAdapter4
        val recyclerViews = listOf(rvProductList1, rvProductList2, rvProductList3, rvProductList4)
        recyclerViews.forEach {
            it.layoutManager = LinearLayoutManager(this@ProductActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}