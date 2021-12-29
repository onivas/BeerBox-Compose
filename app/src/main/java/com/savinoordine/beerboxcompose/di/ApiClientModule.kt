package com.savinoordine.beerboxcompose.di

import com.savinoordine.beerboxcompose.repository.BeerApiClient
import com.savinoordine.beerboxcompose.repository.BeerApiClientImpl
import com.savinoordine.beerboxcompose.repository.BeerRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiClientModule {

    @Binds
    @Singleton
    abstract fun BeerApiClientImpl.bindBeerRepository(): BeerRepository

    companion object {
        @Provides
        @Singleton
        fun provideBeerApiClient(retrofit: Retrofit): BeerApiClient =
            retrofit.create(BeerApiClient::class.java)
    }
}