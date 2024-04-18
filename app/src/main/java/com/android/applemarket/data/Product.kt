package com.android.applemarket.data

data class Product(
    val number: Int,
    val image: Int,
    val name: String,
    val description: String,
    val seller: String,
    val price: Int,
    val address: String,
    val likeCount: Int,
    val chatCount: Int
)
