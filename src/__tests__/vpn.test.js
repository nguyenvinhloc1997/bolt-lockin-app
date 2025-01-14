const TailscaleManager = require('../../app/src/main/java/com/remoteaccess/vpn/TailscaleManager');

describe('VPN Functionality', () => {
  let vpnManager;

  beforeAll(() => {
    vpnManager = new TailscaleManager();
  });

  afterAll(async () => {
    await vpnManager.stop();
  });

  test('should start VPN connection', async () => {
    await vpnManager.start();
    expect(vpnManager.isConnected()).toBe(true);
  });

  test('should stop VPN connection', async () => {
    await vpnManager.start();
    await vpnManager.stop();
    expect(vpnManager.isConnected()).toBe(false);
  });
});
