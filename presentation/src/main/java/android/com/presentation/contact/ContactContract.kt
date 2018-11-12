package android.com.presentation.contact

import android.com.domain.entities.Contact
import android.com.presentation.base.BaseContract

class ContactContract {
    interface IView : BaseContract.IBaseView {
        fun showListContact(contacts: List<Contact>)
        fun showError()
    }

    interface IPresenter : BaseContract.IBasePresenter {
        fun onClickRemoveContact(id: String)
        fun onClickAddNewContact()
    }
}