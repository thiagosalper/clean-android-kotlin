package com.thiagosalper.cleanstore.data.remote

import com.thiagosalper.cleanstore.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {

    @GET("")
    suspend fun getProducts(): List<ProductDto>

    @GET("")
    suspend fun getProductById(@Path("prodId") prodId: String): ProductDto
}