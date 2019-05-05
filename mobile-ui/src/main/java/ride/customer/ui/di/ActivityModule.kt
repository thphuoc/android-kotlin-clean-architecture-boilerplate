package ride.customer.ui.di

import android.app.Activity
import ride.customer.presentation.features.login.LoginPresenter
import toothpick.config.Module

class ActivityModule(activity: Activity) : Module() {
    init {
        bind(LoginPresenter::class.java) to activity
    }
}