package android.kotlin.contact.koin.module

import android.com.presentation.browser.BrowserContactContract
import android.com.presentation.browser.BrowserContactPresenter
import org.koin.dsl.module.module

val presenterModule = module {
    single<BrowserContactContract.IPresenter> { (view: BrowserContactContract.IView) -> BrowserContactPresenter(view) }
}