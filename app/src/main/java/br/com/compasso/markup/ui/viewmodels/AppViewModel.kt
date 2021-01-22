package br.com.compasso.markup.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {

    val appBarVisibility = MutableLiveData(true)
    val bottomNavigationVisibility = MutableLiveData(true)

    fun showBottomNavigation(show: Boolean = true) {
        bottomNavigationVisibility.value = show
    }

    fun showAppBar(show: Boolean = true) {
        appBarVisibility.value = show
    }
}