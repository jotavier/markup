package br.com.compasso.markup.services.extensions

import android.content.Context
import android.view.inputmethod.InputMethodManager
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

fun Fragment.hideKeyboard() {
    this.activity?.also {
        val imm =
            it.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}