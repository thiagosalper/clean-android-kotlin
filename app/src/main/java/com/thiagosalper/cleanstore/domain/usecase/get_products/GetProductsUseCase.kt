package com.thiagosalper.cleanstore.domain.usecase.get_products

import com.thiagosalper.cleanstore.common.Resource
import com.thiagosalper.cleanstore.domain.model.Product
import com.thiagosalper.cleanstore.domain.model.toProduct
import com.thiagosalper.cleanstore.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.getProducts().map { it.toProduct() }
            emit(Resource.Success(products))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurrede"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}