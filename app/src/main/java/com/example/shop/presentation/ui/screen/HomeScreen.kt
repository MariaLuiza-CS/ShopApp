package com.example.shop

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shop.presentation.ui.theme.IndianRed
import com.example.shop.presentation.ui.theme.LightVanilla

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    var progress by remember { mutableStateOf(0.0f) }

    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightVanilla)
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            backgroundColor = IndianRed,
            border = null,
            elevation = 1.dp,
        ) {
            Column() {
//                LaunchedEffect(Unit) {
//                    progress = 0.6f
//                }
                Text(
                    text = "This Month",
                    modifier = Modifier.padding(start = 16.dp)
                )
                CustomCircularProgressBar()
//                CircularProgressIndicator(
//                    progress = animatedProgress,
//                    color = LightVanilla,
//                    strokeWidth = 6.dp,
//                    modifier = Modifier.then(Modifier.size(60.dp))
//                )
            }
        }
    }

}

@Composable
fun CustomCircularProgressBar() {
    Box(
        modifier = Modifier.size(100.dp),
        contentAlignment = Alignment.Center
    ) {

        val animatedProgress = animateFloatAsState(
            targetValue = 60f,
            animationSpec = tween(
                durationMillis = 1000
            )
        )

        Canvas(modifier = Modifier.size(300.dp)) {

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.LightGray, Color.White),
                    center = Offset(x = this.size.width / 2, y = this.size.height / 2),
                    radius = this.size.height / 2
                ),
                radius = 236.0f / 2,
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            drawCircle(
                color = IndianRed,
                radius = (115.dp / 2 - 24.dp).toPx(),
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            val sweepAngle = (animatedProgress).value * 360 / 100

            drawArc(
                color = Color(0xFF35898f),
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 10.dp.toPx(), cap = StrokeCap.Round),
                size = Size(
                    width = (100.dp - 24.dp).toPx(),
                    height = (100.dp - 24.dp).toPx()
                ),
                topLeft = Offset(
                    x = (24.dp / 2).toPx(),
                    y = (24.dp / 2).toPx()
                )
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = (animatedProgress.value).toInt().toString(),
                style = MaterialTheme.typography.h2
            )
        }
    }
}