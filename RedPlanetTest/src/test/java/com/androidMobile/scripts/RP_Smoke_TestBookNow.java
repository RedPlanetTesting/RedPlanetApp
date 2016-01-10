package com.androidMobile.scripts;


import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.androidMobile.scripts.testObjects.AboutUsLocators;
import com.androidMobile.scripts.testObjects.AccountPageLocators;
import com.androidMobile.scripts.testObjects.HomePageLocators;
import com.androidMobile.workflows.HomePageHelper;
import com.androidMobile.workflows.LoginHelper;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class RP_Smoke_TestBookNow extends HomePageHelper{
		/*
		 * Verify Home Main Menu
		 */
	@Test( groups = { "Android" })
	  public void smokeTestBookNow() throws Throwable{
	 try{		  
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name,"Validate Book Now Page");
		  handleRateAppPopUp();
		  handleSplashDialog();		  
		  Thread.sleep(2000);
		  waitForElementPresent(HomePageLocators.mainMenuIcon,"mainMenuIcon");
		  navigateToBookNow();
		  handleRateAppPopUp();		  
		  verifyElementDisplayed(HomePageLocators.chooseLocation,"Validate Choose Location Icon on Home Page");
		  verifyElementDisplayed(HomePageLocators.checkInLink,"Validate Check-In Link on Home Page");
		  verifyElementDisplayed(HomePageLocators.checkOutLink,"Validate Check-Out Link on Home Page");
		  verifyElementDisplayed(HomePageLocators.searchButton,"Validate Search Button on Home Page");		  
		  
	 }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("Validate Book Now Page", "Failed with exception");
	 }
	}	
	
	public void verifyElementDisplayed(By by, String Description) throws Throwable{
		
		if(isElementDisplayed(by)){
			  Reporter.SuccessReport(Description, "Successful");
		  }else{
			  Reporter.failureReport(Description, "Failed");
		  }
		
	}


}
		
		



