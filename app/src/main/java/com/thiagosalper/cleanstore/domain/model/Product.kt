package com.thiagosalper.cleanstore.domain.model

import com.thiagosalper.cleanstore.data.remote.dto.ProductDto

data class Product(
    val id: String,
    val name: String,
    val image: String,
    val price: Number
)

fun ProductDto.toProduct(): Product {
    return Product(
        id = id,
        name = name,
        image = image,
        price = price
    )
}