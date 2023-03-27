package com.example.shop

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shop.domain.repository.DataStoreRepository
import com.example.shop.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    var state by mutableStateOf(WelcomeState())
        private set

    suspend fun loadWelcomeCount() {
        viewModelScope.launch {
            state = state.copy(
                error = null
            )
        }
        when (val result = dataStoreRepository.getWelcomeCount()) {
            is Resource.Success -> {
                result.data?.collect{
                    state = state.copy(
                        welcomeCount = it,
                        error = null
                    )
                }
            }
            is Resource.Error -> {
                state.copy(
                    error = result.message
                )
            }
        }
    }
}