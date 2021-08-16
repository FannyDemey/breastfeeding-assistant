package com.techethic.compose.breastfeedingassistant.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.techethic.compose.breastfeedingassistant.R
import com.techethic.compose.breastfeedingassistant.data.BreastfeedingSide

@Composable
fun BrestFeedingSideHeader(
    breastfeedingSide: BreastfeedingSide,
    lastBreastfeedingSide: BreastfeedingSide?,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        ConstraintLayout {
            val (text, lastSideIcon) = createRefs()
            Text(
                text = stringResource(id = breastfeedingSide.stringResource),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.constrainAs(text) {
                    top.linkTo(parent.top)
                    absoluteLeft.linkTo(parent.absoluteLeft)
                    absoluteRight.linkTo(parent.absoluteRight)
                })
            lastBreastfeedingSide?.let {
                if (breastfeedingSide == it) {
                    Icon(painter = painterResource(id = R.drawable.ic_last_breastfeeding),
                        tint = MaterialTheme.colors.secondary,
                        contentDescription = stringResource(R.string.Last_breastfeeding_side_a11y),
                        modifier = Modifier
                            .scale(0.5f)
                            .constrainAs(lastSideIcon) {
                                top.linkTo(text.top)
                                bottom.linkTo(text.bottom)
                                absoluteLeft.linkTo(text.absoluteRight)
                            })
                }
            }
        }
    }
}