package android.contact.platform.features.home

import android.contact.domain.entities.Contact
import android.contact.presentation.features.browser.BrowserContactContract
import android.contact.contact.R
import android.contact.contact.configs.AppConfigs
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.contact.platform.base.BaseFragment
import android.contact.platform.features.home.contact_list_tabs.TaskCompletedFragment
import android.contact.platform.features.home.history_tabs.TaskInProgressFragment
import android.contact.platform.features.home.call_tabs.MyHiringFragment
import android.contact.platform.features.home.profile.ProfileFragment
import android.contact.platform.features.home.todo.TodoFragment
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment(), BrowserContactContract.IView {

    override val layoutId = R.layout.home_fragment

    override fun showListContact(contacts: List<Contact>) {
        Toast.makeText(context, "Show contact list: " + AppConfigs.BASE_URL, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        homeTabLayout.setupWithViewPager(homeViewPager, true)
        setupTabIcons()
    }

    private fun setupTabIcons() {
        listIcon.forEach { i -> homeTabLayout.getTabAt(listIcon.indexOf(i))?.setIcon(i) }
    }

    private fun setupViewPager() {
        val adapter = HomePagerAdapter(fragmentManager!!)
        adapter.addFrag(TodoFragment())
        adapter.addFrag(TaskInProgressFragment())
        adapter.addFrag(TaskCompletedFragment())
        adapter.addFrag(MyHiringFragment())
        adapter.addFrag(ProfileFragment())
        homeViewPager.adapter = adapter
    }

    companion object {
        val listIcon = intArrayOf(
                R.drawable.icon_camera,
                R.drawable.icon_gallery,
                R.drawable.icon_map,
                R.drawable.icon_settings,
                R.drawable.icon_settings)
    }
}