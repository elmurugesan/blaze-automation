package com.frm.drivers;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private DriverManager() {}
	
	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return threadLocal.get();
	}
	
	public static void setDriver(WebDriver driver) {
		threadLocal.set(driver);
	}
	
	public static void remove() {
		threadLocal.remove();
	}
}
