package br.com.compasso.markup.services.extensions

import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat

fun ImageView.setTint(@ColorRes colorId: Int) {
    ImageViewCompat.setImageTintList(
        this,
        ContextCompat.getColorStateList(this.context, colorId)
    )
}