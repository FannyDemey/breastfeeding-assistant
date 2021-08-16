package com.techethic.compose.breastfeedingassistant

import java.time.Duration

object Utils {
    fun humanReadableFormat(duration: Duration): String {
        val seconds = duration.seconds
        val absSeconds = Math.abs(seconds)
        val hours = absSeconds / 3600
        val minutes = absSeconds % 3600 / 60
        return " $hours h $minutes m"
    }
}