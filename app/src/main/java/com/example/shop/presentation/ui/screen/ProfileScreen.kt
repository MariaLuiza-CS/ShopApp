package com.example.shop.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shop.BarGraph
import com.example.shop.BarType
import com.example.shop.presentation.ui.theme.IndianRed

@Composable
fun ProfileScreen(
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 50.dp)
            .fillMaxSize(),
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
    }
}