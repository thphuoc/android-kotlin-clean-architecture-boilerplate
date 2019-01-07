package android.contact.platform.base

import android.contact.presentation.base.BaseContract

interface UIContract {
    val layoutId: Int
    val presenter: BaseContract.IBasePresenter?
}