package ride.customer.ui.features.home

import android.customer.domain.entities.Contact
import android.customer.presentation.features.browser.BrowserContactContract
import android.customer.ui.R
import android.customer.ui.configs.AppConfigs
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.customer.ui.base.BaseFragment
import android.customer.ui.features.home.contact_list_tabs.TaskCompletedFragment
import android.customer.ui.features.home.history_tabs.TaskInProgressFragment
import android.customer.ui.features.home.call_tabs.MyHiringFragment
import android.customer.ui.features.home.profile.ProfileFragment
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