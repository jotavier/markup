package br.com.compasso.markup.ui.binding

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import br.com.compasso.markup.R
import com.bumptech.glide.Glide

@BindingAdapter("app:bindSrc")
fun bindSrc(imageView: ImageView, @DrawableRes drawableId: Int) {
    imageView.setImageResource(drawableId)
}

@BindingAdapter("app:download")
fun download(imageView: ImageView, url: String) {
    try {
        Glide.with(imageView.context)
            .load(url)
            .placeholder(R.drawable.loading)
            .error(R.drawable.ic_error_404)
            .into(imageView)
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}