package android.contact.platform.di

import android.app.Activity
import android.app.Application
import toothpick.Scope
import toothpick.Toothpick
import toothpick.smoothie.module.SmoothieActivityModule
import toothpick.smoothie.module.SmoothieApplicationModule

fun openApplicationScope(app: Application): Scope = Toothpick.openScope(app).apply {
    installModules(
            SmoothieApplicationModule(app),
            AppModule(app))
}

fun openActivityScope(activity: Activity): Scope = Toothpick.openScopes(activity.application, activity).apply {
    bindScopeAnnotation(ActivitySingleton::class.java)

    installModules(
            SmoothieActivityModule(activity),
            ActivityModule(activity))
}