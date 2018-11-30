package android.kotlin.contact

import android.kotlin.contact.koin.module.presenterModule
import androidx.multidex.MultiDexApplication
import org.koin.android.ext.android.startKoin
import timber.log.Timber


class RootApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        startKoin(this, listOf(presenterModule))
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}