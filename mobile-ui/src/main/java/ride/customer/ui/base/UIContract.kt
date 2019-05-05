package ride.customer.ui.base

import android.customer.presentation.base.BaseContract

interface UIContract {
    val layoutId: Int
    val presenter: BaseContract.IBasePresenter?
}