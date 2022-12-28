package com.example.recyclerview_assignment_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.recyclerview_assignment_2.R
import com.example.recyclerview_assignment_2.databinding.ProductItemBinding
import com.example.recyclerview_assignment_2.data.Product
class ProductAdapter1: RecyclerView.Adapter<ProductAdapter1.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object: DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.productImage == newItem.productImage
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = differ.currentList[position]

        Glide.with(holder.itemView.context)
            .load(product.productImage)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.ic_default_image)
            .into(holder.binding.imgProduct)

        holder.binding.txtProductName.text = product.productName
        holder.binding.ratingProduct.rating = product.productRating

        holder.binding.root.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.recycler_anim)

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(product)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Product) -> Unit)? = null

    fun setOnItemClickListener(listener: (Product) -> Unit){
        onItemClickListener = listener
    }
}

