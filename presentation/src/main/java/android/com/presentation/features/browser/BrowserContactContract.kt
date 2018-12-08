package android.com.presentation.features.browser

import android.com.domain.entities.Contact
import android.com.presentation.base.BaseContract

class BrowserContactContract {
    interface IView : BaseContract.IBaseView {
        fun showListContact(contacts: List<Contact>)
    }

    interface IPresenter : BaseContract.IBasePresenter {
        fun onClickRemoveContact(id: String)
        fun onClickAddNewContact()
    }
}