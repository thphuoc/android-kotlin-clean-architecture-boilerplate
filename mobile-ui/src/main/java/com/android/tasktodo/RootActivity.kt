package com.android.tasktodo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.tasktodo.features.home.HomeActivity

/**
 * Root activity need to be transparent to avoid exit whole app when user press back in Home screen
 */
class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.startActivity(Intent(this, HomeActivity::class.java))
    }
}