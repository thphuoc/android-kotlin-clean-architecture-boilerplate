package android.kotlin.contact

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import timber.log.Timber


class RootApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidModule(this@RootApplication))
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}