package br.com.compasso.markup.di.modules

import br.com.compasso.markup.ui.viewmodels.AppViewModel
import br.com.compasso.markup.ui.viewmodels.EventViewModel
import br.com.compasso.markup.ui.viewmodels.EventsViewModel
import br.com.compasso.markup.ui.viewmodels.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AppViewModel() }
    viewModel { EventsViewModel(get(), get()) }
    viewModel { UserViewModel(get(), get()) }
    single { EventViewModel(get()) }
}