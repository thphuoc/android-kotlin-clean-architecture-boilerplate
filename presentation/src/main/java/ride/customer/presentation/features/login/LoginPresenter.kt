package ride.customer.presentation.features.login

import ride.customer.presentation.base.BasePresenter

class LoginPresenter(private val view: LoginContract.IView) : BasePresenter(view),
        LoginContract.IPresenter {

    override fun onClickRemoveContact(id: String) {
        view.showErrorToast("Hello")
    }

    override fun onClickAddNewContact() {
        view.showErrorToast("Hello")
    }
}