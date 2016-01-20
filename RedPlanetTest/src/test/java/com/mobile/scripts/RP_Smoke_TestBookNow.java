package com.mobile.scripts;


import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.mobile.scripts.testObjects.HomePageLocators;
import com.mobile.workflows.HomePageHelper;

public class RP_Smoke_TestBookNow extends HomePageHelper{
		/*
		 * Verify Book Now Screen
		 */
	@Test( groups = { "Mobile" })
	  public void smokeTestBookNow() throws Throwable{
	 try{		  
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name,"Validate Book Now Page");
		  handleSplashDialog();		  
		  waitForElementPresent(HomePageLocators.mainMenuIcon,"mainMenuIcon");
		  navigateToBookNow();
		  waitForElementPresent(HomePageLocators.chooseLocation,"Validate Choose Location Icon on Home Page");
		  isElementPresent(HomePageLocators.checkInLink,"Validate Check-In Link on Home Page");
		  isElementPresent(HomePageLocators.checkOutLink,"Validate Check-Out Link on Home Page");
		  isElementPresent(HomePageLocators.searchButton,"Validate Search Button on Home Page");		  
		  
	 }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("Validate Book Now Page", "Failed with exception");
	 }
	}	
	
}
		
		



