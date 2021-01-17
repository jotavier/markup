package br.com.compasso.findit.ui.binding

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import br.com.compasso.findit.R
import com.bumptech.glide.Glide

@BindingAdapter("app:bindSrc")
fun bindSrc(imageView: ImageView, @DrawableRes drawableId: Int) {
    imageView.setImageResource(drawableId)
}

@BindingAdapter("app:download")
fun download(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).error(R.drawable.ic_no_image).into(imageView)
}