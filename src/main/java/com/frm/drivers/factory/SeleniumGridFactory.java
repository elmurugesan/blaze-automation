package com.frm.drivers.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import com.frm.drivers.remote.docker.SeleniumGridChromeManager;
import com.frm.drivers.remote.docker.SeleniumGridFirfoxManager;
import com.frm.enums.BrowserType;

public final class SeleniumGridFactory {
	
	private SeleniumGridFactory() {}
	
	private static Supplier<WebDriver> SELENIUMGRIDCHROMEDRIVER = ()-> SeleniumGridChromeManager.getDriver();
	private static Supplier<WebDriver> SELENIUMGRIDFIRFOXDRIVER = ()-> SeleniumGridFirfoxManager.getDriver();

	private static Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);
	
	static {
		MAP.put(BrowserType.CHROME, SELENIUMGRIDCHROMEDRIVER);
		MAP.put(BrowserType.FIREFOX, SELENIUMGRIDFIRFOXDRIVER);
	}
	
	public static WebDriver getDriver(BrowserType browserType) {
		return MAP.get(browserType).get();
	}
}
	