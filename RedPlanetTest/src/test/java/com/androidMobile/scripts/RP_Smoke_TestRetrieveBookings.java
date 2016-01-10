package com.androidMobile.scripts;


import org.testng.annotations.Test;

import com.androidMobile.scripts.testObjects.HomePageLocators;
import com.androidMobile.scripts.testObjects.RetrieveBookingLocators;
import com.androidMobile.workflows.HomePageHelper;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class RP_Smoke_TestRetrieveBookings extends HomePageHelper{
		/*
		 * Verify Retrieve Bookings Screen
		 */
	@Test( groups = { "Android" })
	  public void smokeTestRetrieveBookings() throws Throwable{
	 try{		  
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name,"Validate Retrieve Bookings Page");
		  handleRateAppPopUp();
		  handleSplashDialog();		  
		  Thread.sleep(2000);
		  waitForElementPresent(HomePageLocators.mainMenuIcon,"mainMenuIcon");
		  navigateToReirieveBookings();
		  handleRateAppPopUp();		  
		  verifyElementDisplayed(RetrieveBookingLocators.retrieveBookingsScreenTitle,"Validate Retrieve Bookings Screen Title");
		  verifyElementDisplayed(RetrieveBookingLocators.emailInput,"Validate Email Input Field");
		  verifyElementDisplayed(RetrieveBookingLocators.bookingCodeInput,"Validate Booking Code Input Field");
		  verifyElementDisplayed(RetrieveBookingLocators.searchButton,"Validate Search Button");
		  		  
	 }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("Validate Retrieve Bookings Page", "Failed with exception");
	 }
	}	

	


}
		
		



