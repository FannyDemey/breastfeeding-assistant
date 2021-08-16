package com.techethic.compose.breastfeedingassistant.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BreastFeeding::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)

abstract class AppDatabase : RoomDatabase() {
    abstract fun breastFeedingDao(): BreastFeedingDao
}