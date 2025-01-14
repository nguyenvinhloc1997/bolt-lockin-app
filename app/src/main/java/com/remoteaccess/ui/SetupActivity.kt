package com.remoteaccess.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.remoteaccess.vpn.TailscaleManager
import org.koin.android.ext.android.inject

class SetupActivity : ComponentActivity() {
    private val vpnManager: TailscaleManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemoteAccessTheme {
                SetupScreen(vpnManager)
            }
        }
    }
}

@Composable
fun SetupScreen(vpnManager: TailscaleManager) {
    var isConnected by remember { mutableStateOf(false) }
    
    LaunchedEffect(vpnManager) {
        vpnManager.connectionState.collect { connected ->
            isConnected = connected
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Remote Access Setup", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { vpnManager.start() },
            enabled = !isConnected
        ) {
            Text(if (isConnected) "Connected" else "Connect VPN")
        }
    }
}
