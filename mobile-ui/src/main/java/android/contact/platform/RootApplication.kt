package android.contact.platform

import android.contact.platform.di.ToothpickActivityLifecycleCallbacks
import android.contact.platform.di.openApplicationScope
import androidx.multidex.MultiDexApplication
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber
import toothpick.Toothpick


class RootApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This accept is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this accept.
            return
        }
        LeakCanary.install(this)
        Toothpick.inject(this, openApplicationScope(this))
        registerActivityLifecycleCallbacks(ToothpickActivityLifecycleCallbacks())
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}