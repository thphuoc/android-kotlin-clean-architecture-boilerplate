package android.kotlin.contact.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import butterknife.ButterKnife
import butterknife.Unbinder
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasActivityInjector, UiConfigInterface {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private lateinit var unbinder: Unbinder

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var view = LayoutInflater.from(this).inflate(layoutId(), null, false)
        setContentView(view)
        this.unbinder = ButterKnife.bind(this, view)
        this.getPresenter()?.onViewLoaded()
    }

    override fun onStop() {
        super.onStop()
        this.getPresenter()?.onStop()
    }

    override fun onResume() {
        super.onResume()
        this.getPresenter()?.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.getPresenter()?.onDestroy()
        this.unbinder.unbind()
    }
}