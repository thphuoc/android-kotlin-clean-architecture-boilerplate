package com.android.tasktodo.koin.module

import android.com.presentation.features.browser.BrowserContactContract
import android.com.presentation.features.browser.BrowserContactPresenter
import org.koin.dsl.module.module

val presenterModule = module {
    single<BrowserContactContract.IPresenter> { (view: BrowserContactContract.IView) -> BrowserContactPresenter(view) }
}