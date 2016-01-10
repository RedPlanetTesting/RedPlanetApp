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

public class RP_Smoke_TestMyAccount extends HomePageHelper{
		/*
		 * Verify Home Main Menu
		 */
	@Test( groups = { "Android" })
	  public void smokeTestMyAccount() throws Throwable{
	 try{		  
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name,"Validate My Account Page");
		  handleRateAppPopUp();
		  handleSplashDialog();		  
		  Thread.sleep(2000);
		  waitForElementPresent(HomePageLocators.mainMenuIcon,"mainMenuIcon");
		  navigateToMyAccount();
		  handleRateAppPopUp();		  
		  verifyElementDisplayed(AccountPageLocators.accountScreenTitle,"Validate Account Screen Title");
		  verifyElementDisplayed(AccountPageLocators.faceBookButton,"Validate Facebook Button");
		  verifyElementDisplayed(AccountPageLocators.signUpButton,"Validate Sign Up Button");
		  verifyElementDisplayed(AccountPageLocators.logInButton,"Validate Login Button Button");
		  		  
	 }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("Validate My Account page", "Failed with exception");
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
		
		



