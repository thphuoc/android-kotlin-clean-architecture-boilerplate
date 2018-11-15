package android.com.presentation.base

open class BasePresenter: BaseContract.IBasePresenter {
    override lateinit var view: BaseContract.IBaseView

    override fun onViewLoaded() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
    }

    override fun onResume() {
    }
}