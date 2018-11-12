package android.com.presentation.base

class BaseContract {
    interface BaseView {
        fun showErrorDialog(code: String = "", message: String = "")
        fun showErrorToast(code: String = "", message: String = "")
    }

    interface BasePresenter {
        fun onViewLoaded()
        fun onStop()
        fun onDestroy()
    }
}