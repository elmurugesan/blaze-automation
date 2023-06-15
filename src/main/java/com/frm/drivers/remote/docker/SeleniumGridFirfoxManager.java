package com.frm.drivers.remote.docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.frm.config.ConfigManager;

public final class SeleniumGridFirfoxManager {

	private SeleniumGridFirfoxManager() {}
	
	public static WebDriver getDriver() {
		FirefoxOptions options = new FirefoxOptions();
		return new RemoteWebDriver(ConfigManager.getConfig().seleniumGridURL(), options);
	}
}
