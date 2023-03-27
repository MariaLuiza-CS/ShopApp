package com.example.shop

data class WelcomeState(
    val isCompleted: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)
