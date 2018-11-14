package android.kotlin.contact.features.browser

import android.com.domain.entities.Contact
import android.com.presentation.base.BaseContract
import android.com.presentation.browser.BrowserContactContract
import android.com.presentation.browser.BrowserContactPresenter
import android.kotlin.contact.R
import android.kotlin.contact.base.BaseFragment
import android.kotlin.contact.configs.AppConfigs
import android.widget.Toast
import butterknife.OnClick
import javax.inject.Inject

class BrowserFragment : BaseFragment(), BrowserContactContract.IView {

    @Inject
    lateinit var presenter: BrowserContactPresenter

    override fun layoutId() = R.layout.contact_browser_fragment

    override fun getPresenter(): BaseContract.IBasePresenter? = presenter

    override fun showListContact(contacts: List<Contact>) {
        Toast.makeText(context, "Show contact list: "+ AppConfigs.BASE_URL, Toast.LENGTH_SHORT).show()
    }

    @OnClick(R.id.btnAddContact)
    fun onClickAddContact() {
        presenter.onClickAddNewContact()
    }
}