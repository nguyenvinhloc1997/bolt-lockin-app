# Remote Android Access and Control

## Testing Instructions

### Prerequisites
1. Android Studio (latest version)
2. Physical Android device or emulator (API 26+)
3. Java Development Kit (JDK 17+)
4. Node.js (v16+)

### Setup
1. Clone repository:
```bash
git clone https://github.com/your-repo/remote-access-app.git
cd remote-access-app
```

2. Install dependencies:
```bash
./gradlew dependencies
npm install
```

3. Build the application:
```bash
./gradlew assembleDebug
```

### Automated Tests
1. Run unit tests:
```bash
./gradlew test
```

2. Run instrumentation tests:
```bash
./gradlew connectedDebugAndroidTest
```

### Manual Testing
1. Install APK:
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

2. Test features:
- VPN connection
- ADB functionality
- Web interface
- Background service

[Rest of README content...]
