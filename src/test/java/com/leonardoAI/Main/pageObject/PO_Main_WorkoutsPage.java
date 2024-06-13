package com.leonardoAI.Main.pageObject;

import java.io.IOException;
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
import com.leonardoAI.projectUtility.DatePicker;
import com.leonardoAI.projectUtility.FindDateInCalendar;
import com.leonardoAI.projectUtility.FindDeleteBoxFromListAndClick;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_WorkoutsPage extends ReUseAbleElement {
		
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
		public PO_Main_WorkoutsPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgWorkoutElapsed = "Cannot change workouts for elapsed days";
		public String alertMsgWorkoutAdded = "Workout Added Successfully";
		public String alertMsgWorkoutDeActivated = "Workout Deactivated Successfully.";
		public String alertMsgWorkoutActivated = "Workout Activated Successfully.";
		public String alertMsgWorkoutUpdated = "Workout Updated Successfully";
		public String alertMsgWorkoutAssigned = "Workout assigned";
		public String alertMsgWorkoutAlreadyExist = "Workout already exists";
		public String alertMsgWorkoutRemoved = "workout removed";
	
		
		//======START======PAGE OBJECT FOR WORKOUT AND ACTOIN METHODS==========//
		//BUTTON WORKOUT LISTING
  		@FindBy(xpath = "//span[contains(normalize-space(),'Workouts Listing')]")
  		@CacheLookup
  		public WebElement btnWorkoutListing;
  		public void clickOnBtnWorkoutListing() throws InterruptedException {
  			btnWorkoutListing.click();
  			logger.info("Clicked on the btnWorkoutListing");
  			Thread.sleep(1000);
  		}
  		
  		//BUTTON ADD WORKOUT
  		@FindBy(xpath = "//span[contains(normalize-space(),'Add Workout')]")
  		@CacheLookup
  		public WebElement btnAddWorkout;
  		public void clickOnBtnAddWorkout() throws InterruptedException {
  			btnAddWorkout.click();
  			logger.info("Clicked on the btnAddWorkout");
  			Thread.sleep(1000);
  		}
  		
  		
  		//TEXT FIELD WORKOUT NAME
  		@FindBy(xpath = "//input[@name='title']")
  		@CacheLookup
  		public WebElement fieldWorkoutName;
  		public void setWorkoutName(String workoutName) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldWorkoutName));
  			fieldWorkoutName.sendKeys(Keys.CONTROL,"a");
  			fieldWorkoutName.sendKeys(Keys.DELETE);
  			fieldWorkoutName.sendKeys(workoutName);
  			logger.info("Entered the fieldFirstName: "+workoutName);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD WORKOUT LINK
  		@FindBy(xpath = "//input[@placeholder='Enter Workout Link']")
  		@CacheLookup
  		public WebElement fieldWorkoutLink;
  		public void setWorkoutLink(String workoutLink) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldWorkoutLink));
  			fieldWorkoutLink.sendKeys(Keys.CONTROL,"a");
  			fieldWorkoutLink.sendKeys(Keys.DELETE);
  			fieldWorkoutLink.sendKeys(workoutLink);
  			logger.info("Entered the fieldLastName: "+workoutLink);
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD WORKOUT DESCRIPTION FOR MEMBERS
  		public void setWorkOutDescriptionForMember(String workoutMemberDescription) throws InterruptedException {
  			setDescription_1_RU(workoutMemberDescription);
  		}
	  		
	  	//TEXT FIELD WORKOUT DESCRIPTION FOR COACHES
  		public void setWorkOutDescriptionForCoach(String workoutCaochDescription) throws InterruptedException {
  			setDescription_2_RU(workoutCaochDescription);
  		}
  	
  		
  		//TO SELECT THE WORKOUT PUBLISH DATE
  		public void setWorkoutPublishDate(String workoutPublishDate) throws Throwable {
  			clickOnChangeDateIcon_1_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,workoutPublishDate);
  		    Thread.sleep(500);
  		}
  		
  		//TEXT NO WORKOUT MATCHED TO CURRENT APPLIED FILTER
  		@FindBy(xpath = "//*[.='No Workouts Matches Current Filter']")
  		@CacheLookup
  		public WebElement noWorkoutMatchedWithApplieddFilter;
  		public boolean  isNoWorkoutMatchedDisplayed() throws InterruptedException {
  			boolean flag = false;
  			try {
  				if(noWorkoutMatchedWithApplieddFilter.isDisplayed()) {
  					flag = true;
  					logger.info("Searched key not present");
  					softAssert.assertTrue(flag,"Workout you are searching is not found");
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
  		
  		//WORKOUT LIST 
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List<WebElement> workoutList;
  		//WORKOUT ROW LIST ADDRESS AND ACTION METHODS
  		public String workoutList_address = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findWorkoutFromRowListAndClickOnThreeDot(String workoutName, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				//listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(packageCategoryRowList,driver, packageCategoryTitle, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(workoutList_address,workoutList,driver, workoutName, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findWorkoutFromRowListAndClickOnThreeDot: "+e.getMessage());
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
  		
  		//TO SELECT THE WORKOUT
  		public void selectWorkout(String workoutName) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,workoutName);
  			logger.info("Selected workout from the list: "+workoutName);
  			Thread.sleep(500);
  		}
  		
  		//ASSIGNED WORKOUT LIST ADDRESS AND ACTION BUTTON
  		@FindBy(xpath = "//div[contains(@class,'flex flex-col mt-5 gap-3')]//div[contains(@class,'bg-red')]")
  		@CacheLookup
  		public List <WebElement> assignedWorkoutList;
  		public String assignedWorkoutListAddress = "//div[contains(@class,'flex flex-col mt-5 gap-3')]//div[contains(@class,'bg-red')]";
  		
  		//DELETE BOX ADDRESS
  		public String deleteBox_address = "//*[name()='svg'][@class='MuiSvgIcon-root cursor-pointer']";
  		
  		
  		//TO UPLOAD IMAGE 
  		@FindBy(xpath = "//div[@class='MuiDropzoneArea-root user-image-dropzone show-icon']")
  		@CacheLookup
  		public WebElement uploadImage;
  		public void updoadImage() throws InterruptedException {
  			Thread.sleep(200);
  			uploadImage.click();
  			logger.info("Clicked on upload image button");
  			Thread.sleep(1000);
  		}
  	
  		//======END======PAGE OBJECT FOR WORKOUT ACTOIN METHODS==========//
  				
  				
  				
  		//TO ADD WORKOUT
  		public PO_Main_HomePage addOrChangeWorkout(String workoutName,String workoutMemberDescription, String workoutCaochDescription, String workoutPublishDate,String workoutLink) throws Throwable
  		{
  			StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTraceElement[2].getMethodName();
  			logger.info("addOrChangeWorkout caller method name: "+callerMethodName);
  			
  			if(callerMethodName.equals("test_Main_UpdateWorkout")) {
  				Action_Edit.change(driver);
  			}else {
  				clickOnBtnWorkoutListing();
  	  			Thread.sleep(1000);
  	  			clickOnBtnAddWorkout();
  	  			Thread.sleep(1000);
  	  			//NOT CHANGING WORKOUT NAME WHILE UPDATE/CHANGE
  	  			setWorkoutName(workoutName);
  			}
  			
  			
  			setWorkOutDescriptionForMember(workoutMemberDescription); 
  			setWorkOutDescriptionForCoach(workoutCaochDescription);
  			setWorkoutPublishDate(workoutPublishDate);
  			setWorkoutLink(workoutLink);
  			Thread.sleep(1000);
  			updoadImage();
  			Thread.sleep(500);
  			//Runtime.getRuntime().exec("D:\\Sanjiv_QA/Eclipse Project/P360_UI_UserModule/P360_UI_UserModule/autoIt.exe");
  		
  			//OR
  			try {
  	            ProcessBuilder processBuilder = new ProcessBuilder("G:\\My Drive\\Sanjiv\\Eclipse_Project\\P660_UI_WATM\\P360_UI_UserModule-master\\autoIt.exe");
  	            Process process = processBuilder.start();

  	            // You can add code here to interact with the process if needed.

  	            int exitCode = process.waitFor();
  	            System.out.println("Process exited with code: " + exitCode);
  	        } catch (IOException | InterruptedException e) {
  	            e.printStackTrace();
  	        }
  			
  			 Thread.sleep(1000);
  			boolean flag = clickOnBtnSave_1_RU();
  			if(flag) {
  				if(isRequiredOrInvalidMessageDisplayed_RU()) {
  					clickOnCancelButton_1_RU();
  				}else {
  					Thread.sleep(100);
  	  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  	  				if(alertMsg.equals(alertMsgWorkoutAdded)) {
  	  					logger.info("Workout added");
  	  					softAssert.assertEquals(alertMsg, alertMsgWorkoutAdded,"Workout added successfully");
  	  				}else if(alertMsg.equals(alertMsgWorkoutUpdated)){
  	  					logger.info("Workout updated");
  	  					softAssert.assertEquals(alertMsg, alertMsgWorkoutUpdated,"Workout updated successfully");
  	  				}else {
  	  					softAssert.assertTrue(false,"Workout neither added nor updated successfully.");
  	  				}
  				}
  			}else {
  				logger.info("Not clicked on the save button");
  				softAssert.assertTrue(false,"You want to add workout or update, but not clicked on the save button");
  			}
			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//FIND WORKOUT FROM THE LIST AND CLICK ON THE THREE DOT BUTTON
  		public void findWorkoutFromListAndClickOnThreeDotButton(String searchKey,String workoutName,boolean wantToClickOnThreeDot,int searchKeyColumnIndex, boolean wantToClickOnSearchKey) throws InterruptedException
  		{
  			clickOnBtnWorkoutListing();
  			Thread.sleep(1000);
  			searchBox_1_RU(driver, searchKey);
  			Thread.sleep(5000);
  			boolean flag = isNoWorkoutMatchedDisplayed();
  			if(!flag) {
  	  			findWorkoutFromRowListAndClickOnThreeDot(workoutName, searchKeyColumnIndex, wantToClickOnThreeDot, wantToClickOnSearchKey);
  	  		
  			}else {
  				softAssert.assertTrue(false,"Workout you are searching is not present");
  			}
  			softAssert.assertAll();
  		}
  		
  		
  		//TO ACTIVATE THE WORKOUT
  		public PO_Main_HomePage activateWorkout() throws InterruptedException
  		{
  			Action_Activate.activate(driver, alertMsgWorkoutActivated);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO DEACTIVATE THE WORKOUT
  		public PO_Main_HomePage deactivateWorkout() throws InterruptedException
  		{
  			Action_Deactivate.deactivate(driver, alertMsgWorkoutDeActivated);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO ASSIGN WORKOUT TO DATE
  		public PO_Main_HomePage assignWorkoutToDate(String dateValue,String wantToClickOnDateOrDateBox,String workoutName) throws InterruptedException 
  		{
  			boolean bol = FindDateInCalendar.findDateInCallendar(driver, dateValue, monthYearAddress,address_BackStarTag_1_RU,address_NextStarTag_1_RU, calendarDateList,wantToClickOnDateOrDateBox);
  			if(bol) 
  			{
  				selectWorkout(workoutName);
  				if(clickOnAdd_RU())
  				{
  					String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  	  				if(alertMsg.equals(alertMsgWorkoutAssigned)) {
  	  					logger.info("Workout assigened");
  	  					softAssert.assertEquals(alertMsg, alertMsgWorkoutAssigned,"Workout assigend successfully");
  	  				}else if(alertMsg.equals(alertMsgWorkoutAlreadyExist)){
  	  					softAssert.assertTrue(false,"Workout already assigned");
  	  				}else {
  	  					softAssert.assertTrue(false,"Workout not assigned");
  	  				}
  				}
  				clickOnBtnCross_1_RU();
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		//TO REMOVED ASSIGN WORKOUT FROM THE DATE
  		public PO_Main_HomePage removeWorkoutFromDate(String dateValue,String wantToClickOnDateOrDateBox,String workoutName,String searchKey,int searchKeyColumnIndex, boolean wantToClickOnDeleteBox, boolean wantToclickOnFindSearckKey) throws InterruptedException 
  		{
  			boolean bol = FindDateInCalendar.findDateInCallendar(driver,dateValue, monthYearAddress,address_BackStarTag_1_RU,address_NextStarTag_1_RU, calendarDateList,wantToClickOnDateOrDateBox);
  			if(bol) 
  			{
  				FindDeleteBoxFromListAndClick.findDeleteBoxButtonAndClick(assignedWorkoutListAddress, assignedWorkoutList, driver, searchKey,searchKeyColumnIndex, wantToClickOnDeleteBox, wantToclickOnFindSearckKey);
  				if(clickOnBtnYes_RU(driver))
  				{
  					String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  	  				if(alertMsg.equals(alertMsgWorkoutRemoved)) {
  	  					logger.info("Workout assigened");
  	  					softAssert.assertEquals(alertMsg, alertMsgWorkoutRemoved,"Workout removed from the assigned date successfully");
  	  				}else {
  	  					softAssert.assertTrue(false,"Workout not removed from the assigned date successfully.");
  	  				}
  				}
  				clickOnBtnCross_1_RU();
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		
  	

}
