package com.thiagosalper.cleanstore.presentation.products

import com.thiagosalper.cleanstore.domain.model.Product

data class ProductListState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""
)
