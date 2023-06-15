package com.frm.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.frm.annotations.FrameworkAnnotaion;
import com.frm.enums.LogType;
import com.frm.reports.ExtentReport;
import com.frm.reports.FrameworkLogger;

public class TestListener implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotaion.class).authors());
		ExtentReport.addCatagories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotaion.class).catagories());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		FrameworkLogger.log(LogType.PASS_EXTENT_AND_CONSOLE, result.getMethod().getMethodName()+" is passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		FrameworkLogger.log(LogType.FAIL_EXTENT_AND_CONSOLE, result.getMethod().getMethodName()+" is failed", true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		FrameworkLogger.log(LogType.SKIP_EXTENT_AND_CONSOLE, result.getMethod().getMethodName()+" is skipped", true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
