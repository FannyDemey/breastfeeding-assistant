package com.techethic.compose.breastfeedingassistant.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Typography
import com.techethic.compose.breastfeedingassistant.R

// Set of Material typography styles to start with

private val ValeraFont = FontFamily(Font(R.font.valeraround))
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = ValeraFont,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    body2 = TextStyle(
        fontFamily = ValeraFont,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),
    title1 = TextStyle(
        fontFamily = ValeraFont,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    title2 = TextStyle(
        fontFamily = ValeraFont,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    title3 = TextStyle(
        fontFamily = ValeraFont,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),
    button = TextStyle(
        fontFamily = ValeraFont,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
)