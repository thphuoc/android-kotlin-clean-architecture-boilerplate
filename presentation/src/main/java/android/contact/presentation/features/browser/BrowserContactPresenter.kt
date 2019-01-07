package android.contact.presentation.features.browser

import android.contact.presentation.base.BasePresenter

class BrowserContactPresenter(val view: BrowserContactContract.IView) : BasePresenter(view),
        BrowserContactContract.IPresenter {

    override fun onClickRemoveContact(id: String) {
        view.showErrorToast("Hello")
    }

    override fun onClickAddNewContact() {
        view.showErrorToast("Hello")
    }
}