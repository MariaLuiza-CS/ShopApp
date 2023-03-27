package com.example.shop

import androidx.annotation.DrawableRes

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String
) {
    object Fist : OnBoardingPage(
        image = R.drawable.ic_shopping,
        title = "Add the items to your shopping cart"
    )

    object Second : OnBoardingPage(
        image = R.drawable.ic_payments,
        title = "Organize your expenses in list with automatic calculation"
    )

    object Thirty : OnBoardingPage(
        image = R.drawable.ic_spending,
        title = "Detailed overview of your spending"
    )
}
