package com.thiagosalper.cleanstore.domain.repository

import com.thiagosalper.cleanstore.data.remote.dto.ProductDto

interface ProductRepository {
    suspend fun getProducts(): List<ProductDto>

    suspend fun getProductById(prodId: String): ProductDto
}