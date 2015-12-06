package com.mobile.scripts;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.mobile.scripts.testObjects.BookPageLocators;
import com.mobile.scripts.testObjects.HomePageLocators;
import com.mobile.scripts.testObjects.PickRoomPageLocators;
import com.mobile.workflows.BookingPageHelper;
import com.mobile.workflows.LoginHelper;

public class RP_004_GuestBookingFromHome extends LoginHelper{
	ExcelReader xlsBook = new ExcelReader(configProps.getProperty("TestData"),
			"RP_004");
  @Test(dataProvider = "testData")
  public void testBookingAsGuestFromHome(String country, String city,
		 String fName,String lName,String email,
		 String cardHolder,String cardNum,String expMonth, String expYear, String cvv,
		 boolean status,String description) throws Throwable{
	  	 System.out.println(country +" "+city);
	  	String bookingCode = null;	  
	try{
		 TestEngine.testDescription.put(HtmlReportSupport.tc_name, 
				description);	
		 handelSplashScreen();
		 //handleSplashDialog();
		 Thread.sleep(3000);
		 navigateToMyAccount();
		 validateUserLogin();
		 navigateToBookNow();
	     selectDestination(country, city);
		 Thread.sleep(3000);
		 waitForElementPresent(HomePageLocators.searchButton, "searchButton");
		 click(HomePageLocators.searchButton, "searchButton");
		 Thread.sleep(10000);		 
		 if(isElementDisplayed(PickRoomPageLocators.pickRoomPage)){
			 Reporter.SuccessReport("Search for Hotels", "Successful");
		 }else
			 Reporter.failureReport("Search for Hotels", "Failed");
		 click(PickRoomPageLocators.bookNowButton, "bookNowButton");
		 Thread.sleep(5000);
		 isElementDisplayed(BookPageLocators.contiuneButton);	 
			 click(BookPageLocators.contiuneButton, "contiuneButton");
			 Thread.sleep(2000);
			 BookingPageHelper.populateGuestDetails("", fName, lName, email, "");
			 BookingPageHelper.populatePaymentDetails(cardHolder, cardNum, expMonth, expYear, cvv);
		 Thread.sleep(15000);
		 if(!status){
			if(isElementDisplayed(BookPageLocators.errorPayment)){
				String err = driver.findElement(BookPageLocators.inValidError).getText();
				System.out.println("+++++++++++++++++++"+err+"+++++++++++");
				 Reporter.SuccessReport("Verify error with invalid payment details ",
						 "Successfully verified error for invalid payment details"+err);
			}
		 }else{
			 waitForElementPresent(BookPageLocators.doneButton, "doneButton");
			 if(isElementDisplayed(BookPageLocators.bookingCode)){
				  bookingCode = driver.findElement(BookPageLocators.bookingCode).getText().trim();
				 Reporter.SuccessReport(description, "Successful"+" Booking code is: "+bookingCode);
			 }else if(isElementDisplayed(BookPageLocators.errorPayment)){
				 Reporter.failureReport(description, "Failed to process payment, error message is: "
						 + driver.findElement(BookPageLocators.errorPayment).getText());
				 click(BookPageLocators.okButton, "okButton");
			 }else			 
				 Reporter.failureReport(description, "Failed");
			 	click(BookPageLocators.doneButton, "doneButton");
		 }
	}catch(Exception e) {
		e.printStackTrace();
		Reporter.failureReport(description, "Failed with exception");
	}	
  }

  	@DataProvider(name="testData")
	public Object[][] createdata1() {
  		return (Object[][]) new Object[][] {
  			{xlsBook.getCellValue("country", "Value"),xlsBook.getCellValue("city", "Value"),
		  	xlsBook.getCellValue("fName", "Value"),xlsBook.getCellValue("lName", "Value"),
		  	xlsBook.getCellValue("email", "Value"),"","",xlsBook.getCellValue("expirationmonth", "Value"),
		  	xlsBook.getCellValue("expirationyear", "Value"), xlsBook.getCellValue("cvv", "Value"),
		  	false, "Validate Hotel Booking as a Guest with blank payment details"}, 
			{xlsBook.getCellValue("country", "Value"),xlsBook.getCellValue("city", "Value"),
	  			xlsBook.getCellValue("fName", "Value"),xlsBook.getCellValue("lName", "Value"),
	  			xlsBook.getCellValue("email", "Value"),xlsBook.getCellValue("invalidCardHolder", "Value"),
	  			xlsBook.getCellValue("invalidCardNum", "Value"),xlsBook.getCellValue("expirationmonth", "Value"),
	  			xlsBook.getCellValue("expirationyear", "Value"),xlsBook.getCellValue("cvv", "Value"),
	  			false, "Validate Hotel Booking as a Guest with invalid payment details"},
  			{xlsBook.getCellValue("country", "Value"),xlsBook.getCellValue("city", "Value"),
  				xlsBook.getCellValue("fName", "Value"),xlsBook.getCellValue("lName", "Value"),
  				xlsBook.getCellValue("email", "Value"),xlsBook.getCellValue("cardHolder", "Value"),
  				xlsBook.getCellValue("cardNum", "Value"),xlsBook.getCellValue("expirationmonth", "Value"),
  				xlsBook.getCellValue("expirationyear", "Value"), xlsBook.getCellValue("cvv", "Value"), true,
  				"Validate Hotel Booking as a Guest with valid payment details"}};
	}
}