package com.frm.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> tlTest = new ThreadLocal<>();
	
	static void setExtentTest(ExtentTest test) {
		tlTest.set(test);
	}
	
	static ExtentTest getExtentTest() {
		return tlTest.get();
	}
	
	static void unload() {
		tlTest.remove();
	}

}
