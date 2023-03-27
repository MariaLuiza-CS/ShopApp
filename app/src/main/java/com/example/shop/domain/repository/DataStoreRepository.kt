package com.example.shop.domain.repository

import android.content.Context
import com.example.shop.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun setWelcomeCompletedFlow(isCompleted: Boolean, context: Context)

    suspend fun getWelcomeCompletedFlow(): Resource<Flow<Boolean>>
}
