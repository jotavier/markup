package br.com.compasso.markup.di.modules

import br.com.compasso.markup.http.AppRetrofit
import br.com.compasso.markup.http.clients.EventWebClient
import br.com.compasso.markup.http.clients.UserWebClient
import org.koin.dsl.module

val clientModule = module {
    single { EventWebClient(get<AppRetrofit>().eventService) }
    single { UserWebClient(get<AppRetrofit>().checkInService) }
}