package com.remoteaccess.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.remoteaccess.adb.AdbManager
import com.remoteaccess.vpn.TailscaleManager
import com.remoteaccess.web.WebServer
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val vpnManager: TailscaleManager by inject()
    private val adbManager: AdbManager by inject()
    private val webServer: WebServer by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemoteAccessTheme {
                MainScreen(vpnManager, adbManager, webServer)
            }
        }
    }
}

@Composable
fun MainScreen(
    vpnManager: TailscaleManager,
    adbManager: AdbManager,
    webServer: WebServer
) {
    var vpnConnected by remember { mutableStateOf(false) }
    var adbConnected by remember { mutableStateOf(false) }
    var webServerRunning by remember { mutableStateOf(false) }

    LaunchedEffect(vpnManager) {
        vpnManager.connectionState.collect { connected ->
            vpnConnected = connected
        }
    }

    LaunchedEffect(adbManager) {
        adbManager.connectionState.collect { connected ->
            adbConnected = connected
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Remote Access", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        
        StatusCard("VPN", vpnConnected) {
            if (vpnConnected) vpnManager.stop() else vpnManager.start()
        }
        
        StatusCard("ADB", adbConnected) {
            adbManager.enableWifiDebugging()
        }
        
        StatusCard("Web Server", webServerRunning) {
            if (webServerRunning) webServer.stop() else webServer.start()
        }
    }
}

@Composable
fun StatusCard(
    title: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Switch(
                checked = isActive,
                onCheckedChange = { onClick() }
            )
        }
    }
}
