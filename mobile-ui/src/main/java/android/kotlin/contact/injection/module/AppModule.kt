package android.kotlin.contact.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.ui.injection.scopes.PerApplication

@Module
open class AppModule {
    @Provides
    @PerApplication
    fun provideContext(app: Application): Context {
        return app
    }
}