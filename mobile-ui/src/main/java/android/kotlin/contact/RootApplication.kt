package android.kotlin.contact

import android.app.Activity
import android.app.Application
import android.kotlin.contact.injection.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class RootApplication: Application() {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}