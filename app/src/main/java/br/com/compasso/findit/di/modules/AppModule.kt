package br.com.compasso.findit.di.modules

import br.com.compasso.findit.http.AppRetrofit
import br.com.compasso.findit.http.Connection
import org.koin.dsl.module

val appModule = module {
    single { Connection() }
    single { AppRetrofit(get()) }
}

