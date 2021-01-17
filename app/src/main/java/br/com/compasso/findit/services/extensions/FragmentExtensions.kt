package br.com.compasso.findit.services.extensions

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.toast(message: String) {
    view?.let {
        Snackbar.make(
            it,
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }
}