package com.androidMobile.scripts.testObjects;

import org.openqa.selenium.By;

public class RetrieveBookingLocators {
	
	public static By emailInput = By
			.xpath("//*[@resource-id='com.redplanethotels.staging:id/nonmember_et_email']");	
	public static By bookingCodeInput = By
			.xpath("//*[@resource-id='com.redplanethotels.staging:id/nonmember_et_booking_code']");
	public static By searchButton = By
			.xpath("//*[@text='Search']");	
	public static By bookingCode = By
			.xpath("//*[@resource-id='com.redplanethotels.staging:id/modify_code']");
	public static By doneButton = By
			.xpath("//*[@text='DONE']");	
	public static By bookingDetailView  = By.xpath("//*[@text='View Booking']");
	public static By retrieveBookingsScreenTitle = By
			.xpath("//*[contains(@resource-id,'titlebar_tv_label') and contains(@text,'RETRIEVE BOOKINGS')]");	
}
