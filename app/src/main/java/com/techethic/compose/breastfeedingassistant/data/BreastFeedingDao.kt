package com.techethic.compose.breastfeedingassistant.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BreastFeedingDao {
    @Query("SELECT * FROM breastfeeding")
    fun getAll(): Flow<List<BreastFeeding>?>

    @Insert
    suspend fun insert(vararg breastFeeding: BreastFeeding)

    @Update
    suspend fun update(vararg breastFeeding: BreastFeeding)

}