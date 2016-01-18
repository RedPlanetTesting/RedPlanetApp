package com.androidMobile.scripts;

import java.util.Calendar;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.androidMobile.scripts.testObjects.AccountPageLocators;
import com.androidMobile.scripts.testObjects.HomePageLocators;
import com.androidMobile.scripts.testObjects.InHousePhoneLocators;
import com.androidMobile.workflows.GeneralHelper;
import com.androidMobile.workflows.LoginHelper;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class RP_015_TestChatWithFrontDesk  extends LoginHelper{
	ExcelReader xlsChatFrontDesk = new ExcelReader(configProps.getProperty("TestDataForAndroid"),
			"RP_ANDR_015");
		@Test(dataProvider = "testData",groups={"Android"})
  public void testChatWithFrontDesk(String email,String password,String chatName,String chatAdminEmail, 
		 String chatAdminPassword,String FirstMsg, String description) throws Throwable {
			Calendar cal = Calendar.getInstance();
			String chatUrl = xlsChatFrontDesk.getCellValue("chatURL", "Value");
			boolean res = false;
			boolean sendMsg = false;
	  try{
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name, description);
		  String testMessage = "Test message "+cal.getTime();
		  System.out.println("Test message "+testMessage);
		  handleRateAppPopUp();
		  navigateToMyAccount();	
		  handleRateAppPopUp();
		  click(AccountPageLocators.logInButton, "logInButton");
		  login(email, password);
		  handleRateAppPopUp();
		  navigateToHome();
		  handleRateAppPopUp();
		  //handelWelcomeDashboardDialog();
		  waitForElementPresent(HomePageLocators.chatWithFrontDeskButton, "chatWithFrontDeskButton");
		  click(HomePageLocators.chatWithFrontDeskButton, "chatWithFrontDeskButton");
			if(isElementDisplayed(InHousePhoneLocators.textAreaForChat2)) {
				  click(InHousePhoneLocators.textAreaForChat2, "textAreaForChat2");
				  type(InHousePhoneLocators.textAreaForChat2, testMessage, "textAreaForChat2");
				  waitForElementPresent(InHousePhoneLocators.sendButtonForChat2, "sendButtonForChat2");
				  sendMsg =  click(InHousePhoneLocators.sendButtonForChat2, "sendButtonForChat2");
			}else{
				waitForElementPresent(InHousePhoneLocators.textAreaForChat, "textAreaForChat");
			  click(InHousePhoneLocators.textAreaForChat, "textInputField");
			  type(InHousePhoneLocators.textAreaForChat, testMessage, "textInputField");
			  waitForElementPresent(InHousePhoneLocators.textAreaForChat, "textAreaForChat");
			  
			  //click(InHousePhoneLocators.ChatNameInput, "ChatNameInput");
			  //type(InHousePhoneLocators.ChatNameInput, chatName, "ChatNameInput");
			  sendMsg = click(InHousePhoneLocators.sendButtonForChat, "sendButtonForChat");
			}
			 // String replyMsg = GeneralHelper.FrontDeskChat(chatUrl, chatAdminEmail, chatAdminPassword, testMessage, FirstMsg);
			  if(/*replyMsg!= null*/sendMsg){
				  driver.navigate().back();
				  if(isElementDisplayed(HomePageLocators.chatWithFrontDeskButton)){
					  click(HomePageLocators.chatWithFrontDeskButton, "chatWithFrontDeskButton");
				  }
				  res = AndroidDriver2.getPageSource().contains(/*replyMsg*/testMessage);
			  	}
				  System.out.println("resutl "+res);
				  if(res){
					  Reporter.SuccessReport(description, " Successful");
					  System.out.println("successfully calling Front Desk ");
				  }else{
					  Reporter.failureReport(description, " Failed");
				  }
	  }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("LogIn", "Failed");
		}
  }
  
  @DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xlsChatFrontDesk.getCellValue("ValidCredentials", "Value"),xlsChatFrontDesk.getCellValue("ValidCredentials", "password"),
	    			xlsChatFrontDesk.getCellValue("chatName", "Value"),xlsChatFrontDesk.getCellValue("ChatLoginID", "Value"),
	    			xlsChatFrontDesk.getCellValue("ChatLoginID", "password"),xlsChatFrontDesk.getCellValue("FirstMsg", "Value"),
	    			"Validate chat with FrontDesk"}};
	}
}

