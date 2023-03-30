package com.example.shop.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.shop.R

val Montserrat = FontFamily(
    Font(R.font.montserrat_black),
    Font(R.font.montserrat_blackitalic),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_bolditalic),
    Font(R.font.montserrat_extrabold, FontWeight.ExtraBold),
    Font(R.font.montserrat_extrabolditalic),
    Font(R.font.montserrat_extralight, FontWeight.ExtraLight),
    Font(R.font.montserrat_extralightitalic),
    Font(R.font.montserrat_italic),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_lightitalic),
    Font(R.font.montserrat_medium),
    Font(R.font.montserrat_mediumitalic),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_semibolditalic),
    Font(R.font.montserrat_thin, FontWeight.Thin),
    Font(R.font.montserrat_thinitalic)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    )
)
