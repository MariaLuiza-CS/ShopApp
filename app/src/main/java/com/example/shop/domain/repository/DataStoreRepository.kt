package com.example.shop.domain.repository

import android.content.Context
import com.example.shop.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun setWelcomeCount(context: Context)

    suspend fun getWelcomeCount(): Resource<Flow<Int>>
}
