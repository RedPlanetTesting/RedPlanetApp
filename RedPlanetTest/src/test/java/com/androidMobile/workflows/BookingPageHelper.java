package com.androidMobile.workflows;

import org.openqa.selenium.By;

import com.androidMobile.scripts.testObjects.AccountPageLocators;
import com.androidMobile.scripts.testObjects.BookPageLocators;
import com.androidMobile.scripts.testObjects.LoginPageLocators;
import com.ctaf.support.ReportStampSupport;

public class BookingPageHelper extends HomePageHelper {	
	

	public static void populateGuestDetails(String title,String fName, String lName,
			String email,String phone) throws Throwable{	
		String temp = "abcdefghijklmnopqrstABCDEFGHIJKLMNOP";
		int randomval = ReportStampSupport.biRandomValue();
		try {
			/*waitForElementPresent(BookPageLocators.guestDetailsFrame,
					"guestDetailsFrame");*/
			if(fName.length()>0){
				scrollToElement(BookPageLocators.firstNameInput);
				waitForElementPresent(BookPageLocators.firstNameInput,"firstNameInput");
			type(BookPageLocators.firstNameInput, (fName+temp.charAt(randomval)).toString(), "firstNameInput");	
			}
			if(lName.length()>0){
				//scrollToText("Email");
				scrollToElement(BookPageLocators.lastNameInput);
				waitForElementPresent(BookPageLocators.lastNameInput,"lastNameInput");
				type(BookPageLocators.lastNameInput, lName+temp.charAt(randomval),"lastNameInput");
				if(isElementDisplayedTemp(AccountPageLocators.signUpButton)){
					driver.navigate().back();
					type(BookPageLocators.lastNameInput, (lName+temp.charAt(randomval)).toString(),"lastNameInput");
				}
				/*if(isElementDisplayedTemp(By.xpath("//*[@text='Mrs.']"))){
						driver.navigate().back();
						type(BookPageLocators.lastNameInput, lName+temp.charAt(randomval),"lastNameInput");
					}*/
				
			}
			if(email.length()>0){
				//scrollToText("Email");
				waitForElementPresent(BookPageLocators.EmailInput,"EmailInput");
				type(BookPageLocators.EmailInput, email, "EmailInput");	
				/*if(isElementDisplayed(AccountPageLocators.signUpButton)){
					driver.navigate().back();
					type(BookPageLocators.EmailInput, email, "EmailInput");
				}*/
				/*if(isElementDisplayed(By.xpath("//*[@text='Mrs.']"))){
					driver.navigate().back();
					type(BookPageLocators.EmailInput, email, "EmailInput");
				}*/
			}
		}catch(Exception e){
			e.printStackTrace();
			click(LoginPageLocators.okayButtonOnErrorpop, "okayButtonOnErrorpop");			
		}		
		
	}
	
	public static boolean verifyGuestDetailsAsMember(String title,String fName, String lName,
			String email,String phone) throws Throwable{	
		boolean result = false;	
		int count = 0;
		try {
			waitForElementPresent(BookPageLocators.guestDetailsFrame,"guestDetailsFrame");
			//scrollToText("Email");
			if(isTextPresent(fName)/*getAttribute(BookPageLocators.firstNameInput,"text","firstNameInput").contains(fName)*/)						
			{
				count++;
			}
			if(count==1){
				result = true;
			}
		}catch(Exception e){
			e.printStackTrace();
			click(LoginPageLocators.okayButtonOnErrorpop, "okayButtonOnErrorpop");			
		}		
		return result;
	}
	
	public static void populatePaymentDetails(String cardHolder,String cardNum, 
			String expMonth,String cvv) throws Throwable{		
		try {
			//scrollToText("PAYMENT DETAILS");	
			
			if(cardHolder.length()>0){
				scrollToElement(BookPageLocators.cardHolderInput);
				waitForElementPresent(BookPageLocators.cardHolderInput,"cardHolder");
				type(BookPageLocators.cardHolderInput, cardHolder, "cardHolder");	
				
			}
			if(cardNum.length()>0){
				scrollToElement(BookPageLocators.cardNumInput);
				waitForElementPresent(BookPageLocators.cardNumInput,"cardNum");
				type(BookPageLocators.cardNumInput, cardNum,"cardNum");
			}
			if(expMonth.length()>0){
			waitForElementPresent(BookPageLocators.expMonthInput,"expMonthInput");
			type(BookPageLocators.expMonthInput, expMonth, "expMonth");	
			waitForElementPresent(BookPageLocators.cvvNumInput,"cvvNumInput");
			}
			if(cvv.length()>0){
			type(BookPageLocators.cvvNumInput, cvv, "cvvNumInput");
			}
			//scrollToText("CVV");
			scrollToElement(BookPageLocators.conditionsCheck);
			waitForElementPresent(BookPageLocators.conditionsCheck, "conditionsCheck");
			click(BookPageLocators.conditionsCheck, "conditionsCheck");
			scrollToElement(BookPageLocators.bookButton);
			waitForElementPresent(BookPageLocators.bookButton, "bookButton");
			click(BookPageLocators.bookButton, "bookButton");
			if(isElementDisplayed(BookPageLocators.bookButton)){
				click(BookPageLocators.bookButton, "bookButton");
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
}
