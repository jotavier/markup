package br.com.compasso.markup.di.modules

import br.com.compasso.markup.database.daos.EventDAO
import br.com.compasso.markup.ui.adapters.EventAdapter
import br.com.compasso.markup.ui.adapters.FavoriteEventAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { EventAdapter(arrayListOf()) }
    factory { FavoriteEventAdapter(arrayListOf()) }
}