package com.thiagosalper.cleanstore.injection

import com.thiagosalper.cleanstore.common.Constants
import com.thiagosalper.cleanstore.data.remote.ProductApi
import com.thiagosalper.cleanstore.data.repository.ProductRepositoryImpl
import com.thiagosalper.cleanstore.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductApi(): ProductApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsRepository(api: ProductApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }
}