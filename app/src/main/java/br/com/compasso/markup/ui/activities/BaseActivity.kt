package br.com.compasso.markup.ui.activities

import androidx.appcompat.app.AppCompatActivity
import br.com.compasso.markup.ui.fragments.dialogs.LoadingFragment

abstract class BaseActivity : AppCompatActivity() {
    private var loader: LoadingFragment? = null

    fun startLoading(title: String = "Enviando...") {
        loader = LoadingFragment(title)
        loader?.show(supportFragmentManager, LoadingFragment.TAG)
    }

    fun stopLoading() {
        loader?.dismiss()
    }

}