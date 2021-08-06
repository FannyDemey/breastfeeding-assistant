package com.techethic.compose.breastfeedingassistant.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Counter::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun counterDao(): CounterDao
}