package android.contact.platform.koin.module

import android.contact.presentation.features.browser.BrowserContactContract
import android.contact.presentation.features.browser.BrowserContactPresenter
import org.koin.dsl.module.module

val presenterModule = module {
    single<BrowserContactContract.IPresenter> { (view: BrowserContactContract.IView) -> BrowserContactPresenter(view) }
}