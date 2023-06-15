package com.frm.drivers.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import com.frm.drivers.remote.docker.selenoid.SelenoidGridChromeManager;
import com.frm.drivers.remote.docker.selenoid.SelenoidGridFirefoxManager;
import com.frm.enums.BrowserType;

public final class SelenoidGridFactory {

	private SelenoidGridFactory() {}
	
	private static Supplier<WebDriver> SELENIODCHROMEDRIVER = () -> SelenoidGridChromeManager.getDriver();
	private static Supplier<WebDriver> SELENIODFIREFIXDRIVER = () -> SelenoidGridFirefoxManager.getDriver();
	
	private static Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);
	
	static {
		MAP.put(BrowserType.CHROME, SELENIODCHROMEDRIVER);
		MAP.put(BrowserType.FIREFOX, SELENIODFIREFIXDRIVER);
	}
	
	public static WebDriver getDriver(BrowserType browserType) {
		return MAP.get(browserType).get();
	}
}
