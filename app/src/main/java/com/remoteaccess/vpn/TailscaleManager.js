class TailscaleManager {
  constructor() {
    this.connected = false;
  }

  async start() {
    this.connected = true;
  }

  async stop() {
    this.connected = false;
  }

  isConnected() {
    return this.connected;
  }
}

module.exports = TailscaleManager;
