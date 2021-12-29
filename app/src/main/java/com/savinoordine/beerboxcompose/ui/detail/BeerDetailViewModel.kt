package com.savinoordine.beerboxcompose.ui.detail

import androidx.lifecycle.*
import com.savinoordine.beerboxcompose.domain.Beer
import com.savinoordine.beerboxcompose.repository.BeerRepository
import com.savinoordine.beerboxcompose.util.network.fold
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerDetailViewModel
@Inject
constructor(
    private val beerRepository: BeerRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state: MutableLiveData<Beer> = MutableLiveData()
    val state: LiveData<Beer> = _state

    init {
        val beerId = savedStateHandle.get<Int>("beerId") ?: -1
        fetchBeerDetail(beerId)
    }

    private fun fetchBeerDetail(beerId: Int) {
        viewModelScope.launch {
            beerRepository.getBeerDetail(beerId)
                .fold(
                    success = { _state.value = it },
                    error = {}
                )
        }
    }
}