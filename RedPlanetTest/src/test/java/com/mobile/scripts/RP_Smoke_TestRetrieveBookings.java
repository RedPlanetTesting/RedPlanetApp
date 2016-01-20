package com.mobile.scripts;


import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.mobile.scripts.testObjects.HomePageLocators;
import com.mobile.scripts.testObjects.RetrieveBookingLocators;
import com.mobile.workflows.HomePageHelper;

public class RP_Smoke_TestRetrieveBookings extends HomePageHelper{
		/*
		 * Verify Retrieve Bookings Screen
		 */
	@Test(groups = { "Mobile" })
	  public void smokeTestRetrieveBookings() throws Throwable{
	 try{		  
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name,"Validate Retrieve Bookings Page");
		  handleSplashDialog();		  
		  Thread.sleep(2000);
		  waitForElementPresent(HomePageLocators.mainMenuIcon,"mainMenuIcon");
		  navigateToReirieveBooking();
		  isElementPresent(RetrieveBookingLocators.retrieveBookingsScreenTitle,"Validate Retrieve Bookings Screen Title");
		  isElementPresent(RetrieveBookingLocators.emailInput,"Validate Email Input Field");
		  isElementPresent(RetrieveBookingLocators.bookingCodeInput,"Validate Booking Code Input Field");
		  isElementPresent(RetrieveBookingLocators.submitButton,"Validate Search Button");
		  		  
	 }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("Validate Retrieve Bookings Page", "Failed with exception");
	 }
	}	
	
}
		
		



