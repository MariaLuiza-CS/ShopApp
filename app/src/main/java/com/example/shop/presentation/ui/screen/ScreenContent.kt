package com.example.shop.presentation.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.domain.model.CardInfo
import com.example.shop.presentation.ui.theme.*

@Composable
fun ScreenContent() {

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
            .padding(24.dp)
    ) {

        var cardList = listOf<CardInfo>(
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54"),
            CardInfo("jan", "126,54")
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            backgroundColor = IndianRed,
            border = null,
            elevation = 1.dp
        ) {
            Column() {
                Text(
                    text = "This month",
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    style = MaterialTheme.typography.h1,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(40.dp))
                Row(
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomCircularProgressBar(140.dp)
                    Column() {
                        Text(
                            text = "Total",
                            style = MaterialTheme.typography.h1,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "\$184,30",
                            style = MaterialTheme.typography.h1,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(50.dp))
                        Row(
                            modifier = Modifier.padding(start = 50.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            val onClick = { /* Do something */ }
                            FloatingActionButton(
                                onClick = onClick,
                                backgroundColor = Flax,
                                contentColor = IndianRed
                            ) {
                                Icon(
                                    Icons.Filled.Add,
                                    "",
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Historic",
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(40.dp))
        LazyColumn {
            items(cardList) { crad ->
                AllCardsInfo(cardInfo = crad)
            }
        }
    }
}

@Composable
fun AllCardsInfo(cardInfo: CardInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(15.dp),
        backgroundColor = AtomicTangerine
    ) {
        Row(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Flax,
                border = null,
                elevation = 1.dp
            ) {
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = cardInfo.month.uppercase(),
                        color = EerieBlack,
                        style = MaterialTheme.typography.h4
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "$" + cardInfo.value,
                    color = EerieBlack,
                    style = MaterialTheme.typography.h4
                )
                Icon(
                    modifier = Modifier.size(34.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                    contentDescription = "test icon"
                )
            }
        }
    }
}

@Composable
fun CustomCircularProgressBar(size: Dp) {
    Box(
        modifier = Modifier.size(size),
        contentAlignment = Alignment.Center
    ) {

        val animatedProgress = animateFloatAsState(
            targetValue = 75f,
            animationSpec = tween(
                durationMillis = 1000
            )
        )

        Canvas(modifier = Modifier.size(size)) {

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(FlaxShadow, FlaxShadow),
                    center = Offset(x = this.size.width / 2, y = this.size.height / 2),
                    radius = this.size.height / 2
                ),
                radius = this.size.height / 2,
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            drawCircle(
                color = IndianRed,
                radius = (size / 2 - 15.dp).toPx(),
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            val sweepAngle = (animatedProgress).value * 350 / 100

            drawArc(
                color = Flax,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 15.dp.toPx(), cap = StrokeCap.Round),
                size = Size(
                    width = (size - 15.dp).toPx(),
                    height = (size - 15.dp).toPx()
                ),
                topLeft = Offset(
                    x = (15.dp / 2).toPx(),
                    y = (15.dp / 2).toPx()
                )
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = (animatedProgress.value).toInt().toString() + "%",
                style = MaterialTheme.typography.h1,
                color = Color.White
            )
        }
    }
}