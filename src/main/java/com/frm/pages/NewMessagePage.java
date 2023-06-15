package com.frm.pages;

import org.openqa.selenium.By;

import com.frm.enums.ExplicitWaitType;
import com.frm.utils.DynamicXPathUtil;

public final class NewMessagePage extends BasePage {

	private static String newMessageInputBox = "//label[text()='%s']/following-sibling::input";
	private static By sendMessageBtn = By.xpath("//button[text()='Send message']");
	private static By messageTextArea = By.xpath("//label[text()='Message:']/following-sibling::textarea");
	
	
	public NewMessagePage enterContactEmail(String emailId) {
		sendKeys(DynamicXPathUtil.getDynamicXPath(newMessageInputBox, "Contact Email:"), emailId, ExplicitWaitType.VISIBLE);
		return this;
	}
	
	public NewMessagePage enterContactName(String contactName) {
		sendKeys(DynamicXPathUtil.getDynamicXPath(newMessageInputBox, "Contact Name:"), contactName, ExplicitWaitType.VISIBLE);
		return this;
	}
	
	public NewMessagePage enterMessage(String message) {
		sendKeys(messageTextArea, message, ExplicitWaitType.VISIBLE);
		return this;
	}
	
	public NewMessagePage clickSendMessageBtn() {
		clickSendMessageBtn(sendMessageBtn, ExplicitWaitType.CLICKABLE);
		return this;
	}
	
	public String getNewMessageSubmissionAlertMessage() {
		return getAlertMessage();
	}
	
	//Thanks for the message!!
	public BlazeHomePage submitNewMessageAlert() {
		acceptAlert();
		return new BlazeHomePage();
	}
	 
}
