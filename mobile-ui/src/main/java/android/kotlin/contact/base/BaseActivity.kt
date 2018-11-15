package android.kotlin.contact.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import butterknife.ButterKnife
import butterknife.Unbinder

abstract class BaseActivity : AppCompatActivity(), UIContract {

    private lateinit var unbinder: Unbinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = LayoutInflater.from(this).inflate(layoutId, null, false)
        setContentView(view)
        this.unbinder = ButterKnife.bind(this, view)
        presenter?.onViewLoaded()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onStop()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
        this.unbinder.unbind()
    }
}