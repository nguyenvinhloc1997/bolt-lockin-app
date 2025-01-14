const AdbManager = require('../../app/src/main/java/com/remoteaccess/adb/AdbManager');

describe('ADB Functionality', () => {
  let adbManager;

  beforeAll(() => {
    adbManager = new AdbManager();
  });

  afterAll(() => {
    // Clean up any ADB connections
  });

  test('should enable WiFi debugging', async () => {
    await adbManager.enableWifiDebugging();
    expect(adbManager.isDebuggingEnabled()).toBe(true);
  });
});
