package com.savinoordine.beerboxcompose.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savinoordine.beerboxcompose.domain.BeerLight
import com.savinoordine.beerboxcompose.repository.BeerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerListViewModel
@Inject
constructor(val beerRepository: BeerRepository) : ViewModel() {
    val state: LiveData<List<BeerLight>> = beerRepository.beers

    init {
        viewModelScope.launch {
            beerRepository.getBeers()
        }
    }

    fun loadMore() {
        viewModelScope.launch {
            beerRepository.getBeers()
        }
    }
}