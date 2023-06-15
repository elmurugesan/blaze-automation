package com.frm.drivers;

import java.time.Duration;
import java.util.Objects;

import com.frm.config.ConfigManager;
import com.frm.constants.FrameworkConstant;
import com.frm.drivers.factory.DriverFactory;

public final class Driver {

	private Driver() {}
	
	public static void initDriver() {
		if(Objects.isNull(DriverManager.getDriver())) {
			System.out.println(ConfigManager.getConfig().browserName());
			System.out.println(ConfigManager.getConfig().runMode());
			System.out.println(ConfigManager.getConfig().remoteType());
			DriverManager.setDriver(DriverFactory.getDriver(ConfigManager.getConfig().runMode(), ConfigManager.getConfig().remoteType(), ConfigManager.getConfig().browserName()));
//			DriverManager.setDriver(DriverFactory.getDriver(ConfigManager.getConfig().runMode(), ConfigManager.getConfig().browserName()));
			DriverManager.getDriver().get(ConfigManager.getConfig().url());
			System.out.println(ConfigManager.getConfig().browserName());
			System.out.println(ConfigManager.getConfig().runMode());
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameworkConstant.getPageLoadTimeout()));
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstant.getImplecitlyWait()));
			
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.setDriver(null);
		}
			
	}
}
