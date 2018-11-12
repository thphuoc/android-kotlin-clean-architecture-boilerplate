package android.com.presentation.contact

import android.com.domain.entities.Contact
import android.com.presentation.base.BaseContract

class ContactContract {
    interface View : BaseContract.BaseView {
        fun showListContact(contacts: List<Contact>)
        fun showError()
    }

    interface Presenter : BaseContract.BasePresenter {

    }
}