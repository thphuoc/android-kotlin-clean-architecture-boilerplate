package android.kotlin.contact.injection.component

import android.app.Application
import android.kotlin.contact.RootApplication
import android.kotlin.contact.injection.module.ActivityBindingModule
import android.kotlin.contact.injection.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import org.buffer.android.boilerplate.ui.injection.scopes.PerApplication

@PerApplication
@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class, ActivityBindingModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: RootApplication)
}
