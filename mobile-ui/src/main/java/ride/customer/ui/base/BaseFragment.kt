package ride.customer.ui.base

import android.customer.presentation.base.BaseContract
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.Unbinder

abstract class BaseFragment : Fragment(), UIContract, BaseContract.IBaseView {

    private lateinit var unbinder: Unbinder
    override val presenter: BaseContract.IBasePresenter?
        get() = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layoutId, container, false)
        this.unbinder = ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.onViewLoaded()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onStop()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
        this.unbinder.unbind()
    }

    override fun showErrorDialog(code: String, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showErrorToast(code: String, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}