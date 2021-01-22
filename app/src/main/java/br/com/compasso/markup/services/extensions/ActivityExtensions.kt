package br.com.compasso.markup.services.extensions

import android.app.Activity
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Activity.toast(view: View, message: String) {
    Snackbar.make(
        view,
        message,
        Snackbar.LENGTH_LONG
    ).show()
}