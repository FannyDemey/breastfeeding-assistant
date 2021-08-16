package com.techethic.compose.breastfeedingassistant.data

import androidx.room.TypeConverter
import java.time.Instant

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long): Instant {
        return Instant.ofEpochMilli(value)
    }

    @TypeConverter
    fun dateToTimestamp(instant: Instant): Long {
        return instant.toEpochMilli()
    }
}