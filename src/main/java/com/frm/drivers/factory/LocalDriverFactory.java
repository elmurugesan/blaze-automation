package com.frm.drivers.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import com.frm.enums.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class LocalDriverFactory {

	private LocalDriverFactory() {}
	
	private static Supplier<WebDriver> CHROMEDRIVER = ()->WebDriverManager.chromedriver().create();
	private static Supplier<WebDriver> FIREFOXDRIVER = ()->WebDriverManager.firefoxdriver().create();
	private static Supplier<WebDriver> EDGEDRIVER = ()->WebDriverManager.edgedriver().create();
	
	private static Map<BrowserType, Supplier<WebDriver>> map = new EnumMap<>(BrowserType.class);
	
	static {
		map.put(BrowserType.CHROME, CHROMEDRIVER);
		map.put(BrowserType.FIREFOX, FIREFOXDRIVER);
		map.put(BrowserType.EDGE, EDGEDRIVER);
	}
	
	public static WebDriver getDriver(BrowserType browserName) {
		return map.get(browserName).get();
	}
}
