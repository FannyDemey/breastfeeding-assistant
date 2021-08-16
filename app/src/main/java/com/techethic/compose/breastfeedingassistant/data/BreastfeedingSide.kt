package com.techethic.compose.breastfeedingassistant.data

import androidx.annotation.StringRes
import com.techethic.compose.breastfeedingassistant.R

enum class BreastfeedingSide(@StringRes val stringResource : Int) {
    LEFT( R.string.left), RIGHT(R.string.right)
}