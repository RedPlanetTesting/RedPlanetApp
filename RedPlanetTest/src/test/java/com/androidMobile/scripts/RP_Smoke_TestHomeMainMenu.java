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

public class RP_Smoke_TestHomeMainMenu extends HomePageHelper{
		/*
		 * Verify Home Main Menu
		 */
	@Test( groups = { "Android" })
	  public void smokeTestHomeMainMenu() throws Throwable{
	 try{		  
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name,"Validate Home Main Menu");
		  handleRateAppPopUp();
		  handleSplashDialog();		  
		  Thread.sleep(2000);
		  waitForElementPresent(HomePageLocators.mainMenuIcon,"mainMenuIcon");
		  verifyElementDisplayed(HomePageLocators.mainMenuIcon,"Validate Main Menu Icon on Home Page");		  
		  click(HomePageLocators.mainMenuIcon,"mainMenuIcon");		  
		 // verifyElementDisplayed(HomePageLocators.homeMenuLink,"Validate Home Link in Main Menu");
		  verifyElementDisplayed(HomePageLocators.bookNowMenuLink,"Validate Book Now Link in Main Menu");
		  verifyElementDisplayed(HomePageLocators.myAccountMenuLink,"Validate My Account Link in Main Menu");
		  verifyElementDisplayed(HomePageLocators.reirieveBookingsMenuLink,"Validate Retrieve Bookings Link in Main Menu");
		  verifyElementDisplayed(HomePageLocators.aboutUsMenuLink,"Validate About Us Link in Main Menu");
		  verifyElementDisplayed(HomePageLocators.helpMenuLink,"Validate Help & Info Link in Main Menu");
		  
	 }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("Validate Home Page Main Menu", "Failed with exception");
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
		
		



