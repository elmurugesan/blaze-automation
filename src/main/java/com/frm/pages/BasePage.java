package com.frm.pages;

import org.openqa.selenium.By;

import com.frm.drivers.DriverManager;
import com.frm.enums.ExplicitWaitType;
import com.frm.enums.LogType;
import com.frm.factories.ExplicitWaitFactory;
import com.frm.reports.FrameworkLogger;

public class BasePage {

	
	protected void clickSendMessageBtn(By by, ExplicitWaitType statergy) {
		ExplicitWaitFactory.performExplicitWait(statergy, by).click();
		FrameworkLogger.log(LogType.PASS_EXTENT_AND_CONSOLE, by+" Click operation passed", false);
	}
	
	protected void click(By by, ExplicitWaitType statergy) {
		ExplicitWaitFactory.performExplicitWait(statergy, by).click();
		FrameworkLogger.log(LogType.PASS_EXTENT_AND_CONSOLE, by+" Click operation passed", true);
	}
	
	protected void sendKeys(By by, String value, ExplicitWaitType statergy) {
		ExplicitWaitFactory.performExplicitWait(statergy, by).sendKeys(value);
		FrameworkLogger.log(LogType.PASS_EXTENT_AND_CONSOLE, value+" entered on "+by, true);
	}
	
	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected void acceptAlert() {
		DriverManager.getDriver().switchTo().alert().accept();
		FrameworkLogger.log(LogType.PASS_EXTENT_AND_CONSOLE, "Alert Accepted step - passed", true);
	}
	
	protected void dismissAlert() {
		DriverManager.getDriver().switchTo().alert().dismiss();
		FrameworkLogger.log(LogType.PASS_EXTENT_AND_CONSOLE, "Alert dismissed step - passed", true);
	}
	
	protected String getAlertMessage() {
		return DriverManager.getDriver().switchTo().alert().getText();
	}
	
}
