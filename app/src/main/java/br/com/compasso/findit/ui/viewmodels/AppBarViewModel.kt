package br.com.compasso.findit.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppBarViewModel : ViewModel() {

    val visibility: LiveData<Boolean> get() = _appBar

    private var _appBar = MutableLiveData<Boolean>().also {
        it.value = hasAppBar
    }

    private var hasAppBar: Boolean = true
        set(value) {
            field = value
            _appBar.value = value
        }

    fun show() {
        hasAppBar = true
    }

    fun hide() {
        hasAppBar = false
    }
}