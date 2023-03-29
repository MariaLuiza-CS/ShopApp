package com.example.shop.presentation.ui.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shop.data.state.WelcomeFlowState
import com.example.shop.domain.repository.DataStoreRepository
import com.example.shop.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    var state by mutableStateOf(WelcomeFlowState())
        private set

    fun getWelcomeCompletedFlow() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            when (val result = dataStoreRepository.getWelcomeCompletedFlow()) {
                is Resource.Success -> {
                    result.data?.collect {
                        state = state.copy(
                            isLoading = false,
                            isCompleted = it,
                            error = null
                        )
                    }
                }
                is Resource.Error -> {
                    state.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }

    fun setWelcomeCompletedFlow(context: Context) {
        viewModelScope.launch {
            dataStoreRepository.setWelcomeCompletedFlow(
                isCompleted = true,
                context = context
            )
        }
    }
}
