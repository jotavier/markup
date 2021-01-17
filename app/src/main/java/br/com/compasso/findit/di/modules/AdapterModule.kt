package br.com.compasso.findit.di.modules

import br.com.compasso.findit.ui.adapters.EventAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { EventAdapter(arrayListOf()) }
}