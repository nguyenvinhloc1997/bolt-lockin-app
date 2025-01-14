package com.remoteaccess.vpn

import android.app.Service
import android.content.Intent
import android.os.IBinder

class VpnService : Service() {
    private lateinit var tailscaleManager: TailscaleManager

    override fun onCreate() {
        super.onCreate()
        tailscaleManager = TailscaleManager(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        tailscaleManager.startVPN()
        return START_STICKY
    }

    override fun onDestroy() {
        tailscaleManager.stopVPN()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
