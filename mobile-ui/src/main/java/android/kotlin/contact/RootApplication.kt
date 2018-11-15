package android.kotlin.contact

import android.app.Application
import android.com.presentation.browser.BrowserContactPresenter
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module
import timber.log.Timber


class RootApplication : Application() {

    private val appModule = module {
        scope("activity") {
            BrowserContactPresenter()
        }
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        startKoin(this, listOf(appModule))
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}