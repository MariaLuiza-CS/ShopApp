package com.example.shop.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.shop.domain.repository.DataStoreRepository
import com.example.shop.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

const val SHOP_APP_DATASTORE = "shop_app_datastore"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = SHOP_APP_DATASTORE)

class DataStoreRepositoryImpl @Inject constructor(private val context: Context) :
    DataStoreRepository {

    companion object {
        val WELCOME_SCREEN = booleanPreferencesKey("WELCOME_SCREEN")
    }

    override suspend fun setWelcomeCompletedFlow(isCompleted: Boolean, context: Context) {
        context.dataStore.edit {
            it[WELCOME_SCREEN] = isCompleted
        }
    }

    override suspend fun getWelcomeCompletedFlow(): Resource<Flow<Boolean>> {
        return try {
            Resource.Success(
                data = context.dataStore.data.map {
                    it[WELCOME_SCREEN] ?: false
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
