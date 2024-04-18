package com.android.applemarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.applemarket.databinding.ProductRecyclerviewBinding

class ProductAdapter(val pList: MutableList<Product>) : RecyclerView.Adapter<ProductAdapter.Holder>() {

    inner class Holder(val binding: ProductRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.image
        val name = binding.name
        val address = binding.address
        val price = binding.price
        val chatCount = binding.chatCount
        val likeCount = binding.likeCount
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ProductRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return pList.size
    }

    override fun onBindViewHolder(holder: ProductAdapter.Holder, position: Int) {
        holder.image.setImageResource(pList[position].image)
        holder.name.text = pList[position].name
        holder.address.text = pList[position].address
        holder.price.text = "${pList[position].price}원"
        holder.chatCount.text = pList[position].chatCount.toString()
        holder.likeCount.text = pList[position].likeCount.toString()

    }
}