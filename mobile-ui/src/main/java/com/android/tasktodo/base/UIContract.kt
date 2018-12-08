package com.android.tasktodo.base

import android.com.presentation.base.BaseContract

interface UIContract {
    val layoutId: Int
    val presenter: BaseContract.IBasePresenter?
}