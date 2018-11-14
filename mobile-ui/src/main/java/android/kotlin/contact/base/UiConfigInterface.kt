package android.kotlin.contact.base

import android.com.presentation.base.BaseContract
import android.support.annotation.LayoutRes

interface UiConfigInterface {
    @LayoutRes
    fun layoutId(): Int

    fun getPresenter(): BaseContract.IBasePresenter?
}