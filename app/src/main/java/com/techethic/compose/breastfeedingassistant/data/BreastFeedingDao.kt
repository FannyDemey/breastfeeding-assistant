package com.techethic.compose.breastfeedingassistant.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BreastFeedingDao {
    @Query("SELECT * FROM breastfeeding WHERE date == :date ORDER BY start DESC")
    fun getFeedingsForDate(date : String): Flow<List<BreastFeeding>>

    @Insert
    suspend fun insert(vararg breastFeeding: BreastFeeding)

    @Update
    suspend fun update(vararg breastFeeding: BreastFeeding)

}