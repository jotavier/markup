package br.com.compasso.markup.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.com.compasso.markup.R
import br.com.compasso.markup.services.extensions.setTint

@BindingAdapter("app:favorite")
fun favorite(imageView: ImageView, favorite: Boolean) {
    if (!favorite) {
        imageView.setTint(R.color.white)
        return
    }
    imageView.setTint(R.color.red)
}