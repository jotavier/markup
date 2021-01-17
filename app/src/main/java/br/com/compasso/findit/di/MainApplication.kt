package br.com.compasso.findit.di

import android.app.Application
import br.com.compasso.findit.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("UNUSED")
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                appModule,
                adapterModule,
                clientModule,
                daoModule,
                databaseModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}