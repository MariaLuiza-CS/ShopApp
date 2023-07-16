package com.example.shop

import android.graphics.Paint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shop.presentation.ui.theme.EerieBlack
import com.example.shop.presentation.ui.theme.IndianRed

@Composable
fun BarGraph(
    graphBarDate: List<Float>,
    xAxisScaleData: List<String>,
    barData: List<Int>,
    height: Dp,
    roundType: BarType,
    barWidth: Dp,
    barArrangement: Arrangement.Horizontal
) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp.dp
    val xAxisScaleHeight = 40.dp
    val yAxisScalePadding by remember {
        mutableStateOf(100f)
    }
    val yAxisTextWidth by remember {
        mutableStateOf(100.dp)
    }
    val barShape =
        when (roundType) {
            BarType.CIRCULAR_TYPE -> CircleShape
            BarType.TOP_CURVED -> RoundedCornerShape(topStart = 3.dp, topEnd = 3.dp)
        }
    val density = LocalDensity.current
    val textPaint = remember(density) {
        Paint().apply {
            color = Color.Black.hashCode()
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }
    val yCoordinates = mutableListOf<Float>()
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)

    InitBoard(
        xAxisScaleHeight = xAxisScaleHeight,
        height = height,
        yAxisScalePadding = yAxisScalePadding,
        barData = barData,
        yCoordinates = yCoordinates,
        pathEffect = pathEffect,
        textPaint = textPaint,
        graphBarDate = graphBarDate,
        barShape = barShape,
        barWidth = barWidth,
        xAxisScaleData = xAxisScaleData,
        width = width,
        yAxisTextWidth = yAxisTextWidth,
        barArrangement = barArrangement
    )
}

@Composable
fun InitBoard(
    xAxisScaleHeight: Dp,
    height: Dp,
    yAxisScalePadding: Float,
    barData: List<Int>,
    yCoordinates: MutableList<Float>,
    pathEffect: PathEffect,
    textPaint: Paint,
    barWidth: Dp,
    graphBarDate: List<Float>,
    barShape: RoundedCornerShape,
    xAxisScaleData: List<String>,
    width: Dp,
    yAxisTextWidth: Dp,
    barArrangement: Arrangement.Horizontal
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .padding(top = xAxisScaleHeight, end = 3.dp)
                .height(height)
                .fillMaxWidth(),
            horizontalAlignment = CenterHorizontally
        ) {
            CreateCanvasBoard(
                yAxisScalePadding,
                barData,
                yCoordinates,
                pathEffect,
                textPaint
            )
        }

        GraphBar(
            graphBarDate = graphBarDate,
            barShape = barShape,
            barWidth = barWidth,
            height = height,
            xAxisScaleHeight = xAxisScaleHeight,
            xAxisScaleData = xAxisScaleData,
            width = width,
            yAxisTextWidth = yAxisTextWidth,
            barArrangement = barArrangement
        )
    }
}

@Composable
fun GraphBar(
    graphBarDate: List<Float>,
    barShape: RoundedCornerShape,
    barWidth: Dp,
    height: Dp,
    xAxisScaleHeight: Dp,
    xAxisScaleData: List<String>,
    width: Dp,
    yAxisTextWidth: Dp,
    barArrangement: Arrangement.Horizontal
){
    Box(
        modifier = Modifier
            .padding(start = 50.dp)
            .width(width - yAxisTextWidth)
            .height(height + xAxisScaleHeight),
        contentAlignment = BottomCenter
    ) {
        Row(
            modifier = Modifier
                .width(width - yAxisTextWidth),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = barArrangement
        ) {
            CreateBarGraph(
                graphBarDate = graphBarDate,
                barShape = barShape,
                barWidth = barWidth,
                height = height,
                xAxisScaleHeight = xAxisScaleHeight,
                xAxisScaleData = xAxisScaleData
            )
        }
    }
}

@Composable
fun CreateBarGraph(
    graphBarDate: List<Float>,
    barShape: RoundedCornerShape,
    barWidth: Dp,
    height: Dp,
    xAxisScaleHeight: Dp,
    xAxisScaleData: List<String>
) {
    graphBarDate.forEachIndexed { index, value ->
        var animationTriggered by remember {
            mutableStateOf(false)
        }

        val graphBarHeight by animateFloatAsState(
            targetValue = if (animationTriggered) value else 0f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 0
            )
        )

        LaunchedEffect(key1 = true) {
            animationTriggered = true
        }

        BarItem(
            barShape = barShape,
            barWidth = barWidth,
            height = height,
            graphBarHeight = graphBarHeight,
            value = value,
            xAxisScaleHeight = xAxisScaleHeight,
            xAxisScaleData = xAxisScaleData,
            index = index
        )
    }
}

@Composable
fun BarItem(
    barShape: RoundedCornerShape,
    barWidth: Dp,
    height: Dp,
    graphBarHeight: Float,
    value: Float,
    xAxisScaleHeight: Dp,
    xAxisScaleData: List<String>,
    index: Int
) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Bottom,
        horizontalAlignment = CenterHorizontally
    ) {
        BarBoard(
            barShape = barShape,
            barWidth = barWidth,
            height = height,
            graphBarHeight = graphBarHeight,
            value = value
        )

        TextBoard(
            xAxisScaleHeight = xAxisScaleHeight,
            xAxisScaleData = xAxisScaleData,
            index = index
        )
    }
}

@Composable
fun CreateCanvasBoard(
    yAxisScalePadding: Float,
    barData: List<Int>,
    yCoordinates: MutableList<Float>,
    pathEffect: PathEffect,
    textPaint: Paint
) {
    Canvas(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxSize()
    ) {
        (0..3).forEach { i ->
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    barData[i].toString(),
                    30f,
                    size.height - yAxisScalePadding - i * size.height / 3f,
                    textPaint
                )
            }
            yCoordinates.add(size.height - yAxisScalePadding - i * size.height / 3f)
        }
        (1..3).forEach {
            drawLine(
                start = Offset(x = yAxisScalePadding + 30f, y = yCoordinates[it]),
                end = Offset(x = size.width, y = yCoordinates[it]),
                color = Color.Gray,
                strokeWidth = 5f,
                pathEffect = pathEffect
            )
        }
    }
}

@Composable
fun TextBoard(
    xAxisScaleHeight: Dp,
    xAxisScaleData: List<String>,
    index: Int
) {
    Column(
        modifier = Modifier
            .height(xAxisScaleHeight),
        verticalArrangement = Top,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 3.dp),
            text = xAxisScaleData[index],
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = EerieBlack
        )
    }
}

@Composable
fun BarBoard(
    barShape: RoundedCornerShape,
    barWidth: Dp,
    height: Dp,
    graphBarHeight: Float,
    value: Float
) {
    Box(
        modifier = Modifier
            .padding(bottom = 5.dp)
            .clip(barShape)
            .width(barWidth)
            .height(height - 10.dp)
            .background(Color.Transparent),
        contentAlignment = BottomCenter
    ) {
        Box(
            modifier = Modifier
                .clip(barShape)
                .fillMaxWidth()
                .fillMaxHeight(graphBarHeight)
                .background(IndianRed.copy(alpha = value))
        )
    }
}
