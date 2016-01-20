package com.mobile.scripts;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.mobile.scripts.testObjects.HomePageLocators;
import com.mobile.workflows.HomePageHelper;

import io.appium.java_client.ios.IOSDriver;

public class RP_Smoke_TestHomeMainMenu_logout extends HomePageHelper{
		/*
		 * Verify Side Menu Links
		 */
	@Test( groups = { "Mobile" })
	  public void smokeTestHomeMainMenu_logout() throws Throwable{
	 try{		  
		  TestEngine.testDescription.put(HtmlReportSupport.tc_name,"Validate Home Main Menu");
		  //handleSplashDialog();		  
		  Thread.sleep(2000);
		  waitForElementPresent(HomePageLocators.mainMenuIcon,"mainMenuIcon");
		  isElementPresent(HomePageLocators.mainMenuIcon,"Validate Main Menu Icon on Home Page");		  
		  click(HomePageLocators.mainMenuIcon,"mainMenuIcon");		  
		  List<WebElement> sidemenuItems = ((IOSDriver)Iosdriver).findElementsByIosUIAutomation(sideMenuUITable1);
		  if(sidemenuItems.size()==0){
			  sidemenuItems = ((IOSDriver)Iosdriver).findElementsByIosUIAutomation(sideMenuUITable2);
			}
			System.out.println("++++++++"+sidemenuItems.size());
			int linkCount=0;
			for(int i=0;i<sidemenuItems.size();i++){
				String name = sidemenuItems.get(i).getAttribute("name");
				System.out.println("+++++++"+name);
				if(name.length()>0){
				if((name.toLowerCase().contains("book"))&(i==1)){
					Reporter.SuccessReport("Book Now link verification", "successful");
					linkCount++;
				}else if(!(name.toLowerCase().contains("book"))&(i==1)){
					Reporter.failureReportContinue("Book Now link verification", "failed");
				}
				if((name.toLowerCase().contains("account"))&(i==2)){
					Reporter.SuccessReport("My Account link verification", "successful");
					linkCount++;
				}else if(!(name.toLowerCase().contains("account"))&(i==2)){
					Reporter.failureReportContinue("My Account link verification", "failed");
				}
				if((name.toLowerCase().contains("retrieve"))&(i==3)){
					Reporter.SuccessReport("Retrieve Bookings link verification", "successful");
					linkCount++;	
				}else if(!(name.toLowerCase().contains("retrieve"))&(i==3)){
					Reporter.failureReportContinue("Retrieve Bookings link verification", "failed");
				}
				if((name.toLowerCase().contains("about"))&(i==4)){
					Reporter.SuccessReport("About Us link verification", "successful");
					linkCount++;
				}else if(!(name.toLowerCase().contains("about"))&(i==4)){
					Reporter.failureReportContinue("About Us link verification", "failed");
				}
				if((name.toLowerCase().contains("help"))&(i==5)){
					Reporter.SuccessReport("Help and Info link verification", "successful");
					linkCount++;
				}else if(!(name.toLowerCase().contains("help"))&(i==5)){
					Reporter.failureReportContinue("Help and Info link verification", "failed");
				}
			}
			}
		  if(linkCount<5){
			  Reporter.failureReport("Side Menu Links Verification", "failed");
		  }
		  
	 }catch (Exception e) {
			e.printStackTrace();
			Reporter.failureReport("Validate Side Menu Links", "Failed with exception");
	 }
	}	
	
}
		
		



