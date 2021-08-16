package com.techethic.compose.breastfeedingassistant.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity
class BreastFeeding(
    @PrimaryKey val id : Int,
    val breastfeedingSide : BreastfeedingSide,
    val start : Instant,
    val end : Instant
)