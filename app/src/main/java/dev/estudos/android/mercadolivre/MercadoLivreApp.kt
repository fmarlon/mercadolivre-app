package dev.estudos.android.mercadolivre

import android.app.Application
import dev.estudos.android.mercadolivre.config.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MercadoLivreApp: Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MercadoLivreApp)
            modules(appModule)
        }
    }

}