package com.example.shop.di

import android.content.Context
import com.example.shop.data.ItemDatabase
import com.example.shop.data.dao.ItemDao
import com.example.shop.data.repository.ItemRepositoryImpl
import com.example.shop.domain.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDataStoreRepositoryContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }

    @Provides
    fun provideItemRepositoryImplementation(
        @ApplicationContext appContext: Context
    ): ItemDao = ItemDatabase.getDatabase(appContext).itemDao()

    @Provides
    fun provideItemRepository(
        itemDao: ItemDao
    ): ItemRepository = ItemRepositoryImpl(itemDao)
}
