package com.frm.test;

import org.testng.annotations.Test;

import com.frm.annotations.FrameworkAnnotaion;
import com.frm.assertj.StringAssert;
import com.frm.enums.CatagoryType;
import com.frm.enums.LogType;
import com.frm.pages.BlazeHomePage;
import com.frm.reports.FrameworkLogger;

public final class BlazeHomePageTest extends BaseTest {

	private BlazeHomePageTest() {}
	
	@FrameworkAnnotaion(authors = {"Naren"}, catagories = {CatagoryType.SMOKE})
	@Test
	public static void testTitle() {
		String title = new BlazeHomePage().getHomePageTitle();
		
		StringAssert
		.assertThat(title)
		.isStringContainsIngoringCase("store");
		
		FrameworkLogger.log(LogType.PASS_EXTENT_AND_CONSOLE, "BlazeHomePage title Validated - passed", true);
	}

}
