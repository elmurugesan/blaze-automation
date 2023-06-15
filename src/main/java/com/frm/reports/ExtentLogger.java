package com.frm.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.frm.config.ConfigManager;
import com.frm.utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {}
	
	static void pass(String message, boolean isScreenshotNeeded) {
		if(ConfigManager.getConfig().attachScreenshotForPass() && isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
		} else {
			ExtentManager.getExtentTest().pass(message);
		}
	}
	
	static void fail(String message, boolean isScreenshotNeeded) {
		if(ConfigManager.getConfig().attachScreenshotForFail() && isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
		} else {
			ExtentManager.getExtentTest().fail(message);
		}
	}
	
	static void skip(String message, boolean isScreenshotNeeded) {
		if(ConfigManager.getConfig().attachScreenshotForSkip() && isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
		} else {
			ExtentManager.getExtentTest().skip(message);
		}
	}
	
	static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}
}
