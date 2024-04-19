package com.android.applemarket.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.applemarket.R
import com.android.applemarket.data.Product
import com.android.applemarket.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    companion object {
        const val EXTRA_PRODUCT: String = "extra_product"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val pItem = intent.getParcelableExtra< Product>(EXTRA_PRODUCT)
        // 1000 단위 콤마 표시
        val dec = DecimalFormat("#,###")
        val price = dec.format(pItem!!.price)

        binding.image.setImageResource(pItem!!.image)
        binding.seller.text = pItem.seller
        binding.address.text = pItem.address
        binding.name.text = pItem.name
        binding.description.text = pItem.description
        binding.price.text = price

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}