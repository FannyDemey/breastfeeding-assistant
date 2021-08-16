package com.techethic.compose.breastfeedingassistant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techethic.compose.breastfeedingassistant.data.BreastFeeding
import com.techethic.compose.breastfeedingassistant.data.BreastfeedingSide
import com.techethic.compose.breastfeedingassistant.data.BreastFeedingDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

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
            val nowDate = formatDate(Date.from(Instant.now()))

            //LEFT AND RIGHT COUNT
            breastFeedingDao.getFeedingsForDate(nowDate).collect { feedingList ->
                if(feedingList.isNotEmpty()){
                    val leftCount = feedingList.count {
                        it.breastfeedingSide == BreastfeedingSide.LEFT
                    }
                    val rightCount = feedingList.count {
                        it.breastfeedingSide == BreastfeedingSide.RIGHT
                    }
                    _leftCount.emit(leftCount)
                    _rightCount.emit(rightCount)

                    feedingList.first().let { lastFeeding ->
                        val duration = Duration.between(
                            lastFeeding.end,
                            Instant.now()
                        )
                        _timeSinceLastBreastFeeding.emit(duration)
                        _lastBreastfeedingSide.emit(lastFeeding.breastfeedingSide)
                    }
                } else {
                    //TODO retrieve previous feeding side and time ?
                }


            }

        }
    }

    fun breastFeedingStarted(breastfeedingSide: BreastfeedingSide) {
        viewModelScope.launch {
            breastFeedingDao.insert(
                BreastFeeding(
                    breastfeedingSide = breastfeedingSide,
                    date = formatDate(Date.from(Instant.now())),
                    start = Instant.now(),
                    end = Instant.now())
            )
        }

    }


    private val DATE_IN_DB_PATTERN = "yyyyMMdd"

    private fun formatDate(date : Date) : String{
        val simpleDateFormater = SimpleDateFormat(DATE_IN_DB_PATTERN, Locale.ENGLISH)
        return simpleDateFormater.format(date)
    }
}