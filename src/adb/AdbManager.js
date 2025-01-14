class AdbManager {
  constructor() {
    this.debuggingEnabled = false;
  }

  async enableWifiDebugging() {
    this.debuggingEnabled = true;
  }

  isDebuggingEnabled() {
    return this.debuggingEnabled;
  }
}

module.exports = AdbManager;
