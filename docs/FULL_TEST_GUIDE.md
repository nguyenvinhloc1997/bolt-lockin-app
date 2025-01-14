# Complete Testing Guide for Remote Access App

## Step 1: Environment Setup

### 1.1 Install Prerequisites
1. Install Android Studio:
   - Download from https://developer.android.com/studio
   - Follow installation wizard
   - Install Android SDK (API level 26+)

2. Install Java Development Kit (JDK 17+):
   - Download from https://adoptium.net/
   - Set JAVA_HOME environment variable

3. Install Node.js (v16+):
   - Download from https://nodejs.org/
   - Verify installation: `node -v` and `npm -v`

4. Install ADB:
   - Through Android Studio SDK Manager
   - Verify installation: `adb version`

### 1.2 Set Up Device
1. For physical device:
   - Enable Developer Options
   - Enable USB Debugging
   - Connect via USB

2. For emulator:
   - Open Android Studio
   - Create new virtual device
   - Start emulator

## Step 2: Project Setup

### 2.1 Clone Repository
```bash
git clone https://github.com/your-repo/remote-access-app.git
cd remote-access-app
```

### 2.2 Install Dependencies
```bash
# Android dependencies
./gradlew dependencies

# Node.js dependencies
npm install
```

### 2.3 Build the Application
```bash
./gradlew assembleDebug
```

## Step 3: Automated Testing

### 3.1 Unit Tests
```bash
./gradlew test
```

### 3.2 Instrumentation Tests
```bash
./gradlew connectedDebugAndroidTest
```

### 3.3 View Test Results
```bash
# Unit tests
open app/build/reports/tests/testDebugUnitTest/index.html

# Instrumentation tests
open app/build/reports/androidTests/connected/index.html
```

## Step 4: Manual Testing

### 4.1 Install Application
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

### 4.2 VPN Testing
1. Launch app
2. Enable VPN
3. Verify:
   - Connection status
   - Network traffic
   - Automatic reconnection

### 4.3 ADB Testing
1. Enable Wi-Fi debugging
2. Verify:
   - ADB connection
   - Remote commands
   - Debugging persistence

### 4.4 Web Interface Testing
1. Connect to web interface
2. Verify:
   - Screen mirroring
   - Input handling
   - System controls

## Step 5: Debugging and Profiling

### 5.1 Log Monitoring
```bash
adb logcat -s RemoteAccess
```

### 5.2 Debug Build
```bash
./gradlew assembleDebug
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### 5.3 Profiling
1. Open Android Studio
2. Run > Profile
3. Monitor:
   - CPU usage
   - Memory allocation
   - Network activity

## Step 6: Troubleshooting

### 6.1 ADB Issues
```bash
# Check connected devices
adb devices

# Restart ADB server
adb kill-server && adb start-server
```

### 6.2 VPN Issues
1. Check network connectivity
2. Verify VPN permissions
3. Review system logs

### 6.3 Web Interface Issues
1. Verify IP address
2. Check firewall settings
3. Ensure port forwarding

## Step 7: Reporting

### 7.1 Create Test Report
1. Document test results
2. Include screenshots
3. Note any issues

### 7.2 Submit Feedback
1. Create GitHub issue
2. Include:
   - Test environment details
   - Steps to reproduce
   - Logs and screenshots
