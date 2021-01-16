package br.com.compasso.findit.di.modules

import br.com.compasso.findit.ui.viewmodels.AppBarViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AppBarViewModel() }
}