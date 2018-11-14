package android.kotlin.contact.injection.module

import android.kotlin.contact.features.browser.BrowserFragment
import android.kotlin.contact.features.browser.injection.BrowserModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.buffer.android.boilerplate.ui.injection.scopes.PerFragment

@Module
abstract class FragmentBuilderModule {
    @PerFragment
    @ContributesAndroidInjector(modules = [BrowserModule::class])
    abstract fun contributeBrowserModule(): BrowserFragment
}