package com.example.shop.data.state

data class WelcomeFlowState(
    val isCompleted: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)
