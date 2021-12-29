package com.savinoordine.beerboxcompose.repository

import androidx.lifecycle.LiveData
import com.savinoordine.beerboxcompose.domain.Beer
import com.savinoordine.beerboxcompose.domain.BeerLight
import com.savinoordine.beerboxcompose.util.network.ResultOf

interface BeerRepository {
    val beers: LiveData<List<BeerLight>>
    suspend fun getBeers(): ResultOf<List<BeerLight>>
    suspend fun getBeerDetail(id: Int): ResultOf<Beer>
}