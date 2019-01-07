package android.contact.presentation.features.browser

import android.contact.domain.entities.Contact
import android.contact.presentation.base.BaseContract

class BrowserContactContract {
    interface IView : BaseContract.IBaseView {
        fun showListContact(contacts: List<Contact>)
    }

    interface IPresenter : BaseContract.IBasePresenter {
        fun onClickRemoveContact(id: String)
        fun onClickAddNewContact()
    }
}