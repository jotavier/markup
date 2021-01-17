package br.com.compasso.findit.di.modules

import br.com.compasso.findit.http.repositories.EventRepository
import br.com.compasso.findit.http.repositories.PersonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { EventRepository(get(), get()) }
    single { PersonRepository(get(), get()) }
}