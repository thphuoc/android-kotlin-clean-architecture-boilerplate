package android.kotlin.contact.features.browser

import android.com.domain.entities.Contact
import android.com.presentation.browser.BrowserContactContract
import android.kotlin.contact.R
import android.kotlin.contact.base.BaseFragment
import android.kotlin.contact.configs.AppConfigs
import android.os.Bundle
import android.view.View
import android.widget.Toast
import butterknife.OnClick
import kotlinx.android.synthetic.main.contact_browser_fragment.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class BrowserFragment : BaseFragment(), BrowserContactContract.IView {

    override val layoutId = R.layout.contact_browser_fragment
    override val presenter: BrowserContactContract.IPresenter by inject { parametersOf(this) }

    override fun showListContact(contacts: List<Contact>) {
        Toast.makeText(context, "Show contact list: " + AppConfigs.BASE_URL, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddContact.setOnClickListener { onClickAddContact() }
    }

    @OnClick(R.id.btnAddContact)
    fun onClickAddContact() {
        presenter.onClickAddNewContact()
    }
}