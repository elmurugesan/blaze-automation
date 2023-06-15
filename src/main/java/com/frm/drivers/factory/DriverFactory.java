package com.frm.drivers.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

import com.frm.enums.BrowserType;
import com.frm.enums.RemoteType;
import com.frm.enums.RunMode;

public final class DriverFactory {

	private DriverFactory() {}
	
//	private static Function<BrowserType, WebDriver> LOCAL = (browserType)-> LocalDriverFactory.getDriver(browserType);
//	private static Function<BrowserType, WebDriver> REMOTE = (browserType)-> SeleniumGridFactory.getDriver(browserType);
//	
//	private static Map<RunMode, Function<BrowserType, WebDriver>> MAP = new EnumMap<>(RunMode.class);
//	
//	static {
//		MAP.put(RunMode.LOCAL, LOCAL);
//		MAP.put(RunMode.REMOTE, REMOTE);
//	}
//	
//	public static WebDriver getDriver(RunMode runMode, BrowserType browserType) {
//		return MAP.get(runMode).apply(browserType);
//	}
	
	private static Function<RemoteType, Function<BrowserType, WebDriver>> LOCAL = (remoteType) -> (browserType) -> LocalDriverFactory.getDriver(browserType);
	private static Function<RemoteType, Function<BrowserType, WebDriver>> REMOTE = (remoteType) -> (browserTyep) -> RemoteDriverFactory.getDriver(remoteType, browserTyep);
	
	private static Map<RunMode, Function<RemoteType, Function<BrowserType, WebDriver>>> MAP = new EnumMap<>(RunMode.class);
	
	static {
		MAP.put(RunMode.LOCAL, LOCAL);
		MAP.put(RunMode.REMOTE, REMOTE);
	}
	
	public static WebDriver getDriver(RunMode runMode, RemoteType remoteType, BrowserType browserType) {
		return MAP.get(runMode).apply(remoteType).apply(browserType);
	}
	
}
