const { AdbManager } = require('../app/src/main/java/com/remoteaccess/adb/AdbManager');

describe('ADB Functionality', () => {
  let adbManager;

  beforeAll(() => {
    adbManager = new AdbManager();
  });

  test('should enable WiFi debugging', () => {
    adbManager.enableWifiDebugging();
    expect(adbManager.connectionState.value).toBe(true);
  });
});
