package com.example.shop

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.shop.domain.repository.DataStoreRepository
import com.example.shop.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val SHOP_APP_DATASTORE = "shop_app_datastore"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = SHOP_APP_DATASTORE)

class DataStoreRepositoryImpl(private val context: Context) : DataStoreRepository {

    companion object {
        val WELCOME_SCREEN = intPreferencesKey("WELCOME_SCREEN")
    }

    override suspend fun setWelcomeCount(context: Context) {
        context.dataStore.edit {
            val currentWelcomeCount = it[WELCOME_SCREEN] ?: 0
            it[WELCOME_SCREEN] = currentWelcomeCount + 1
        }
    }

    override suspend fun getWelcomeCount(): Resource<Flow<Int>> {
        return try {
            Resource.Success(
                data = context.dataStore.data.map {
                    it[WELCOME_SCREEN] ?: 0
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}