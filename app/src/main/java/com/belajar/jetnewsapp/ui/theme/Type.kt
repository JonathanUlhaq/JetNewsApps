package com.belajar.jetnewsapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.belajar.jetnewsapp.R

val newYork = FontFamily(
    listOf(
        Font(
            R.font.new_york_small_semi_bold,
            weight = FontWeight.SemiBold
        ),
        Font(
            R.font.new_york_small_bold,
            weight = FontWeight.Bold
        )
    )
)

val nunito = FontFamily(
    listOf(
        Font(
            R.font.nunito_light,
            weight = FontWeight.Light
        ),
        Font(
            R.font.nunito_reguler,
            weight = FontWeight.Normal
        ),
        Font(
            R.font.nunito_semi_bold,
            weight = FontWeight.SemiBold
        ),
        Font(
            R.font.nunito_bold,
            weight = FontWeight.Bold
        ),
        Font(
            R.font.nunito_extra_bold,
            weight = FontWeight.ExtraBold
        ),
        Font(
            R.font.nunito_black,
            weight = FontWeight.Black
        ),

        )
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp
    ),
    h3 = TextStyle(
        fontFamily = newYork,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h4 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.Black,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
    body1 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    caption = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)