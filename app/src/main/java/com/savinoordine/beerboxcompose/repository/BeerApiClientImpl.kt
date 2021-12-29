package com.savinoordine.beerboxcompose.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.savinoordine.beerboxcompose.domain.Beer
import com.savinoordine.beerboxcompose.domain.BeerLight
import com.savinoordine.beerboxcompose.repository.model.toEntity
import com.savinoordine.beerboxcompose.util.network.ResultOf
import com.savinoordine.beerboxcompose.util.network.map
import com.savinoordine.beerboxcompose.util.network.onSuccess
import javax.inject.Inject


class BeerApiClientImpl
@Inject constructor(private val beerApiClient: BeerApiClient) : BeerRepository {

    private var _searchingPage = 1

    private val _beers: MutableLiveData<List<BeerLight>> =
        MutableLiveData<List<BeerLight>>(emptyList())
    override val beers: LiveData<List<BeerLight>>
        get() = _beers

    override suspend fun getBeers(): ResultOf<List<BeerLight>> {
        return beerApiClient.getBeers(_searchingPage)
            .map { it.toEntity() }
            .onSuccess { newBeers ->
                if (newBeers.isNotEmpty()) {
                    _searchingPage = _searchingPage.inc()
                }
                _beers.postValue(_beers.value?.plus(newBeers))
            }
    }

    override suspend fun getBeerDetail(id: Int): ResultOf<Beer> {
        return beerApiClient.getBeerDetail(id)
            .map { it.first().toEntity() }
    }
}