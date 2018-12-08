package com.android.tasktodo.features.home.profile

import android.com.domain.entities.Contact
import android.com.presentation.features.browser.BrowserContactContract
import android.kotlin.contact.R
import com.android.tasktodo.base.BaseFragment
import android.kotlin.contact.configs.AppConfigs
import android.os.Bundle
import android.view.View
import android.widget.Toast
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ProfileFragment : BaseFragment(), BrowserContactContract.IView {

    override val layoutId = R.layout.home_fragment
    override val presenter: BrowserContactContract.IPresenter by inject { parametersOf(this) }

    override fun showListContact(contacts: List<Contact>) {
        Toast.makeText(context, "Show contact list: " + AppConfigs.BASE_URL, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun onClickAddContact() {
        presenter.onClickAddNewContact()
    }
}