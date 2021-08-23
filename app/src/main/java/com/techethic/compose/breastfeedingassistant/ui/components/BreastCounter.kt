package com.techethic.compose.breastfeedingassistant.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
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
    modifier: Modifier,
    onBreastFeedingClick : () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly, modifier = modifier){
        BrestFeedingSideHeader(breastfeedingSide, lastBreastfeedingSide)
        Button(
            onClick = onBreastFeedingClick,
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

@Preview
@Composable
fun BreastCounterRightLastPreview() {
    BreastCounter(2, BreastfeedingSide.RIGHT, BreastfeedingSide.RIGHT, modifier = Modifier.padding()){
    }
}

@Preview
@Composable
fun BreastCounterRightPreview() {
    BreastCounter(2, BreastfeedingSide.RIGHT, BreastfeedingSide.LEFT, modifier = Modifier.padding()){
    }
}