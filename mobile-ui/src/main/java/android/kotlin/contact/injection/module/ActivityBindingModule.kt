package android.kotlin.contact.injection.module

import android.kotlin.contact.RootActivity
import android.kotlin.contact.features.browser.injection.HomeModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.buffer.android.boilerplate.ui.injection.scopes.PerActivity

@Module
abstract class ActivityBindingModule {
    @PerActivity
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun bindRootActivity(): RootActivity
}
