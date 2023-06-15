package com.frm.drivers.remote.docker.selenoid;

import java.util.HashMap;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.frm.config.ConfigManager;

public final class SelenoidGridFirefoxManager {

	private SelenoidGridFirefoxManager() {}
	
	public static RemoteWebDriver getDriver() {
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("browserVersion", ConfigManager.getConfig().browserVersion());
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Test badge...");
		map.put("sessionTimeout", "15m");
//		map.put("env", new ArrayList<String>() {{add("TZ=UTC");}});
//		map.put("labels", new HashMap<String, Object>() {{put("manual", "true");}});
//		map.put("enableVideo", true);
//		map.put("videoName", "Selenoid_Test_Amazon.mp4");
		map.put("enableVNC", true);
		options.setCapability("selenoid:options", map);
		return new RemoteWebDriver(ConfigManager.getConfig().seleniumGridURL(), options);
	}
}
