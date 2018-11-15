package android.kotlin.contact.base

import android.com.presentation.browser.BrowserContactContract
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.Unbinder
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.android.support.closestKodein
import org.kodein.di.generic.kcontext

abstract class BaseFragment : Fragment(), UIContract, BrowserContactContract.IView, KodeinAware {

    override val kodeinContext: KodeinContext<*> get() = kcontext(activity)

    override val kodein by closestKodein()

    private lateinit var unbinder: Unbinder

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