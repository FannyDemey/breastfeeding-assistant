package com.techethic.compose.breastfeedingassistant.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

@Entity
class BreastFeeding(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val breastfeedingSide : BreastfeedingSide,
    val date: String,
    val start : Instant,
    val end : Instant
)