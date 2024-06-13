package com.leonardoAI.Main.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_CoachesPage extends ReUseAbleElement {
		
		//CONSTRUCTOR DECLARATION
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public PO_LoginPage lp;
		public Actions action;
		public SoftAssert softAssert = new SoftAssert();
		
		//HOMEPAGE CONSTRUCTOR CREATION
		public PO_Main_CoachesPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgCoachInvitedSuccessfully = "Coach invite Successfully";
		public String alertMsgCoachDeactivated = "Coach Deactivated successfully";
		public String alertMsgCoachActivated = "Coach Activated successfully";
		public String alertMsgInvitationSent = "Invitation resent successfully";
		public String alertMsgInvitationCancel = "Invitation canceled successfully";
		public String alertMsgCoachUpdated = "Coach Updated Successfully";
	
		
		//======START======PAGE OBJECT FOR ADD CLASS AND ACTOIN METHODS==========//
		//BUTTON INVITE COACH
  		@FindBy(xpath = "(//span[normalize-space()='Invite Coach'])[1]")
  		@CacheLookup
  		public WebElement btnInviteCoach;
  		public void clickOnBtnInviteCoach() throws InterruptedException {
  			btnInviteCoach.click();
  			logger.info("Clicked on the btn btnInviteCoach");
  			Thread.sleep(1000);
  		}
  		
  		//BUTTON INVITE COACH
  		@FindBy(xpath = "(//span[normalize-space()='Invite Coach'])[3]")
  		@CacheLookup
  		public WebElement btnInviteCoachSubmit;
  		public void clickOnBtnInviteCoachSubmit() throws InterruptedException {
  			btnInviteCoachSubmit.click();
  			logger.info("Clicked on the btn btnInviteCoachSubmit");
  			Thread.sleep(1000);
  		}
  		
		
  		
  		//TEXT FIELD FIRST NAME
  		@FindBy(xpath = "//input[contains(@name,'firstName')]")
  		@CacheLookup
  		public WebElement fieldFirstName;
  		public void setFisrtName(String firstName) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldFirstName));
  			fieldFirstName.sendKeys(Keys.CONTROL,"a");
  			fieldFirstName.sendKeys(Keys.DELETE);
  			fieldFirstName.sendKeys(firstName);
  			logger.info("Entered the fieldFirstName: "+firstName);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD LAST NAME
  		@FindBy(xpath = "//input[contains(@name,'lastName')]")
  		@CacheLookup
  		public WebElement fieldLastName;
  		public void setLastName(String lastName) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldFirstName));
  			fieldLastName.sendKeys(Keys.CONTROL,"a");
  			fieldLastName.sendKeys(Keys.DELETE);
  			fieldLastName.sendKeys(lastName);
  			logger.info("Entered the fieldLastName: "+lastName);
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD EMAIL
  		@FindBy(xpath = "//input[contains(@name,'email')]")
  		@CacheLookup
  		public WebElement fieldEmail;
  		public void setEmail(String email) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldFirstName));
  			fieldEmail.sendKeys(Keys.CONTROL,"a");
  			fieldEmail.sendKeys(Keys.DELETE);
  			fieldEmail.sendKeys(email);
  			logger.info("Entered the fieldEmail: "+email);
  			Thread.sleep(300);
  		}
  		
  	
  		//TO SELECT THE LOCATION
  		public void selectCoachLocation(String coachLocation,int dropdownIconNumber) throws InterruptedException {
  			//ruae.clickOnDropdown_3_RU();
  			driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])["+dropdownIconNumber+"]")).click();
  			//Will avoid the stale element reference
  			Thread.sleep(500);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,coachLocation);
  			Thread.sleep(500);
  		}
  		
  		
  		//COACH LIST 
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List<WebElement> coachList;
  		//PACKAGE CATEGORY ROW LIST ADDRESS AND ACTION METHODS
  		public String coachList_address = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findCoachFromRowListAndClickOnThreeDot(String coachName, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				//listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(packageCategoryRowList,driver, packageCategoryTitle, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(coachList_address,coachList,driver, coachName, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findCoachFromRowListAndClickOnThreeDot: "+e.getMessage());
				softAssert.assertTrue(false,"not click on the three dot action button");
			}
			return listRowCount;
  		}
  		
  		//INNER BUTTON DEACTIVATE A COACH
  		@FindBy(xpath = "//span[contains(@class,'MuiButton-label')][normalize-space()='Deactivate Coach']")
  		@CacheLookup
  		public WebElement btnInnerDeactivateCoach;
  		public boolean clickOnBtnInnerDeactivateCoach() throws InterruptedException {
  			boolean flag = false;
  			try {
  				btnInnerDeactivateCoach.click();
  				flag = true;
  	  			logger.info("Clicked on the btnInnerDeactivateCoach");
  	  			Thread.sleep(1000);
  			}catch(Exception e) {
  				logger.info("Exception e"+e.getMessage());
  				softAssert.assertTrue(flag,"Inner button deactivate coach, not present");
  			}
  			return flag;
  		}
  		
  		//INNER BUTTON ACTIVATE A COACH
  		@FindBy(xpath = "//span[contains(@class,'MuiButton-label')][normalize-space()='Activate Coach']")
  		@CacheLookup
  		public WebElement btnInnerActivateCoach;
  		public boolean clickOnBtnInnerActivateCoach() throws InterruptedException {
  			boolean flag = false;
  			try {
  				btnInnerActivateCoach.click();
  				flag = true;
  	  			logger.info("Clicked on the btnInnerActivateCoach");
  	  			Thread.sleep(1000);
  			}catch(Exception e) {
  				logger.info("Exception e"+e.getMessage());
  				softAssert.assertTrue(flag,"Inner button activate coach, not present");
  			}
  			return flag;
  		}
  		
  		//TEXT NO COACHES MATCHED TO CURRENT APPLIED FILTER
  		@FindBy(xpath = "//*[.='No Coaches Matches Current Filter']")
  		@CacheLookup
  		public WebElement noCoachMatchedWithApplieddFilter;
  		public boolean  isNoCoachMatchedDisplayed() throws InterruptedException {
  			boolean flag = false;
  			try {
  				if(noCoachMatchedWithApplieddFilter.isDisplayed()) {
  					flag = true;
  					logger.info("Searched key not present");
  					softAssert.assertTrue(flag,"Coaches you are searching is not found");
  					clickOnP360Logo_RU();
  				}
  			}catch(Exception e) {
  				flag = false;
  				logger.info("Searched Coach is matched with the applied fileter");
  				logger.info("Exception from : "+e.getMessage());
  			}
  			softAssert.assertAll();
  			return flag;
  		}
  		
  		
  		
  		
  		
  		//======END======PAGE OBJECT FOR ADD CLASS AND CLASS SHEDULE ACTOIN METHODS==========//
  				
  				
  				
  		//TO INVITE COACH
  		public PO_Main_HomePage inviteCoach(String firstName,String lastName, String email, String coachLocation) throws InterruptedException
  		{
  			clickOnBtnInviteCoach();
  			setFisrtName(firstName);
  			setLastName(lastName);
  			setEmail(email);
  			selectCoachLocation(coachLocation,2);
  			clickOnBtnInviteCoachSubmit();
			if(isRequiredOrInvalidMessageDisplayed_RU()) {
				clickOnCancelButton_1_RU();
			}else {
				Thread.sleep(100);
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgCoachInvitedSuccessfully)) {
  					softAssert.assertEquals(alertMsg, alertMsgCoachInvitedSuccessfully,"Checks Coach Invited successfully");
  				}else {
  					softAssert.assertTrue(false,"Coach not invited successfully");
  				}
			}
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//FIND COACH FROM THE LIST AND CLICK ON THE THREE DOT BUTTON
  		public void findCoachFromListAndClickOnThreeDotButton(String coachName,String coachLocation, String searchKey,boolean wantToClickOnThreeDot,int searchKeyColumnIndex, boolean wantToClickOnSearchKey) throws InterruptedException
  		{
  			selectCoachLocation(coachLocation,1);
  			searchBox_1_RU(driver, searchKey);
  			Thread.sleep(5000);
  			boolean flag = isNoCoachMatchedDisplayed();
  			if(!flag) {
  	  			findCoachFromRowListAndClickOnThreeDot(coachName, searchKeyColumnIndex, wantToClickOnThreeDot, wantToClickOnSearchKey);
  	  		
  			}else {
  				softAssert.assertTrue(false,"Coach you are searching is not present");
  			}
  			softAssert.assertAll();
  		}
  		
  		
  		//TO UPDATE COACH
  		public PO_Main_HomePage updateCoach(String email, String coachLocation) throws InterruptedException
  		{
  			String yourAddressWithoutNumber = "//div[normalize-space()='Change']";
  			clickOnActionListButton_RU(yourAddressWithoutNumber);
  			
  			setEmail(email);
  			selectCoachLocation(coachLocation,2);
  			clickOnBtnUpdate_1_RU();
			if(isRequiredOrInvalidMessageDisplayed_RU()) {
				clickOnCancelButton_1_RU();
			}else {
				Thread.sleep(100);
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgCoachUpdated)) {
  					softAssert.assertEquals(alertMsg, alertMsgCoachUpdated,"Coach updated successfully");
  				}else {
  					softAssert.assertTrue(false,"Coach not updated successfully");
  				}
			}
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		//TO DEACTIVATE A COACH
  		public PO_Main_HomePage deactivateCoach() throws InterruptedException
  		{
  			String yourAddressWithoutNumber = "//div[normalize-space()='Deactivate Coach']";
  			clickOnActionListButton_RU(yourAddressWithoutNumber);
  			boolean flag = clickOnBtnInnerDeactivateCoach();
  			if(flag) {
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgCoachDeactivated)) {
  					softAssert.assertEquals(alertMsg, alertMsgCoachDeactivated,"Coach Deactivated successfully");
  				}else {
  					softAssert.assertTrue(false,"Coach not deactivated");
  				}
  			}else {
  				softAssert.assertTrue(flag,"You want to deactivate a coach but, not clicked on Inner deactivate coach button ");
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}

  		
  		//TO ACTIVATE A COACH
  		public PO_Main_HomePage activateCoach() throws InterruptedException
  		{
  			String yourAddressWithoutNumber = "//div[normalize-space()='Activate Coach']";
  			clickOnActionListButton_RU(yourAddressWithoutNumber);
  			boolean flag = clickOnBtnInnerActivateCoach();
  			if(flag) {
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgCoachActivated)) {
  					softAssert.assertEquals(alertMsg, alertMsgCoachActivated,"Coach Activated successfully");
  				}else {
  					softAssert.assertTrue(false,"Coach not Activated");
  				}
  			}else {
  				softAssert.assertTrue(flag,"You want to Activated a coach but, not clicked on Inner Activated coach button ");
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO RESEND INVITATION
  		public PO_Main_HomePage resendInvitation() throws InterruptedException
  		{
  			String yourAddressWithoutNumber = "//div[normalize-space()='Resend Invitation']";
  			clickOnActionListButton_RU(yourAddressWithoutNumber);
  			boolean flag = clickOnBtnYes_RU(driver);
  			if(flag) {
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgInvitationSent)) {
  					softAssert.assertEquals(alertMsg, alertMsgInvitationSent,"Invitation sent successfully");
  				}else {
  					softAssert.assertTrue(false,"Invition not sent");
  				}
  			}else {
  				softAssert.assertTrue(flag,"You want click on Yes button but,it is not present");
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		//TO CANCEL INVIATATION
  		public PO_Main_HomePage cancelInvitation() throws InterruptedException
  		{
  			String yourAddressWithoutNumber = "//div[normalize-space()='Cancel Invitation']";
  			clickOnActionListButton_RU(yourAddressWithoutNumber);
  			boolean flag = clickOnBtnYes_RU(driver);
  			if(flag) {
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgInvitationCancel)) {
  					softAssert.assertEquals(alertMsg, alertMsgInvitationCancel,"Inviation canceled successfully");
  				}else {
  					softAssert.assertTrue(false,"Invition not canceled");
  				}
  			}else {
  				softAssert.assertTrue(flag,"You want to cancel invitation but, yes button not present");
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		
  	
  		
  	

}
