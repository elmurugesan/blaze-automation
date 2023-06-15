package com.frm.drivers.remote.docker;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.frm.config.ConfigManager;

public final class SeleniumGridChromeManager {
	
	private SeleniumGridChromeManager() {}
	
	public static RemoteWebDriver getDriver() {
		ChromeOptions options = new ChromeOptions();
		return new RemoteWebDriver(ConfigManager.getConfig().seleniumGridURL(), options);
	}
}
