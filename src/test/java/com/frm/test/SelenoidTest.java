package com.frm.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SelenoidTest {

	@Test
	public void testSeleniodSetup() throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserVersion", "113.0");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Test badge...");
		map.put("sessionTimeout", "15m");
//		map.put("env", new ArrayList<String>() {{add("TZ=UTC");}});
//		map.put("labels", new HashMap<String, Object>() {{put("manual", "true");}});
//		map.put("enableVideo", true);
//		map.put("videoName", "Selenoid_Test_Amazon.mp4");
		map.put("enableVNC", true);
		options.setCapability("selenoid:options", map);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		
		driver.get("https://google.co.in");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Amazon.in", Keys.ENTER);
		Thread.sleep(10000);
		driver.quit();
	}
}
