package com.techethic.compose.breastfeedingassistant.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.techethic.compose.breastfeedingassistant.MainViewModel
import com.techethic.compose.breastfeedingassistant.R
import com.techethic.compose.breastfeedingassistant.Utils.humanReadableFormat
import com.techethic.compose.breastfeedingassistant.data.BreastfeedingSide
import com.techethic.compose.breastfeedingassistant.theme.gray
import com.techethic.compose.breastfeedingassistant.ui.components.BreastCounter


@Composable
fun BreastFeedTracker(mainViewModel: MainViewModel) {
    val leftCount by mainViewModel.leftCount.collectAsState()
    val rightCount by mainViewModel.rightCount.collectAsState()
    val lastBreastSide by mainViewModel.lastBreastfeedingSide.collectAsState()
    val timeSinceLastBreastFeeding by mainViewModel.timeSinceLastBreastFeeding.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_smiling_baby),
            modifier = Modifier.size(16.dp, 16.dp),
            tint = gray,
            contentDescription = "Feeding tracker app")
        Text(text = "Today",
            style = MaterialTheme.typography.title2,
            color = MaterialTheme.colors.secondaryVariant)
        //Breast Counters
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val guideline = createGuidelineFromAbsoluteLeft(0.5f)
            val (left, right) = createRefs()
            BreastCounter(leftCount,
                BreastfeedingSide.LEFT,
                lastBreastSide,
                modifier = Modifier.constrainAs(left){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(guideline)
                }) {
                mainViewModel.breastFeedingStarted(BreastfeedingSide.LEFT)
            }
            BreastCounter(rightCount,
                BreastfeedingSide.RIGHT,
                lastBreastSide,
                modifier = Modifier.constrainAs(right){
                    top.linkTo(parent.top)
                    start.linkTo(guideline)
                    end.linkTo(parent.end)
            }) {
                mainViewModel.breastFeedingStarted(BreastfeedingSide.RIGHT)
            }
        }
        Row(horizontalArrangement = Arrangement.Center) {

        }
        Text(text = "Feeding counts",
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.secondary)


        Spacer(modifier = Modifier.height(10.dp))

        //Last feeding
        Icon(painter = painterResource(id = R.drawable.ic_baseline_hourglass),
            modifier = Modifier.size(20.dp, 20.dp),
            tint = MaterialTheme.colors.primary,
            contentDescription = "elapsed time since last feeding")

        Text(text = humanReadableFormat(timeSinceLastBreastFeeding),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body1)

        Text(text = "since last feeding",
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.primary)

        Spacer(modifier = Modifier.height(16.dp))

    }

}


