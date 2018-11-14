package android.kotlin.contact.features.browser

import android.com.presentation.base.BaseContract
import android.kotlin.contact.R
import android.kotlin.contact.base.BaseActivity
import android.os.Bundle

class BrowserActivity : BaseActivity() {
    override fun layoutId(): Int = R.layout.root_activity

    override fun getPresenter(): BaseContract.IBasePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(R.id.browserFragment, BrowserFragment()).commit()
    }
}