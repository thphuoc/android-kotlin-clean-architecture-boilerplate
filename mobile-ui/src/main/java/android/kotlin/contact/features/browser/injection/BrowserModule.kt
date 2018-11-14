package android.kotlin.contact.features.browser.injection

import android.com.presentation.browser.BrowserContactContract
import android.com.presentation.browser.BrowserContactPresenter
import android.kotlin.contact.features.browser.BrowserFragment
import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.ui.injection.scopes.PerActivity
import org.buffer.android.boilerplate.ui.injection.scopes.PerFragment

@Module
class BrowserModule {

    @PerFragment
    @Provides
    fun provideBrowserView(view: BrowserFragment): BrowserContactContract.IView = view

    @PerActivity
    @Provides
    fun providePresenter(presenter: BrowserContactPresenter): BrowserContactContract.IPresenter = presenter
}