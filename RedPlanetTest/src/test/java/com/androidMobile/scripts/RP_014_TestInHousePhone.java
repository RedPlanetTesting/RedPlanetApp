package com.androidMobile.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.androidMobile.scripts.testObjects.AccountPageLocators;
import com.androidMobile.scripts.testObjects.HomePageLocators;
import com.androidMobile.scripts.testObjects.InHousePhoneLocators;
import com.androidMobile.workflows.LoginHelper;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class RP_014_TestInHousePhone  extends LoginHelper{
	ExcelReader xlsInHouse = new ExcelReader(configProps.getProperty("TestDataForAndroid"),
			"RP_ANDR_014");
		@Test(dataProvider = "testData",groups={"Android"})
  public void testInHousePhone(String dialNumber,
		  String email,String password,boolean status, String description) throws Throwable {
	  try{
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name, description);			  
		  char[] phNo = dialNumber.toCharArray(); 
		  handleRateAppPopUp();
		  navigateToMyAccount();
		  handleRateAppPopUp();
		  //verify user already loggedIn, if yes sign out
		  click(AccountPageLocators.logInButton, "logInButton");
		  login(email, password);
		  handleRateAppPopUp();
		  navigateToHome();
		  handleRateAppPopUp();
		  //handelWelcomeDashboardDialog();
		  navigateToHome();
		  handleRateAppPopUp();
		  waitForElementPresent(HomePageLocators.chatWithFrontDeskButton, "chatWithFrontDeskButton");
		  click(HomePageLocators.inHousePhoneButton, "inHousePhoneButton");
		  handleRateAppPopUp();
		  Thread.sleep(2000);
		  if(status){
			  int count = 0;
			  while(count>=3){
			  System.out.println("Dial Number "+phNo+" no of digits "+phNo.length);
				 for(char digi : phNo){
				  waitForElementPresent(By.xpath(InHousePhoneLocators.noButtonToDial.replace("#", Character.toString(digi))),
						  "noButtonToDial "+digi);
				  click(By.xpath(InHousePhoneLocators.noButtonToDial.replace("#", Character.toString(digi))),
						  "noButtonToDial"+digi);
				 }
				  waitForElementPresent(InHousePhoneLocators.callIcon, "callIcon");
				  click(InHousePhoneLocators.callIcon, "callIcon");
				 if(isElementDisplayed(InHousePhoneLocators.callingRoomLabel)){
				  Reporter.SuccessReport(description, " Successful");	
				  break;
			  }else{
				  if(description.contains("invalid")){
					  System.out.println("In Invalid room no block");
					 click(InHousePhoneLocators.callIcon, "callIcon");
				  if(!(isElementDisplayed(InHousePhoneLocators.callingRoomLabel))){
					  Reporter.SuccessReport(description, " Successful");
					  System.out.println("successfully failed to call Invalid room");
				  }
			  }
				  if(count == 3){
					  Reporter.failureReport(description, " Failed");
					  break;
				  }
				  count++;
				  AndroidDriver2.navigate().back();
			  }
			 }
		}else if(description.contains("FrontDesk")){
				  System.out.println("In call Front Desk block");
				  int count=0;
				  while(count>=3){
					  waitForElementPresent(InHousePhoneLocators.frontDeskButtonToCall, "frontDeskButtonToCall");
					  click(InHousePhoneLocators.frontDeskButtonToCall, "frontDeskButtonToCall");
					  if((isElementDisplayed(InHousePhoneLocators.callingRoomLabel))){
					  Reporter.SuccessReport(description, " Successful");
					 
					  System.out.println("successfully calling Front Desk ");
					  break;
				  }else{
					  if(count == 3){
						  Reporter.failureReport(description, " Failed");
						  break;
					  }
					  count++;
					  AndroidDriver2.navigate().back();
					  Thread.sleep(2000);
				  }
				
				  }
			  }
	  }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("LogIn", "Failed");
		}
  }
  
  @DataProvider(name="testData")
	public Object[][] createdata1() {
	    return (Object[][]) new Object[][] { 
	    		{xlsInHouse.getCellValue("ValidRoomNo", "Value"),
	    			xlsInHouse.getCellValue("ValidCredentials", "Value"),
	    			xlsInHouse.getCellValue("ValidCredentials", "password"),true,"Validate InHousePhone to valid room number"},
	    		{xlsInHouse.getCellValue("InvalidRoomNo", "Value"),
	    				xlsInHouse.getCellValue("ValidCredentials", "Value"),xlsInHouse.getCellValue("ValidCredentials", "password"),
		    			true,"Validate InHousePhone to invalid room number"},
	    		{xlsInHouse.getCellValue("InvalidRoomNo", "Value"),
		    				xlsInHouse.getCellValue("ValidCredentials", "Value"),xlsInHouse.getCellValue("ValidCredentials", "password"),
			    			false,"Validate InHousePhone to FrontDesk"}};
	}
}
