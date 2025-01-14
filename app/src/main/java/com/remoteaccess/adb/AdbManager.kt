package com.remoteaccess.adb

import android.content.Context
import android.provider.Settings
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AdbManager(context: Context) {
    private val prefs = context.getSharedPreferences("adb", Context.MODE_PRIVATE)
    private val _connectionState = MutableStateFlow(false)
    val connectionState: StateFlow<Boolean> get() = _connectionState

    fun enableWifiDebugging() {
        Settings.Global.putInt(
            context.contentResolver,
            "adb_wifi_enabled",
            1
        )
    }

    fun connect(ip: String, port: Int = 5555) {
        // Implementation of ADB connection
    }
}
