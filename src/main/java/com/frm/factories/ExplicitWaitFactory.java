package com.frm.factories;

import java.time.Duration;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.frm.drivers.DriverManager;
import com.frm.enums.ExplicitWaitType;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {};
	
	private static Function<By, WebElement> CLICKABLE = (by) -> new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30))
		.withMessage(()->"Elemet is NOT clickable").until(ExpectedConditions.elementToBeClickable(by));
	
	private static Function<By, WebElement> VISIBILITY = (by)-> new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30))
			.withMessage(()->"Elemet is NOT visible").until(ExpectedConditions.visibilityOfElementLocated(by));
	
	private static Map<ExplicitWaitType, Function<By, WebElement>> map = new EnumMap<>(ExplicitWaitType.class);
	
	static {
		map.put(ExplicitWaitType.CLICKABLE, CLICKABLE);
		map.put(ExplicitWaitType.VISIBLE, VISIBILITY);
	}
	
	public static WebElement performExplicitWait(ExplicitWaitType statergy, By by) {
		return map.get(statergy).apply(by);
	}
}
