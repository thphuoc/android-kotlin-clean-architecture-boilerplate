package com.android.tasktodo.features.home

import android.com.presentation.base.BaseContract
import android.content.Intent
import android.kotlin.contact.R
import com.android.tasktodo.base.BaseActivity
import android.os.Bundle
import android.provider.Settings

class HomeActivity : BaseActivity() {
    override val layoutId: Int = R.layout.root_activity

    override val presenter: BaseContract.IBasePresenter?
        get() = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(R.id.browserFragment, HomeFragment()).commit()
        startActivity(Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS))
    }
}