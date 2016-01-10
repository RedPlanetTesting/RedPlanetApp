package com.androidMobile.scripts;


import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.androidMobile.scripts.testObjects.AboutUsLocators;
import com.androidMobile.scripts.testObjects.AccountPageLocators;
import com.androidMobile.scripts.testObjects.HomePageLocators;
import com.androidMobile.scripts.testObjects.RetrieveBookingLocators;
import com.androidMobile.workflows.HomePageHelper;
import com.androidMobile.workflows.LoginHelper;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class RP_Smoke_TestAboutUs extends HomePageHelper{
		/*
		 * Verify About Us Screen
		 */
	@Test( groups = { "Android" })
	  public void smokeTestAboutUs() throws Throwable{
	 try{		  
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name,"Validate About Us Page");
		  handleRateAppPopUp();
		  handleSplashDialog();		  
		  Thread.sleep(2000);
		  waitForElementPresent(HomePageLocators.mainMenuIcon,"mainMenuIcon");
		  navigateToAboutUs();
		  handleRateAppPopUp();		  
		  verifyElementDisplayed(AboutUsLocators.AboutUsTitle,"Validate About Us Screen Title");
		  verifyElementDisplayed(AboutUsLocators.facebookImage,"Validate Facebook Image");
		  verifyElementDisplayed(AboutUsLocators.twitterImage,"Validate Twitter Image");
		  verifyElementDisplayed(AboutUsLocators.googleImage,"Validate GooglePlus Image");
		  verifyElementDisplayed(AboutUsLocators.instagramImage,"Validate Instagram Image");
		  verifyElementDisplayed(AboutUsLocators.pintrestImage,"Validate Pintrest Image");
		  verifyElementDisplayed(AboutUsLocators.flipboardImage,"Validate Flipboard Image");
		  verifyElementDisplayed(AboutUsLocators.vineImage,"Validate Vine Image");
		  		  
	 }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("Validate About Us Page", "Failed with exception");
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
		
		



