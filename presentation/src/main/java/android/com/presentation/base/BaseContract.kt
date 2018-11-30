package android.com.presentation.base

class BaseContract {
    interface IBaseView {
        fun showErrorDialog(code: String = "", message: String = "")
        fun showErrorToast(code: String = "", message: String = "")
    }

    interface IBasePresenter {
        fun onViewLoaded()
        fun onStop()
        fun onResume()
        fun onDestroy()
    }
}