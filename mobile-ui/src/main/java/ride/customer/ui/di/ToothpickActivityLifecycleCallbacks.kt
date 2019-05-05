package ride.customer.ui.di

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import toothpick.Toothpick

class ToothpickActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {

    private val fragmentCallbacks = ToothpickFragmentLifecycleCallbacks()

    override fun onActivityCreated(activity: Activity?, bundle: Bundle?) {
        activity?.apply {
            Toothpick.inject(this, openActivityScope(this))
        }

        if (activity is AppCompatActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentCallbacks, true)
        }
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityPaused(activity: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
        if (activity is AppCompatActivity) {
            activity.supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentCallbacks)
        }

        activity?.apply {
            Toothpick.closeScope(this)
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity?, bundle: Bundle?) {
    }
}

class ToothpickFragmentLifecycleCallbacks : FragmentManager.FragmentLifecycleCallbacks() {
    override fun onFragmentPreAttached(fm: FragmentManager?, f: Fragment?, context: Context?) {
        f?.let { Toothpick.inject(it, Toothpick.openScope(context)) }
    }

    override fun onFragmentDetached(fm: FragmentManager?, f: Fragment?) {
        f?.let { Toothpick.closeScope(it) }
    }
}