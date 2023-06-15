package com.frm.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.frm.annotations.FrameworkAnnotaion;
import com.frm.assertj.StringAssert;
import com.frm.enums.CatagoryType;
import com.frm.pages.BlazeHomePage;
import com.frm.pages.NewMessagePage;
import com.frm.testdata.NewMessage;
import com.frm.utils.ExcelUtil;

public class BlazeNewMessagePageTest extends BaseTest {

	@FrameworkAnnotaion(authors = {"Elaiyaraja"}, catagories = {CatagoryType.REGRESSION})
	@Test(dataProvider = "TestDataProvider")
	public void testNewMessageSubmission(NewMessage message) {
		String alertMessage = new BlazeHomePage()
		.clickContactMenu()
		.enterContactEmail(message.getEmail())
		.enterContactName(message.getName())
		.enterMessage(message.getMessage())
		.clickSendMessageBtn()
		.getNewMessageSubmissionAlertMessage();
		System.out.println("Alert Message:: "+alertMessage);
		
		StringAssert
		.assertThat(alertMessage)
		.isStringContainsIngoringCase("Thanks for the message!!");
		
		new NewMessagePage().submitNewMessageAlert();
		
	}
		
	@DataProvider(name = "TestDataProvider", parallel = true)
	public Object[] getData() {
		return ExcelUtil.getTestData().toArray();
	}
}
