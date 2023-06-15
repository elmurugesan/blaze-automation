package com.frm.constants;

import com.frm.config.ConfigManager;
import com.frm.utils.DataTimeUtil;

public final class FrameworkConstant {

	private static long PAGE_LOAD_TIMEOUT = 30;
	private static long IMPLICITLY_WAIT = 30;
	private static String USER_DIRECTORY = System.getProperty("user.dir");
	private static String  EXTENT_REPORT_LOCATION = USER_DIRECTORY+"/extent-test-output";
	private static String TEST_DATA_EXCEL_PATH = USER_DIRECTORY+"/src/test/resources/testdata/NewMessageTestData.xlsx";
	
	public static long getPageLoadTimeout() {
		return PAGE_LOAD_TIMEOUT;
	}
	
	public static long getImplecitlyWait() {
		return IMPLICITLY_WAIT;
	}
	
	public static String getExtentReportLocation() {
		if(ConfigManager.getConfig().overrideExtentReportFile()) {
			return EXTENT_REPORT_LOCATION+"/"+DataTimeUtil.getCurrentDataTime()+"/index.html";
		} else {
			return EXTENT_REPORT_LOCATION+"/index.html";
		}
	}
	
	public static String getTestDataExcelPath() {
		return TEST_DATA_EXCEL_PATH;
	}
}
