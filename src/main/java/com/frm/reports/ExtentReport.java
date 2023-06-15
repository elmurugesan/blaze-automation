package com.frm.reports;

import java.util.Arrays;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.frm.constants.FrameworkConstant;
import com.frm.enums.CatagoryType;

public final class ExtentReport {

	private ExtentReport() {}
	
	private static ExtentReports extent;
	public static void initReport() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstant.getExtentReportLocation());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Blaze Automation");
			spark.config().setReportName("Blaze Automation Report");
		}
	}
	
	public static void createTest(String testName) {
		ExtentManager.setExtentTest(extent.createTest(testName));
	}
	
	public static void flushReport() {
		if(Objects.nonNull(extent)) {
			extent.flush();
			ExtentManager.setExtentTest(null);
		}
	}
	
	public static void addAuthors(String[] authors) {
		Arrays.asList(authors).stream().forEach((author) -> ExtentManager.getExtentTest().assignAuthor(author));
	}
	
	public static void addCatagories(CatagoryType[] catagories) {
		Arrays.asList(catagories).stream().forEach((catagory) -> ExtentManager.getExtentTest().assignCategory(catagory.toString()));
	}
}
