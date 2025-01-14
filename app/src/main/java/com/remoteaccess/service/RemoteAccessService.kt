package com.remoteaccess.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.remoteaccess.notification.NotificationManager
import com.remoteaccess.vpn.TailscaleManager
import org.koin.android.ext.android.inject

class RemoteAccessService : Service() {
    private val notificationManager: NotificationManager by inject()
    private val vpnManager: TailscaleManager by inject()

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        startForeground(1, notificationManager.createForegroundNotification())
        vpnManager.start()
    }

    override fun onDestroy() {
        vpnManager.stop()
        super.onDestroy()
    }
}
