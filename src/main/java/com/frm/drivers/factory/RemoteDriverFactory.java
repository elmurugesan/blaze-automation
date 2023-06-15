package com.frm.drivers.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

import com.frm.enums.BrowserType;
import com.frm.enums.RemoteType;

public final class RemoteDriverFactory {

	private RemoteDriverFactory() {}
	
	private static Function<BrowserType, WebDriver> SELENIUMGRID = (browserType) -> SeleniumGridFactory.getDriver(browserType);
	private static Function<BrowserType, WebDriver> SELENIODGRID = (browserType) -> SelenoidGridFactory.getDriver(browserType);
	
	private static Map<RemoteType, Function<BrowserType, WebDriver>> MAP = new EnumMap<>(RemoteType.class);
	
	static {
		MAP.put(RemoteType.SELENIUMGRID, SELENIUMGRID);
		MAP.put(RemoteType.SELENOIDGRID, SELENIODGRID);
	}
	
	public static WebDriver getDriver(RemoteType remoteType, BrowserType browserType) {
		return MAP.get(remoteType).apply(browserType);
	}
}
