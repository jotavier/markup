package br.com.compasso.markup.services.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.hideKeyboard() {
    if (!this.hasFocus()) return
    val systemService =
        this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    systemService.hideSoftInputFromWindow(this.windowToken, 0)
    this.clearFocus()
}