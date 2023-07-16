package com.example.shop.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shop.BarGraph
import com.example.shop.BarType
import com.example.shop.domain.model.CardInfo
import com.example.shop.presentation.ui.theme.LightVanilla

@Composable
fun AnalyticsScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightVanilla),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val dataList = mutableListOf(30, 60, 90, 50, 70)
        val floatValue = mutableListOf<Float>()
        val datesList = mutableListOf("JAN", "FEV", "MAR", "APR", "MAY")
        dataList.forEachIndexed { index, value ->
            floatValue.add(
                index = index,
                element = value.toFloat() / dataList.maxOrNull()!!.toFloat()
            )
        }
        BarGraph(
            graphBarDate = floatValue,
            xAxisScaleData = datesList,
            barData = dataList,
            height = 300.dp,
            roundType = BarType.CIRCULAR_TYPE,
            barWidth = 30.dp,
            barArrangement = Arrangement.SpaceEvenly
        )
        MonthCards(navController = navController)
    }
}

@Composable
fun MonthCards(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightVanilla)
            .padding(24.dp)
    ) {
        val cardList = listOf(
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54")
        )
        Text(
            text = "Historic",
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(cardList) { card ->
                AllCardsInfo(cardInfo = card, navController)
            }
        }
    }
}