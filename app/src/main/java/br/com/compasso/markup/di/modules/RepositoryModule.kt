package br.com.compasso.markup.di.modules

import androidx.preference.PreferenceManager
import br.com.compasso.markup.http.repositories.EventRepository
import br.com.compasso.markup.http.repositories.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { EventRepository(get(), get()) }
    single { UserRepository(PreferenceManager.getDefaultSharedPreferences(get()), get()) }
}