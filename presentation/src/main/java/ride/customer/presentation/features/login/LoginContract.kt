package ride.customer.presentation.features.login

import ride.customer.domain.entities.User
import ride.customer.presentation.base.BaseContract

class LoginContract {
    interface IView : BaseContract.IBaseView {
        fun showListContact(users: List<User>)
    }

    interface IPresenter : BaseContract.IBasePresenter {
        fun onClickRemoveContact(id: String)
        fun onClickAddNewContact()
    }
}