package android.contact.platform.features.home

import android.contact.presentation.base.BaseContract
import android.contact.platform.base.BaseActivity
import android.contact.contact.R
import android.os.Bundle

class HomeActivity : BaseActivity() {
    override val layoutId: Int = R.layout.root_activity

    override val presenter: BaseContract.IBasePresenter?
        get() = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(R.id.browserFragment, HomeFragment()).commit()
    }
}