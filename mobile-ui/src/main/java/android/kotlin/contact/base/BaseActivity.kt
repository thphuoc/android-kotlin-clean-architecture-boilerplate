package android.kotlin.contact.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import butterknife.ButterKnife
import butterknife.Unbinder
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.kcontext

abstract class BaseActivity : AppCompatActivity(), UIContract, KodeinAware {

    override val kodeinContext: KodeinContext<*> = kcontext(this)

    private val _parentKodein by closestKodein()

    override val kodein: Kodein by retainedKodein {
        extend(_parentKodein, copy = Copy.All)
    }

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