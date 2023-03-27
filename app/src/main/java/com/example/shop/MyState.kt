package com.example.shop

import kotlinx.coroutines.flow.Flow

data class WelcomeState(
    val welcomeCount: Int? = null,
    val error: String? = null
)
