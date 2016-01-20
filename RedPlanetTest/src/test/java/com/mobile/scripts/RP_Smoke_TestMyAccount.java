package com.mobile.scripts;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.mobile.scripts.testObjects.AccountPageLocators;
import com.mobile.scripts.testObjects.HomePageLocators;
import com.mobile.workflows.HomePageHelper;
import com.mobile.workflows.LoginHelper;

public class RP_Smoke_TestMyAccount extends LoginHelper{
		
	ExcelReader xlsRetrive = new ExcelReader(configProps.getProperty("TestData"),
			"RP_019");
		/*
		 * Verify My Account Screen
		 */
	@Test(dataProvider = "testData", groups = { "Mobile" })
	  public void smokeTestMyAccount(String emailID, String password) throws Throwable{
	 try{		  
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name,"Validate My Account Page");
		  handleSplashDialog();		  
		  Thread.sleep(2000);
		  waitForElementPresent(HomePageLocators.mainMenuIcon,"mainMenuIcon");
		  navigateToMyAccount();
		  click(AccountPageLocators.logInButton,"logInButton");
		  login(emailID,password);
		  waitForElementPresent(AccountPageLocators.accountScreenTitle,"Verify Account Screen Title");
		  isElementPresent(AccountPageLocators.EditLink,"Verify Edit Link");
		  isElementPresent(AccountPageLocators.userName,"Verify Name");
		  isElementPresent(AccountPageLocators.userNationality,"Verify Nationality");
		  isElementPresent(AccountPageLocators.userPassport,"Verify Passport");
		  isElementPresent(AccountPageLocators.userResidence,"Verify Residence");
		  isElementPresent(AccountPageLocators.userPhone,"Verify Phone");
		  isElementPresent(AccountPageLocators.upcomingBookings,"Verify Upcoming Bookings");
		  isElementPresent(AccountPageLocators.signOutButton,"Verify SignOut Button");
		  		  
	 }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("Validate My Account page", "Failed with exception");
	 }
	}	

	@DataProvider(name="testData")
	public Object[][] createdata1() {
  		return (Object[][]) new Object[][] { 
			  {xlsRetrive.getCellValue("ValidCredentials", "Value"),xlsRetrive.getCellValue("ValidCredentials", "password")}};
	}
}
		
		



