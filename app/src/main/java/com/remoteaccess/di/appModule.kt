package com.remoteaccess.di

import com.remoteaccess.vpn.TailscaleManager
import com.remoteaccess.adb.AdbManager
import com.remoteaccess.web.WebServer
import org.koin.dsl.module

val appModule = module {
    single { TailscaleManager(get()) }
    single { AdbManager(get()) }
    single { WebServer(get(), get()) }
}
