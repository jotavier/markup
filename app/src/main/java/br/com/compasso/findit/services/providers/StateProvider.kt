package br.com.compasso.findit.services.providers

import androidx.annotation.DrawableRes

data class StateProvider(
    val title: CharSequence,
    val message: CharSequence,
    @DrawableRes val icon: Int
)
