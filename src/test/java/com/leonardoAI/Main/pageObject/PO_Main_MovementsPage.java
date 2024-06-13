package com.leonardoAI.Main.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.leonardoAI.actions.Action_Activate;
import com.leonardoAI.actions.Action_Deactivate;
import com.leonardoAI.actions.Action_Edit;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.projectUtility.FindDateInCalendar;
import com.leonardoAI.projectUtility.FindDeleteBoxFromListAndClick;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_MovementsPage extends ReUseAbleElement {
		
		//CONSTRUCTOR DECLARATION
		public WebDriver driver;
		public Logger logger = LogManager.getLogger(getClass());
		public JavascriptExecutor jsExecutor;
		public ReUseAbleElement ruae;
		public WebDriverWait wait;
		public PO_LoginPage lp;
		public Actions action;
		public SoftAssert softAssert = new SoftAssert();
		
		//CONSTRUCTOR CREATION
		public PO_Main_MovementsPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgMovementAdded = "Movement Added successfully";
		public String alertMsgMovementDeActivated = "Status Changed Successfully.";
		public String alertMsgMovementActivated = "Status Changed Successfully.";
		public String alertMsgMovementUpdated = "Movement Updated Successfully";
		
		public String alertMsgMovementAssigned = "Movement assigned";
		public String alertMsgMovementRemoved = "Movement removed";
	
		
		//======START======PAGE OBJECT FOR MOVEMENT AND ACTOIN METHODS==========//
		//BUTTON MOVEMENT LISTING
  		@FindBy(xpath = "//span[contains(normalize-space(),'Movements Listing')]")
  		@CacheLookup
  		public WebElement btnMovementListing;
  		public void clickOnBtnMovementListing() throws InterruptedException {
  			btnMovementListing.click();
  			logger.info("Clicked on the btnMovementListing");
  			Thread.sleep(1000);
  		}
  		
  		//BUTTON ADD MOVEMENT
  		@FindBy(xpath = "//span[contains(normalize-space(),'Add Movement')]")
  		@CacheLookup
  		public WebElement btnAddMovement;
  		public void clickOnBtnAddMovement() throws InterruptedException {
  			btnAddMovement.click();
  			logger.info("Clicked on the btnAddMovement");
  			Thread.sleep(1000);
  		}
  		
  		
  		//TEXT FIELD MOVEMENT NAME
  		@FindBy(xpath = "//input[@name='title']")
  		@CacheLookup
  		public WebElement fieldMovementName;
  		public void setMovementName(String MovementName) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldMovementName));
  			fieldMovementName.sendKeys(Keys.CONTROL,"a");
  			fieldMovementName.sendKeys(Keys.DELETE);
  			fieldMovementName.sendKeys(MovementName);
  			logger.info("Entered the fieldFirstName: "+MovementName);
  			Thread.sleep(300);
  		}
  		
  			
	  	//TEXT FIELD MOVEMENT DESCRIPTION 
  		public void setWorkOutDescriptionForCoach(String movementDescription) throws InterruptedException {
  			setDescription_1_RU(movementDescription);
  		}
  	
  		//CHECKBOX ALLOW TRACKING FOR THIS MOVEMENT
  		public void checkboxAllowTrackingFormMovement() throws InterruptedException {
  			ruae.clickOnCheckBox_1_RU();
  		}
  		
  		//CHECKBOX ALLOW MODIFIED TRACKING FOR THIS MOVEMENT
  		public void checkboxAllowModifiedTrackingFormMovement() throws InterruptedException {
  			ruae.clickOnCheckBox_2_RU();
  		}
  		
  		//SAVE AND CLOSE BUTTON
  		@FindBy(xpath = "//span[normalize-space()='Save & close']")
  		@CacheLookup
  		public WebElement btnSaveAndClose;
  		public boolean clickOnBtnSaveAndClose() throws InterruptedException {
  			boolean flag = false;
  			try {
  				btnSaveAndClose.click();
  				flag = true;
  	  			logger.info("Clicked on the btnSaveAndClose");
  	  			Thread.sleep(1000);
  			}catch(Exception e) {
  				logger.info("Exception from: "+e.getMessage());
  			}
  			
  			return flag;
  		}
  	
  		
  		//DIMENTION CHECKBOX
  		public void dimensionCheckbox(boolean hieght,boolean weight,boolean reps,boolean distance,boolean time,boolean score,boolean rounds,boolean tonnage) throws InterruptedException
  		{
  			if(hieght) {
  				selectCheckbox_RU(driver,3);
  			}
  			if(weight) {
  				selectCheckbox_RU(driver,4);
  			}
  			if(reps) {
  				selectCheckbox_RU(driver,5);
  			}
			if(distance) {
				selectCheckbox_RU(driver,6);		
			}
			if(time) {
				selectCheckbox_RU(driver,7);
			}
			if(score) {
				selectCheckbox_RU(driver,8);
			}
			if(rounds) {
				selectCheckbox_RU(driver,9);
			}
			if(tonnage) {
				selectCheckbox_RU(driver,10);
			}
			
  		}
  		
  		
  		//TEXT NO MOVEMENT MATCHED TO CURRENT APPLIED FILTER
  		@FindBy(xpath = "//*[.='No Movements Matches Current Filter")
  		@CacheLookup
  		public WebElement noMovementMatchedWithApplieddFilter;
  		public boolean  isNoMovementMatchedDisplayed() throws InterruptedException {
  			boolean flag = false;
  			try {
  				if(noMovementMatchedWithApplieddFilter.isDisplayed()) {
  					flag = true;
  					logger.info("Searched key not present");
  					softAssert.assertTrue(flag,"Movement you are searching is not found");
  					clickOnP360Logo_RU();
  				}
  			}catch(Exception e) {
  				flag = false;
  				logger.info("Searched Movement is matched with the applied fileter");
  				logger.info("Exception from : "+e.getMessage());
  			}
  			softAssert.assertAll();
  			return flag;
  		}
  		
  		
  		//MOVEMENT LIST 
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List<WebElement> movementList;
  		//MOVEMENT ROW LIST ADDRESS AND ACTION METHODS
  		public String movementList_address = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findMovementFromRowListAndClickOnThreeDot(String movementName, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(movementList_address,movementList,driver, movementName, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findMovementFromRowListAndClickOnThreeDot: "+e.getMessage());
				softAssert.assertTrue(false,"not click on the three dot action button");
			}
			return listRowCount;
  		}
  		
  		
  		
  		//TO CLICK ON THE CALENDAR DATE BOX
  		@FindBy(xpath = "//div[@role='cell']//a")
  		@CacheLookup
  		public List <WebElement> calendarDateList;
  		//CALENDAR MONTH YAER ADDRESS
  		public String monthYearAddress = "//span[@class='rbc-toolbar-label']";
  		
  		//TO SELECT THE MOVEMENT
  		public void selectMovement(String movementName) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,movementName);
  			logger.info("Selected Movement from the list: "+movementName);
  			Thread.sleep(500);
  		}
  		
  		//ASSIGNED MOVEMENT LIST ADDRESS AND ACTION BUTTON
  		@FindBy(xpath = "//div[contains(@class,'flex flex-col mt-5 gap-3')]//div[contains(@class,'bg-red')]")
  		@CacheLookup
  		public List <WebElement> assignedMovementList;
  		public String assignedMovementListAddress = "//div[contains(@class,'flex flex-col mt-5 gap-3')]//div[contains(@class,'bg-red')]";
  		
  		//DELETE BOX ADDRESS
  		public String deleteBox_address = "//*[name()='svg'][@class='MuiSvgIcon-root cursor-pointer']";
  		
  		//======END======PAGE OBJECT FOR ADD MOVEMENT ACTOIN METHODS==========//
  				
  				
  				
  		//TO ADD MOVEMENT
  		public PO_Main_HomePage addOrChangeMovement(String movementName,String movementDescription,boolean wantToAllowTracking, boolean wantToAllowModifiedTracking,boolean hieght,boolean weight,boolean reps,boolean distance,boolean time,boolean score,boolean rounds,boolean tonnage) throws Throwable
  		{
  			StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTraceElement[2].getMethodName();
  			logger.info("addOrChangeWorkout caller method name: "+callerMethodName);
  			
  			if(callerMethodName.equals("test_Main_UpdateMovement")) {
  				Action_Edit.change(driver);
  			}else {
  				clickOnBtnMovementListing();
  	  			Thread.sleep(1000);
  	  			clickOnBtnAddMovement();
  	  			Thread.sleep(1000);
  	  			//NOT CHANGING MOVEMENT NAME WHILE UPDATE/CHANGE
  	  			setMovementName(movementName);
  			}
  			
  			
  			setWorkOutDescriptionForCoach(movementDescription); 
  			if(wantToAllowTracking) {
  				ruae.clickOnCheckBox_1_RU();
  				Thread.sleep(500);
  				dimensionCheckbox(hieght,weight,reps,distance,time,score,rounds,tonnage);
  				Thread.sleep(500);
  			}
  			if(wantToAllowModifiedTracking) {
  				ruae.clickOnCheckBox_2_RU();
  				Thread.sleep(300);
  			}
  			
  			boolean flag = false;
  			if(callerMethodName.equals("test_Main_UpdateMovement")) {
  				flag = clickOnBtnSaveChangesSpan_RU();
  			}else {
  				flag = clickOnBtnSaveAndClose();
  			}
  			
  			if(flag) {
  				if(isRequiredOrInvalidMessageDisplayed_RU()) {
  					clickOnCancelButton_1_RU();
  				}else {
  					Thread.sleep(100);
  	  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  	  				if(alertMsg.equals(alertMsgMovementAdded)) {
  	  					logger.info("Movement added");
  	  					softAssert.assertEquals(alertMsg, alertMsgMovementAdded,"movement added successfully");
  	  				}else if(alertMsg.equals(alertMsgMovementUpdated)){
  	  					logger.info("Workout updated");
  	  					softAssert.assertEquals(alertMsg, alertMsgMovementUpdated,"Movement updated successfully");
  	  				}else {
  	  					softAssert.assertTrue(false,"Movement neither added nor updated successfully.");
  	  				}
  				}
  			}else {
  				logger.info("Not clicked on the save button");
  				softAssert.assertTrue(false,"You want to add Movement or update, but not clicked on the save button");
  			}
			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//FIND MOVEMENT FROM THE LIST AND CLICK ON THE THREE DOT BUTTON
  		public void findMovementFromListAndClickOnThreeDotButton(String searchKey,String movementName,boolean wantToClickOnThreeDot,int searchKeyColumnIndex, boolean wantToClickOnSearchKey) throws InterruptedException
  		{
  			clickOnBtnMovementListing();
  			Thread.sleep(1000);
  			searchBox_1_RU(driver, searchKey);
  			Thread.sleep(5000);
  			boolean flag = isNoMovementMatchedDisplayed();
  			if(!flag) {
  	  			findMovementFromRowListAndClickOnThreeDot(movementName, searchKeyColumnIndex, wantToClickOnThreeDot, wantToClickOnSearchKey);
  	  		
  			}else {
  				softAssert.assertTrue(false,"Movement you are searching is not present");
  			}
  			softAssert.assertAll();
  		}
  		
  		
  		//TO ACTIVATE THE MOVEMENT
  		public PO_Main_HomePage activateMovement() throws InterruptedException
  		{
  			Action_Activate.activate(driver, alertMsgMovementActivated);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO DEACTIVATE THE MOVEMENT
  		public PO_Main_HomePage deactivateMovement() throws InterruptedException
  		{
  			Action_Deactivate.deactivate(driver, alertMsgMovementDeActivated);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO ASSIGN MOVEMENT TO DATE
  		public PO_Main_HomePage assignMovementToDate(String dateValue,String wantToClickOnDateOrDateBox,String movementName) throws InterruptedException 
  		{
  			boolean bol = FindDateInCalendar.findDateInCallendar(driver, dateValue, monthYearAddress,address_BackStarTag_1_RU,address_NextStarTag_1_RU, calendarDateList,wantToClickOnDateOrDateBox);
  			if(bol) 
  			{
  				selectMovement(movementName);
  				if(clickOnAdd_RU())
  				{
  					String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  	  				if(alertMsg.equals(alertMsgMovementAssigned)) {
  	  					logger.info("Workout assigened");
  	  					softAssert.assertEquals(alertMsg, alertMsgMovementAssigned,"Movement assigend successfully");
  	  				}else {
  	  					softAssert.assertTrue(false,"Movement not assigned");
  	  				}
  				}
  				clickOnBtnCross_1_RU();
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		//TO REMOVED ASSIGN MOVEMENT FROM THE DATE
  		public PO_Main_HomePage removeMovementFromDate(String dateValue,String wantToClickOnDateOrDateBox,String movementName,String searchKey,int searchKeyColumnIndex, boolean wantToClickOnDeleteBox, boolean wantToclickOnFindSearckKey) throws InterruptedException 
  		{
  			boolean bol = FindDateInCalendar.findDateInCallendar(driver,dateValue, monthYearAddress,address_BackStarTag_1_RU,address_NextStarTag_1_RU, calendarDateList,wantToClickOnDateOrDateBox);
  			if(bol) 
  			{
  				FindDeleteBoxFromListAndClick.findDeleteBoxButtonAndClick(assignedMovementListAddress, assignedMovementList, driver, searchKey,searchKeyColumnIndex, wantToClickOnDeleteBox, wantToclickOnFindSearckKey);
  				if(clickOnBtnYes_RU(driver))
  				{
  					String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  	  				if(alertMsg.equals(alertMsgMovementRemoved)) {
  	  					logger.info("Movement assigened");
  	  					softAssert.assertEquals(alertMsg, alertMsgMovementRemoved,"Movement removed from the assigned date successfully");
  	  				}else {
  	  					softAssert.assertTrue(false,"Movement not removed from the assigned date successfully.");
  	  				}
  				}
  				clickOnBtnCross_1_RU();
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		
  	

}
