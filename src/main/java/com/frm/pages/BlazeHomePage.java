package com.frm.pages;

import com.frm.enums.ExplicitWaitType;
import com.frm.utils.DynamicXPathUtil;
	
public final class BlazeHomePage extends BasePage {
	
	
	private static String topMenuItem = "//a[contains(text(),'%s')]";
	
	public String getHomePageTitle() {
		return getTitle();
	}
	
	public NewMessagePage clickContactMenu() {
		click(DynamicXPathUtil.getDynamicXPath(topMenuItem, "Contact"), ExplicitWaitType.CLICKABLE);
		return new NewMessagePage();
	}

}
