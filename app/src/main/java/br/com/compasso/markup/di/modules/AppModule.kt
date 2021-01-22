package br.com.compasso.markup.di.modules

import br.com.compasso.markup.http.AppRetrofit
import br.com.compasso.markup.http.Connection
import org.koin.dsl.module

val appModule = module {
    single { Connection() }
    single { AppRetrofit(get()) }
}

