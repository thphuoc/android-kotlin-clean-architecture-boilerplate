package android.kotlin.contact

import android.content.Intent
import android.kotlin.contact.features.browser.BrowserActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Root activity need to be transparent to avoid exit whole app when user press back in Home screen
 */
class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Start service or somethings here
        this.startActivity(Intent(this, BrowserActivity::class.java))
    }
}