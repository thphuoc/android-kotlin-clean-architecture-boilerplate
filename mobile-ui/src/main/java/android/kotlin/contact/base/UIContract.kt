package android.kotlin.contact.base

import android.com.presentation.base.BaseContract

interface UIContract {
    val layoutId: Int
    val presenter: BaseContract.IBasePresenter?
}