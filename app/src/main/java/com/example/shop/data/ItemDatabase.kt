package com.example.shop.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shop.data.dao.ItemDao
import com.example.shop.domain.model.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: ItemDatabase? = null

        fun getDatabase(context: Context): ItemDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    ItemDatabase::class.java,
                    "item_database"
                )
                    .build()
                    .also { Instance = it }
            }
        }
    }
}