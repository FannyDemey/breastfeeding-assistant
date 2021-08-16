package com.techethic.compose.breastfeedingassistant.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.techethic.compose.breastfeedingassistant.MainViewModel
import com.techethic.compose.breastfeedingassistant.data.BreastfeedingSide

@Composable
fun BreastCounter(
    feedingCount: Int,
    breastfeedingSide: BreastfeedingSide,
    lastBreastfeedingSide: BreastfeedingSide?,
    mainViewModel: MainViewModel
    ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
    BrestFeedingSideHeader(breastfeedingSide, lastBreastfeedingSide)
        Button(
            onClick = {
                mainViewModel.breastFeedingStarted(breastfeedingSide)
            },
            modifier = Modifier
                .padding(start = 8.dp, top = 0.dp, end = 8.dp, bottom = 8.dp)
                .size(45.dp, 45.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(
                text = "$feedingCount",
                textAlign = TextAlign.Right,
                style = MaterialTheme.typography.button
            )
        }

    }
}