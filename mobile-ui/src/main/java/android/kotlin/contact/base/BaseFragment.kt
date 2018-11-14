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
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragment : Fragment(), HasSupportFragmentInjector, UiConfigInterface, BrowserContactContract.IView {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var unbinder: Unbinder

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return dispatchingAndroidInjector
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layoutId(), container, false)
        this.unbinder = ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.getPresenter()?.onViewLoaded()
    }

    override fun onStop() {
        super.onStop()
        this.getPresenter()?.onStop()
    }

    override fun onResume() {
        super.onResume()
        this.getPresenter()?.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.getPresenter()?.onDestroy()
        this.unbinder.unbind()
    }

    override fun showErrorDialog(code: String, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showErrorToast(code: String, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}