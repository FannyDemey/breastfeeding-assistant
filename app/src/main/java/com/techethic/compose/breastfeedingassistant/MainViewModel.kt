package com.techethic.compose.breastfeedingassistant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techethic.compose.breastfeedingassistant.data.BreastfeedingSide
import com.techethic.compose.breastfeedingassistant.data.BreastFeedingDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit

class MainViewModel(private val breastFeedingDao: BreastFeedingDao) : ViewModel() {

    private val _leftCount : MutableStateFlow<Int> = MutableStateFlow(0)
    private val _rightCount : MutableStateFlow<Int> = MutableStateFlow(0)
    private val _lastBreastfeedingSide : MutableStateFlow<BreastfeedingSide?> = MutableStateFlow(null)
    private val _timeSinceLastBreastFeeding : MutableStateFlow<Duration> = MutableStateFlow(Duration.ZERO)

    val leftCount : StateFlow<Int> = _leftCount
    val rightCount : StateFlow<Int> = _rightCount
    val lastBreastfeedingSide : StateFlow<BreastfeedingSide?> = _lastBreastfeedingSide
    val timeSinceLastBreastFeeding : StateFlow<Duration> = _timeSinceLastBreastFeeding


    fun retrieveBreastFeedingInfo(){
        viewModelScope.launch {

            _leftCount.emit(2)
            _rightCount.emit(3)
            _lastBreastfeedingSide.emit(BreastfeedingSide.RIGHT)

            val duration = Duration.between(
                Instant.now()
                    .minus(3, ChronoUnit.HOURS)
                    .plus(22, ChronoUnit.MINUTES).plus(2,ChronoUnit.SECONDS),
                Instant.now()
            )

            _timeSinceLastBreastFeeding.emit(duration)
        }
    }

    fun breastFeedingStarted(breastfeedingSide: BreastfeedingSide) {
    }
}