package com.thiagosalper.cleanstore.data.repository

import javax.inject.Inject
import com.thiagosalper.cleanstore.data.remote.ProductApi
import com.thiagosalper.cleanstore.data.remote.dto.ProductDto
import com.thiagosalper.cleanstore.domain.repository.ProductRepository

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {
    override suspend fun getProducts(): List<ProductDto> {
        return api.getProducts()
    }

    override suspend fun getProductById(prodId: String): ProductDto {
        return api.getProductById(prodId)
    }
}