package br.com.compasso.markup.di.modules

import androidx.room.Room
import br.com.compasso.markup.database.AppDatabase
import org.koin.dsl.module

private const val DATABASE_NAME = "findit.db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }
}

val daoModule = module {
    single { get<AppDatabase>().eventDAO }
}