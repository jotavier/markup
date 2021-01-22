package br.com.compasso.markup.services.providers

import androidx.annotation.DrawableRes

data class StateProvider(
    val title: CharSequence,
    val message: CharSequence,
    @DrawableRes val icon: Int
)
