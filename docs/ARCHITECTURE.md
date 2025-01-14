# System Architecture

## Core Components
1. **Main Application**
   - Entry point and service management
   - Permission handling
   - System integration

2. **VPN Service**
   - WireGuard implementation
   - Tunnel management
   - Network monitoring

3. **ADB Manager**
   - Wi-Fi debugging control
   - Connection management
   - Device state monitoring

4. **Web Server**
   - HTTP/WebSocket server
   - API endpoints
   - Authentication layer

5. **Control Interface**
   - Device mirroring
   - Input handling
   - System controls

## Data Flow
1. Initialization:
   App → VPN Setup → ADB Enable → Web Server Start

2. Operation:
   Control Device ↔ Web Interface ↔ Android App ↔ System

3. Maintenance:
   Network Monitor → Connection Manager → State Updates

## Security Layers
1. Transport:
   - WireGuard encryption
   - TLS for web interface

2. Authentication:
   - QR code pairing
   - Session tokens
   - Device fingerprinting

3. Access Control:
   - Permission validation
   - Operation whitelisting
   - Rate limiting
