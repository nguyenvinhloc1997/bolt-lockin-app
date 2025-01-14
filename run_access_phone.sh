#!/bin/bash

# Verify ADB is available
if ! command -v adb &> /dev/null
then
    echo "ADB not found. Please install Android SDK."
    exit 1
fi

# Get script directory
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"

# Load configuration
source "$SCRIPT_DIR/device_config.conf"

# Test connection
echo "Testing connection to device at $DEVICE_IP"
adb connect $DEVICE_IP

# Verify connection
if adb devices | grep -q "$DEVICE_IP"
then
    echo "Connection successful"
    exit 0
else
    echo "Connection failed"
    exit 1
fi
