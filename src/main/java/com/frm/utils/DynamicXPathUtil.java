package com.frm.utils;

import org.openqa.selenium.By;

public final class DynamicXPathUtil {
	
	private DynamicXPathUtil() {}
	
	public static By getDynamicXPath(String xpath, String value) {
		String dynamicXpath = String.format(xpath, value);
		return By.xpath(dynamicXpath);
	}

}
