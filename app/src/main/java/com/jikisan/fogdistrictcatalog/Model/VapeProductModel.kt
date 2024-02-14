package com.jikisan.fogdistrictcatalog.Model


data class VapeProductModel(
    val name: String,
    val image: String,
    val category: VapeCategory,
    val price: Double,
    val quantity: Int,
    val description: String
)