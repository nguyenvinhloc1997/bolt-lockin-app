package com.remoteaccess.vpn

import android.content.Context
import com.tailscale.ipn.IPN
import com.tailscale.ipn.IPNListener
import com.tailscale.ipn.IPNOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TailscaleManager(context: Context) : IPNListener {
    private val ipn: IPN = IPN(context)
    private val _connectionState = MutableStateFlow(false)
    val connectionState: StateFlow<Boolean> get() = _connectionState

    init {
        ipn.setListener(this)
    }

    fun start() {
        val options = IPNOptions.Builder()
            .setAutoConnect(true)
            .setRunInForeground(true)
            .build()
        ipn.start(options)
    }

    fun stop() {
        ipn.stop()
    }

    override fun onStatusChanged(status: IPN.Status) {
        _connectionState.value = status == IPN.Status.RUNNING
    }
}
