package com.android.applemarket.presentation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.applemarket.data.Product
import com.android.applemarket.databinding.ProductRecyclerviewBinding
import java.text.DecimalFormat

class ProductAdapter(private val onClick: (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.Holder>() {
    var productList = listOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ProductRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val currentItem = productList[position]
        // 1000 단위 콤마 표시
        val dec = DecimalFormat("#,###")
        val price = dec.format(productList[position].price)

        holder.itemView.setOnClickListener {
            onClick(currentItem)
        }
        holder.image.setImageResource(productList[position].image)
        holder.name.text = productList[position].name
        holder.address.text = productList[position].address
        holder.price.text = "${price}원"
        holder.chatCount.text = productList[position].chatCount.toString()
        holder.likeCount.text = productList[position].likeCount.toString()
    }

    inner class Holder(val binding: ProductRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.image
        val name = binding.name
        val address = binding.address
        val price = binding.price
        val chatCount = binding.chatCount
        val likeCount = binding.likeCount
    }
}