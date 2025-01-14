const { TailscaleManager } = require('../app/src/main/java/com/remoteaccess/vpn/TailscaleManager');

describe('VPN Functionality', () => {
  let vpnManager;

  beforeAll(() => {
    vpnManager = new TailscaleManager();
  });

  test('should start VPN connection', async () => {
    await vpnManager.start();
    expect(vpnManager.connectionState.value).toBe(true);
  });

  test('should stop VPN connection', async () => {
    await vpnManager.stop();
    expect(vpnManager.connectionState.value).toBe(false);
  });
});
