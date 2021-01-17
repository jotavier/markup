package br.com.compasso.findit.di.modules

import br.com.compasso.findit.http.AppRetrofit
import br.com.compasso.findit.http.clients.EventWebClient
import br.com.compasso.findit.http.clients.PersonWebClient
import org.koin.dsl.module

val clientModule = module {
    single { EventWebClient(get<AppRetrofit>().eventService) }
    single { PersonWebClient(get<AppRetrofit>().personService) }
}