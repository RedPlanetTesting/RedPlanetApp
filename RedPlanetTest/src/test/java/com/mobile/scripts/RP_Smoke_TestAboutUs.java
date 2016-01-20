package com.mobile.scripts;

import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.mobile.scripts.testObjects.AboutUsLocators;
import com.mobile.workflows.HomePageHelper;

public class RP_Smoke_TestAboutUs extends HomePageHelper{

@Test(groups = { "Mobile" })
public void testAboutUs() 
		  throws Throwable{
	try{
		 TestEngine.testDescription.put(HtmlReportSupport.tc_name,"Test About Us Screen");
		
		 handleSplashDialog();
		 navigateToAboutUs();
		 waitForElementPresent(AboutUsLocators.aboutUsTitle,"About Us Title");
		 isElementPresent(AboutUsLocators.facebookImage,"Facebook Icon");
		 isElementPresent(AboutUsLocators.twitterImage,"Twitter Icon");
		 isElementPresent(AboutUsLocators.googleImage,"Google Icon");
		 isElementPresent(AboutUsLocators.pintrestImage,"Pintrest Icon");
		 isElementPresent(AboutUsLocators.flipboardImage,"Flipboard Icon");
		 isElementPresent(AboutUsLocators.vineImage,"Vine Icon");
		 isElementPresent(AboutUsLocators.termsNcondiLink,"Terms & Condition Link");
		 isElementPresent(AboutUsLocators.privacypolicyLink,"Privacy Policy Link");
		 isElementPresent(AboutUsLocators.termsuseLink,"Terms of Use Link");
		 
	}catch(Exception e) {
		e.printStackTrace();
	}	
}

}