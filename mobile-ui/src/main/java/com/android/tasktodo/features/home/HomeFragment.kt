package com.android.tasktodo.features.home

import android.com.domain.entities.Contact
import android.com.presentation.features.browser.BrowserContactContract
import android.kotlin.contact.R
import android.kotlin.contact.configs.AppConfigs
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.tasktodo.base.BaseFragment
import com.android.tasktodo.features.home.completed.TaskCompletedFragment
import com.android.tasktodo.features.home.inprogress.TaskInProgressFragment
import com.android.tasktodo.features.home.myhiring.MyHiringFragment
import com.android.tasktodo.features.home.profile.ProfileFragment
import com.android.tasktodo.features.home.todo.TodoFragment
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