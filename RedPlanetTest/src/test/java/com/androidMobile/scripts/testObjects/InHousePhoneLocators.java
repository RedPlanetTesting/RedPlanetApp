package com.androidMobile.scripts.testObjects;

import org.openqa.selenium.By;

public class InHousePhoneLocators {

	public static By phoneTitle = By.xpath("//*[@text='Phone']");
	public static String noButtonToDial = ("//*[@text='#']");
	public static By callIcon = By.xpath("//*[@resource-id='com.redplanethotels.staging:id/phone_bt_call']");
	public static By callingRoomLabel = By.xpath("//*[contains(@text,'Calling Room')]");
	public static By rigingLabel = By.xpath("//*[contains(@text,'ringing')]");
	public static By busyLabel = By.xpath("//*[contains(@text,'busy')]");
	public static By callEndButton = By.xpath("//*[@resource-id='com.redplanethotels.staging:id/phone_call_bt_hangup']");
	public static By frontDeskButtonToCall = By.xpath("//*[@text='Front desk']");
	public static By newConversationTitle = By.xpath("//*[@name='New Conversation']");
	public static By textAreaForChat = By.xpath("//*[@resource-id='com.redplanethotels.staging:id/hs__conversationDetail']");
	public static By textAreaForChat2 = By.xpath("//*[@resource-id='com.redplanethotels.staging:id/hs__messageText']");
	public static By ChatNameInput = By.xpath("//*[@resource-id='com.redplanethotels.staging:id/hs__username']");
	public static By sendButtonForChat = By.xpath("//*[@resource-id='com.redplanethotels.staging:id/hs__start_new_conversation']");
	public static By sendButtonForChat2 = By.xpath("//*[@resource-id='com.redplanethotels.staging:id/hs__sendMessageBtn']");
			
	
	
	
	
}
