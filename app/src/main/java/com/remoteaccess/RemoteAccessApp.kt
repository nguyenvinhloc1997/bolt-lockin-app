package com.remoteaccess

import android.app.Application
import com.remoteaccess.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RemoteAccessApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RemoteAccessApp)
            modules(appModule)
        }
    }
}
