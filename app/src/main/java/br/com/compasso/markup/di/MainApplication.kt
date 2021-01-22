package br.com.compasso.markup.di

import androidx.multidex.MultiDexApplication
import br.com.compasso.markup.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("UNUSED")
class MainApplication : MultiDexApplication() {
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
                formModule,
                databaseModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}