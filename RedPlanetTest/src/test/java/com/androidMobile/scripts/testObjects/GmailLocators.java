package com.androidMobile.scripts.testObjects;

import org.openqa.selenium.By;

import com.ctaf.accelerators.ActionEngine;

public class GmailLocators extends ActionEngine{
	
	public static By userIdInputField = By.id("Email");
	public static By nextButton = By.id("next");
	public static By passwordInputField = By.id("Passwd");
	public static By signInButton = By.id("signIn");
	public static By persistentCookieCheckBox = By.id("PersistentCookie");
	public static By composeNewMailButton = By.xpath("//div[text()='COMPOSE']");
	public static By mailItemFromRedPlanetHotels = By
			.xpath("//body/descendant::span[@email='developer@redplanethotels.com'][1]/../..");
	public static By resetLink = By
			.xpath("//body/descendant::div[contains(text(),'Please click on the link')]/a[last()]");
	public static By resetPassworddInputField = By
			.xpath("//input[@id='password']");
	public static By submitButton = By.xpath("//button[text()='Submit']");
	public static By successText = By.xpath("//h4[contains(text(),'Your password has been changed')]");
	public static By errorMessageOnResetPass = By.xpath("//div[@ng-if='errorMessage']");

}
