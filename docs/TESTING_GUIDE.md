# Comprehensive Testing Guide

## Test Environment Setup
1. **Android Device**
   - Enable Developer Options
   - Enable USB Debugging
   - Connect via USB

2. **Emulator**
   - Create new virtual device
   - Start emulator

## Test Types
1. **Unit Tests**
   - Core functionality
   - Business logic
   - Utility classes

2. **Instrumentation Tests**
   - UI components
   - Service interactions
   - System integration

3. **Manual Tests**
   - End-to-end functionality
   - User experience
   - Edge cases

## Test Coverage
- VPN functionality
- ADB operations
- Web interface
- Background service
- Security features

## Debugging
1. **Logcat Monitoring**
```bash
adb logcat -s RemoteAccess
```

2. **Debug Build**
```bash
./gradlew assembleDebug
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

3. **Profiling**
   - CPU usage
   - Memory allocation
   - Network activity
