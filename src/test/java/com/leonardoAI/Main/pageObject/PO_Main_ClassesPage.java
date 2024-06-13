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
import com.leonardoAI.projectUtility.DatePicker;
import com.leonardoAI.projectUtility.FindDateInCalendar;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_ClassesPage extends ReUseAbleElement {
		
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
		public PO_Main_ClassesPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgRegionCreatedSuccessfully = "Class Created Successfully";
		public String alertMsgClassUpdated = "Class information updated successfully";
		public String alertMsgClassActivated = "Class Activated successfully";
		public String alertMsgClassDeactivated = "Class Deactivated successfully";
		public String alertMsgClassArchived = "Class Archived successfully";
		public String alertMsgClassRestored = "Class Restored Successfully";
		public String alertMsgMemberAccountPaused = "member account is paused";
		public String alertMsgUserAddedSuccessfully = "Users added successfully.";
		public String alertMsgUserRemovedFromClass = "User removed successfully.";
		public String alertMsgCancelClass = "Class Cancelled successfully";
		public String alertMsgNoClassAvailabe = "There is no class for this date and time";
		public String alertMsgClassBlackout = "Class Blackout successfully";
		public String alertMsgClassRemovedFromBlackout = "Class Removed from Blackout";
		public String alertMsgClassOverride = "Class Override successfully";
		
		
		
		//======START======PAGE OBJECT FOR ADD CLASS AND ACTOIN METHODS==========//
		
		public String monthYearAddress = "(//span[@class='rbc-toolbar-label'])[1]";
		
		//BUTTON ADD CLASS
  		@FindBy(xpath = "(//span[normalize-space()='Add Class'])[1]")
  		@CacheLookup
  		public WebElement btnAddClass;
  		public void clickOnBtnAddClass() throws InterruptedException {
  			btnAddClass.click();
  			logger.info("Clicked on the btn btnAddClass");
  			Thread.sleep(1000);
  		}
		
  		
  		//THREE DOT ICON BUTTON
  		@FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root'])[3]")
  		@CacheLookup
  		public WebElement btnIconThreeDot;
  		public void clickOnBtnThreeDot() throws InterruptedException {
  			Thread.sleep(2000);
  			if(btnIconThreeDot.isDisplayed()) {
  				btnIconThreeDot.click();
  	  			logger.info("Clicked on the btn btnIconThreeDot");
  	  			Thread.sleep(1000);
  			}else {
  				logger.info("Three dot button not present");
  			}
  		}
  		
  		//BUTTON ADD MEMBER IN THE CLASS
  		@FindBy(xpath = "(//span[normalize-space()='Add Member'])[1]")
  		@CacheLookup
  		public WebElement btnAddMemberInClass;
  		public void clickOnBtnAddMemberInClass() throws InterruptedException {
  			Thread.sleep(2000);
			btnAddMemberInClass.click();
  			logger.info("Clicked on the btn btnAddMemberInClass");
  			Thread.sleep(1000);
  			
  		}
  		
	  	//CANCEL CLASS ACTION BUTTON
		@FindBy(xpath = "(//div[normalize-space()='Cancel Class'])[1]")
		@CacheLookup
		public WebElement btnCacelClass;
		public void clickOnBtnCancelClass() throws InterruptedException {
			Thread.sleep(2000);
			btnCacelClass.click();
			logger.info("Clicked on the btn btnCacelClass");
			Thread.sleep(1000);
			
		}
		
	  	//INNER CANCEL CLASS ACTION BUTTON
		@FindBy(xpath = "//span[@class='MuiButton-label'][normalize-space()='Cancel Class']")
		@CacheLookup
		public WebElement btnInnerCacelClass;
		public void clickOnBtnInnerCancelClass() throws InterruptedException {
			Thread.sleep(2000);
			btnInnerCacelClass.click();
			logger.info("Clicked on the btn btnInnerCacelClass");
			Thread.sleep(1000);
			
		}
		
		//CANCEL CLASS REASON
  		@FindBy(xpath = "//textarea[@placeholder='Reason']")
  		@CacheLookup
  		public WebElement textAreaCancelClassReason;
  		public void setCancelClassReason(String cancelClassReason) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(textAreaCancelClassReason));
  			textAreaCancelClassReason.sendKeys(Keys.CONTROL,"a");
  			textAreaCancelClassReason.sendKeys(Keys.DELETE);
  			textAreaCancelClassReason.sendKeys(cancelClassReason);
  			logger.info("Entered the cancel class reason: "+cancelClassReason);
  			Thread.sleep(300);
  		}
  		
  		
		//INNER BLACKOUT THE SCHEDULE CLASS ACTION BUTTON
		@FindBy(xpath = "//span[@class='MuiButton-label'][normalize-space()='Blackout Class']")
		@CacheLookup
		public WebElement btnInnerBlackoutClass;
		public void clickOnBtnInnerBlackoutClass() throws InterruptedException {
			try {
				Thread.sleep(2000);
				btnInnerBlackoutClass.click();
				logger.info("Clicked on the btnInnerBlackoutClass");
				Thread.sleep(1000);
			}catch(Exception e){
				logger.info("Exception from : "+e.getMessage());
				softAssert.assertTrue(false,"You want to blackout the class, but {blackout} button not present");
			
			}
			
		}
			
		
	  	//BLACKOUT CLASS ACTION BUTTON
		@FindBy(xpath = "(//div[normalize-space()='Blackout Class'])[1]")
		@CacheLookup
		public WebElement btnBlackoutClass;
		public void clickOnBtnBlackoutClass() throws InterruptedException {
			try {
				Thread.sleep(2000);
				btnBlackoutClass.click();
				logger.info("Clicked on the btnBlackoutClass");
				Thread.sleep(1000);
			}catch(Exception e) {
				logger.info("Exception from : "+e.getMessage());
				softAssert.assertTrue(false,"You want to blackout the class, but {blackout} button not present");
			
			}
			
		}
		
		//REMOVED THE CLASS  FROM BLACKOUT ACTION BUTTON
		@FindBy(xpath = "(//div[normalize-space()='Remove from Blackout'])[1]")
		@CacheLookup
		public WebElement btnRemoveClassFromBlackout;
		public void clickOnBtnRemoveFromBlackout() throws InterruptedException {
			try {
				Thread.sleep(2000);
				btnRemoveClassFromBlackout.click();
				logger.info("Clicked on the btnRemoveClassFromBlackout");
				Thread.sleep(1000);
			} catch(Exception e) {
				logger.info("Exception from : "+e.getMessage());
				softAssert.assertTrue(false,"You want to remove a form the blackout, but {remove from blackout} button not present");
			}
			
		}
		
		//INNER REMOVED THE CLASS  FROM BLACKOUT ACTION BUTTON
		@FindBy(xpath = "(//span[normalize-space()='Remove from Blackout'])[1]")
		@CacheLookup
		public WebElement btnInnerRemoveFromBlackoutClass;
		public void clickOnBtnInnerRemoveFromBlackoutClass() throws InterruptedException {
			try {
				Thread.sleep(2000);
				btnInnerRemoveFromBlackoutClass.click();
				logger.info("Clicked on the btnInnerRemoveFromBlackoutClass");
				Thread.sleep(1000);
			}catch(Exception e) {
				logger.info("Exception from : "+e.getMessage());
				softAssert.assertTrue(false,"You want to remove a form the blackout, but {remove from blackout} button not present");
			}
			
		}
			
	  	//BUTTON OVER RIDE CLASS ACTION BUTTON
		@FindBy(xpath = "(//div[normalize-space()='Override Class'])[1]")
		@CacheLookup
		public WebElement btnOverRideClass;
		public void clickOnBtnOverrideClass() throws InterruptedException {
			try {
				Thread.sleep(2000);
				btnOverRideClass.click();
				logger.info("Clicked on the btnOverRideClass");
				Thread.sleep(1000);
			}catch(Exception e) {
				logger.info("Exception from: "+e.getMessage());
				softAssert.assertTrue(false,"You want to override a class, but {override class} button not present");
			}
			
		}
		
		
  		//TEXT FIELD CLASS NAME
  		@FindBy(xpath = "//input[@placeholder='Enter Class Name']")
  		@CacheLookup
  		public WebElement fieldClassName;
  		public void setClassName(String className) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldClassName));
  			fieldClassName.sendKeys(Keys.CONTROL,"a");
  			fieldClassName.sendKeys(Keys.DELETE);
  			fieldClassName.sendKeys(className);
  			logger.info("Entered the fieldClassName: "+className);
  			Thread.sleep(300);
  		}
  	
  		
  		//TEXT FIELD CLASS CAPACITY
  		@FindBy(xpath = "//input[contains(@name,'capacity')]")
  		@CacheLookup
  		public WebElement fieldClassCapacity;
  		public void setClassCapacity(String classCapacity) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldClassCapacity));
  			fieldClassCapacity.sendKeys(Keys.CONTROL,"a");
  			fieldClassCapacity.sendKeys(Keys.DELETE);
  			fieldClassCapacity.sendKeys(classCapacity);
  			logger.info("Entered the fieldClassCapacity: "+classCapacity);
  			Thread.sleep(300);
  		}
  	
  		//TO SELECT THE LOCATION
  		public void selectLocation(String classLocation) throws InterruptedException {
  			//ruae.clickOnDropdown_3_RU();
  			driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])[3]")).click();
  			//Will avoid the stale element reference
  			Thread.sleep(500);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,classLocation);
  			Thread.sleep(500);
  		}
  		
  		//TO SELECT THE LOCATION
  		public void selectClassLocation(String classLocation) throws InterruptedException {
  			//ruae.clickOnDropdown_3_RU();
  			driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])[1]")).click();
  			//Will avoid the stale element reference
  			Thread.sleep(500);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,classLocation);
  			Thread.sleep(500);
  		}
  		
  		
  		//TO SELECT THE INITIAL COACH
  		public void selectCoach(String caochName) throws InterruptedException {
  			//ruae.clickOnDropdown_3_RU();
  			
  			StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTraceElement[2].getMethodName();
  			logger.info("FindDateInCalendar caller method name: "+callerMethodName);
  			
  			if(callerMethodName.equals("overrideClass")) {
  				driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])[1]")).click();
  			}else {
  				driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])[4]")).click();
  			}
  			
  			//Will avoid the stale element reference
  			Thread.sleep(500);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,caochName);
  			Thread.sleep(500);
  		}
  		
  		//TO SELECT THE INITIAL COACH
  		public void selectClassCoach(String caochName) throws InterruptedException {
  			//ruae.clickOnDropdown_3_RU();
  			driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])[2]")).click();
  			//Will avoid the stale element reference
  			Thread.sleep(500);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,caochName);
  			Thread.sleep(500);
  		}
  		
  		
  		//TEXT FIELD CANCELATION CUTOFF TIME
  		@FindBy(xpath = "//input[@placeholder='Cancellation Cut-Off Time']")
  		@CacheLookup
  		public WebElement fieldCancelationCutOffTime;
  		public void setCancelationCutoffTime(String cancelationCutOffTime) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldCancelationCutOffTime));
  			fieldCancelationCutOffTime.sendKeys(Keys.CONTROL,"a");
  			fieldCancelationCutOffTime.sendKeys(Keys.DELETE);
  			fieldCancelationCutOffTime.sendKeys(cancelationCutOffTime);
  			logger.info("Entered fieldCancelationCutOffTime: "+cancelationCutOffTime);
  			Thread.sleep(300);
  		}
  		
  		//WAIT LIST
  		@FindBy(xpath = "//input[contains(@name,'waitListSpots')]")
  		@CacheLookup
  		public WebElement fieldWaitLisSpot;
  		public void setWaitListSpot(String waitListSpot) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldCancelationCutOffTime));
  			fieldWaitLisSpot.sendKeys(Keys.CONTROL,"a");
  			fieldWaitLisSpot.sendKeys(Keys.DELETE);
  			fieldWaitLisSpot.sendKeys(waitListSpot);
  			logger.info("Entered fieldWaitLisSpot: "+waitListSpot);
  			Thread.sleep(300);
  		}
  		
  		//TEXT CREATE CLASS SCHEDULE
  		@FindBy(xpath = "//div[text()=\"Create a Class Schedule \"]")
  		@CacheLookup
  		public WebElement textCreatClassShedule;
  		public boolean isTextCreateClassShedulePresent() throws InterruptedException {
  			boolean flag = false;
  			try {
  				if(textCreatClassShedule.isDisplayed()){
  					flag = true;
  					logger.info("TextCreatClassShedule is displayed: "+flag);
  	  	  			Thread.sleep(300);
  				}else {
  					
  				}
  			}catch(Exception e) {
  				logger.info("Exception from : "+e.getMessage());
  			}
  			return flag;
  		}
  		

  	
  		//TO SELECT THE CLASS START DATE
  		public void setClassStartDate(String classStartDate,int dateIconNumber) throws InterruptedException {
  			//clickOnChangeDateIcon_1_RU();
  			DatePicker.setDateByDirectSendingDateVauleInTheTextBox(driver,classStartDate,dateIconNumber);
  		    Thread.sleep(1000);
  		}
  		
  		
  		//TO SELECT THE CLASS END DATE
  		public void setClassEndDate(String classEndDate, int dateIconNumber) throws InterruptedException {
  			//clickOnChangeDateIcon_2_RU();
  			DatePicker.setDateByDirectSendingDateVauleInTheTextBox(driver,classEndDate,dateIconNumber);
  		    Thread.sleep(1000);
  		}
  		
  		//TO SELECT CLASS DAYS
  		public void selectClassDays(String dayName) throws InterruptedException {
  			ruae.clickOnDropdownBoxAddress_1_RU();
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,dayName);
  			Thread.sleep(500);
  		}
  		
  		//TO SELECT CLASS TIME
  		public void selectClassTime(WebDriver driver, String hours,String minutes, String AmPm) throws InterruptedException {
  			setTimeWithoutUsingTimePicker_RU(driver, hours, minutes, AmPm);
  			Thread.sleep(500);
  		}
  		
  		//CALENDAR DATE LIST, P360
  		@FindBy(xpath = "//div[@role='rowgroup']//a[@role='cell']")
  		@CacheLookup
  		public List<WebElement> calendarDateList;
  		public String calendarDateListAddress = "//div[@role='rowgroup']//a[@role='cell']";
  		public void clickOnCalendarDate(String dateOnly) throws InterruptedException {
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,calendarDateListAddress,dateOnly);
  			Thread.sleep(1000);
  		}
  		
  		
  		//CLASS EVENT LIST, P360
  		@FindBy(xpath = "//div[contains(@class,'rbc-events-container')]//div[@class='rbc-event']")
  		@CacheLookup
  		public List<WebElement> classEventList;
  		public String classEventListAddress = "//div[contains(@class,'rbc-events-container')]//div[@class='rbc-event']";
  		public void selectEventFromCallender(String eventKey) throws InterruptedException {
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,classEventListAddress,eventKey);
  			Thread.sleep(1000);
  		}
  		
  		
  	
  		//BUTTON ADD CLASS INSIDE CALENDER
  		@FindBy(xpath = "(//span[normalize-space()='Add Class'])[1]")
  		@CacheLookup
  		public WebElement btnAddClassInSideCalendar;
  		public void clickOnBtnAddClassInCalendar() throws InterruptedException {
  			btnAddClassInSideCalendar.click();
  			logger.info("Clicked on the btnAddClassInSideCalendar");
  			Thread.sleep(1000);
  		}
  		
  		
  		//BUTTON ADD
  		@FindBy(xpath = "(//span[normalize-space()='Add'])[1]")
  		@CacheLookup
  		public WebElement btnAdd;
  		public void clickOnBtnAdd() throws InterruptedException {
  			btnAdd.click();
  			logger.info("Clicked on the btn btnAdd");
  			Thread.sleep(1000);
  		}
  		
  		
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List<WebElement> classesList;
  		//PACKAGE CATEGORY ROW LIST ADDRESS AND ACTION METHODS
  		public String classesRowList_address = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findClassFromRowListAndClickOnThreeDot(String className, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				//listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(packageCategoryRowList,driver, packageCategoryTitle, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(classesRowList_address,classesList,driver, className, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findClassFromRowListAndClickOnThreeDot: "+e.getMessage());
				softAssert.assertTrue(false,"not click on the three dot action button");
			}
			return listRowCount;
  		}
  		
  		//FIND REGISTRED USER IN THE CLASS AND CLICK ON THREE DOT
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List<WebElement> classRegisteredUserList;
  		//PACKAGE CATEGORY ROW LIST ADDRESS AND ACTION METHODS
  		public String classRegisteredUserList_address = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findClassRegisteredUserFromRowListAndClickOnThreeDot(String classRegisteredUserName, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				//listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(packageCategoryRowList,driver, packageCategoryTitle, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(classRegisteredUserList_address,classRegisteredUserList,driver, classRegisteredUserName, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findClassFromRowListAndClickOnThreeDot: "+e.getMessage());
				softAssert.assertTrue(false,"not click on the three dot action button");
			}
			return listRowCount;
  		}
  		
  			
  		//TEXT NO CLASSES MATCHED TO CURRENT APPLIED FILTER
  		@FindBy(xpath = "//*[.='No Classes Matches Current Filter']")
  		@CacheLookup
  		public WebElement noClassesMatchedWithApplieddFilter;
  		public boolean  isNoClassesMatchedDisplayed() throws InterruptedException {
  			boolean flag = false;
  			try {
  				if(noClassesMatchedWithApplieddFilter.isDisplayed()) {
  					flag = true;
  					softAssert.assertTrue(flag,"Class you are searching is not found");
  					clickOnP360Logo_RU();
  				}
  			}catch(Exception e) {
  				flag = false;
  				logger.info("Searched classes matched with the applied fileter");
  				logger.info("Exception from : "+e.getMessage());
  			}
  			
  			return flag;
  		}
  		
  	
  		
  		
  		//======END======PAGE OBJECT FOR ADD CLASS AND CLASS SHEDULE ACTOIN METHODS==========//
  				
  				
  				
  		//TO ADD CLASS
  		public PO_Main_HomePage addClass(String className,String classLocation, String caochName, String classCapacity,String cancelationCutOffTime, String waitListSpot, String description, String classStartDate,String classEndDate,String dayName,String hours,String minutes,String AmPm) throws InterruptedException
  		{
  			clickOnBtnAddClass();
  			setClassName(className);
  			selectLocation(classLocation);
  			selectCoach(caochName);
  			setClassCapacity(classCapacity);
  			setCancelationCutoffTime(cancelationCutOffTime);
  			if(clickOnCheckBox_1_RU()) {
  				setWaitListSpot(waitListSpot);
  			}
  			setDescription_1_RU(description);
  			if(clickOnBtnNext_1_RU()) {
  				
  				if(isRequiredOrInvalidMessageDisplayed_RU()) {
  					clickOnCancelButton_1_RU();
  				}else {
  					Thread.sleep(2000);
  		  			if(isTextCreateClassShedulePresent()) {
  		  				setClassStartDate(classStartDate,1);
  		  				setClassEndDate(classEndDate,2);
  		  				selectClassDays(dayName);
  		  				selectClassTime(driver, hours, minutes, AmPm);
  		  				clickOnBtnAdd();
  		  			}
  				}
  			}
  			
  			
  			if(clickOnBtnSave_1_RU()) 
  			{
  				if(isRequiredOrInvalidMessageDisplayed_RU()) {
  	  				Thread.sleep(1000);
  	  				clickOnCancelButton_1_RU();
  	  				softAssert.assertTrue(false,"Required or Invalid Message Displayed");
  				}else {
  					Thread.sleep(100);
  	  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  	  				if(alertMsg.equals(alertMsgRegionCreatedSuccessfully)) {
  	  					softAssert.assertEquals(alertMsg, alertMsgRegionCreatedSuccessfully,"Checks class created successfully");
  	  				}
  	  			}
  			}
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//FIND CLASSES AND CLICK ON THREE DOT BUTTON
  		public void findClassesAndClickOnThreeDot(String SearchKey_Classes,int searchKeyColumnIndex,boolean wantToClickOnThreeDot,boolean wantToclickOnFindSearckKey,String coachName, String classLocation) throws InterruptedException
  		{
  			logger.info("Methods called: findClassesAndClickOnThreeDot");
  			jsExecutor.executeScript("window.scrollBy(0, 5);");
  			Thread.sleep(2000);
  			searchBox_1_RU(driver,SearchKey_Classes);
  			Thread.sleep(2000);
  			selectClassLocation(classLocation);
  			Thread.sleep(1000);
  			selectClassCoach(coachName);
  			Thread.sleep(2000);
  			boolean flag = isNoClassesMatchedDisplayed();
  			if(!flag) {
  				int classesRowListCount = findClassFromRowListAndClickOnThreeDot(SearchKey_Classes,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
  	  			Thread.sleep(1000);
  	  			logger.info("Class matched list count: "+classesRowListCount);
  	  			
  			}
  			
  			Thread.sleep(2000);
  			softAssert.assertAll();
  		}
  		
  		//TO ACTIVATE THE CLASSES
		public PO_Main_HomePage activateClasses() throws InterruptedException
		{	logger.info("Methods called: activateClasses ");

			String restoreClass_address = "//div[contains(text(),'Activate Class')]";
			boolean flag = clickOnActionListButton(restoreClass_address);
			if(flag) {
				driver.findElement(By.xpath("(//span[.='Activate Class'])[2]")).click();
			}
		
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
		
		//TO DEACTIVATE THE CLASSES
		public PO_Main_HomePage deActivateClasses() throws InterruptedException
		{
			logger.info("Methods called: deActivateClasses ");
			String restoreClass_address = "//div[contains(text(),'Deactivate Class')]";
			boolean flag = clickOnActionListButton(restoreClass_address);
			if(flag) {
				driver.findElement(By.xpath("(//span[.='Deactivate Class'])[2]")).click();
			}
			
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
		
		//TO ARCHIVE THE CLASSES
		public PO_Main_HomePage archiveClasses() throws InterruptedException
		{
			logger.info("Methods called: archiveClasses ");
			String restoreClass_address = "//div[contains(text(),'Archive Class')]";
			boolean flag = clickOnActionListButton(restoreClass_address);
			if(flag) {
				driver.findElement(By.xpath("(//span[.='Archive Class'])[2]")).click();
			}
			
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
		
		//TO RESTORE THE CLASSES
		public PO_Main_HomePage restoreClasses() throws InterruptedException
		{
			logger.info("Methods called: restoreClasses ");
			String restoreClass_address = "//div[contains(text(),'Restore Class')]";
			boolean flag = clickOnActionListButton(restoreClass_address);
			if(flag) {
				driver.findElement(By.xpath("(//span[.='Restore Class'])[2]")).click();
			}
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
		
		//TO ADD CLASS/OVERRIDE CLASS
		public PO_Main_HomePage calendarClasses() throws InterruptedException
		{
			logger.info("Methods called: calendarClasses ");
			String calendar_address = "//div[contains(text(),'Calendar')]";
			boolean flag = clickOnActionListButton(calendar_address);
			if(flag) {
				clickOnBtnAddClassInCalendar();
				clickOnCancelButton_1_RU();
			}
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
		
		//ADD MEMBER IN THE CLASS
		public PO_Main_HomePage addMemberInClass(String searchKey_memberEmail,String dateValue, String eventKey) throws InterruptedException
		{
			
			String calendarClass_address = "//div[contains(text(),'Calendar')]";
			clickOnActionListButton(calendarClass_address);
			boolean bol = FindDateInCalendar.findDateInCallendar(driver, dateValue, monthYearAddress,address_BackStarTag_1_RU,address_NextStarTag_1_RU, calendarDateList,"date");
			if(bol) {
				selectEventFromCallender(eventKey);
			}else {
				logger.info("Event page not opened");
			}
			
			if(bol)
			{
				clickOnBtnAddMemberInClass();
				searchBox_1_RU(driver,searchKey_memberEmail);
				clickOnCheckBox_1_RU();
				boolean flag = clickOnBtnSave_1_RU();
				if(flag) 
				{
					String alertMsg = snakeAlertMessagesDisplayedContent_RU();
	  				if(alertMsg.contains(alertMsgMemberAccountPaused)) {
	  					logger.info("You want to assign Member into the classs is already paused");
	  					softAssert.assertTrue(false, "You want to assign Member into the classs is already paused");
	  					clickOnCancelButton_1_RU();
	  				}else if(alertMsg.equals(alertMsgUserAddedSuccessfully)) {
	  					logger.info("Users assigned into the class");
	  				}else {
	  					softAssert.assertTrue(false,"You want add a member in the class but member not added");
	  				}
				}
			}
			
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
				
		//VIEW CLASS REGISTRED MEMBER DETAILS
		public PO_Main_HomePage veiwClassRegisteredMemberDetails(String searchKey_memberEmail,String dateValue, String eventKey,String SearchKey_ClassRegisteredUser, int searchKeyColumnIndex_ClassRegisteredUser, boolean wantToClickOnThreeDot_ClassRegisteredUser,boolean wantToclickOnFindSearckKey_ClassRegisteredUser) throws InterruptedException
		{
			
			String calendarClass_address = "//div[contains(text(),'Calendar')]";
			clickOnActionListButton(calendarClass_address);
			boolean bol = FindDateInCalendar.findDateInCallendar(driver, dateValue, monthYearAddress,address_BackStarTag_1_RU,address_NextStarTag_1_RU, calendarDateList,"date");
			if(bol) {
				selectEventFromCallender(eventKey);
				Thread.sleep(1000);
				int registeredUserRowListCount = findClassRegisteredUserFromRowListAndClickOnThreeDot(SearchKey_ClassRegisteredUser,searchKeyColumnIndex_ClassRegisteredUser,wantToClickOnThreeDot_ClassRegisteredUser,wantToclickOnFindSearckKey_ClassRegisteredUser);
  	  			Thread.sleep(1000);
  	  			logger.info("Class Registered user matched list count: "+registeredUserRowListCount);
  	  			
		  		String viewUserDetailsActionButton = "//div[contains(text(),'View Member Details')]";
				clickOnActionListButton(viewUserDetailsActionButton);
				if(driver.getPageSource().contains("Membership Insights")) {
					softAssert.assertTrue(true);
				}else {
					softAssert.assertTrue(false,"User details not displayed");
				}
			
			}else {
				logger.info("Event page not opened");
			}
			
			
			
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
				
			
		//REMOVE USERS FORM REGISTRED CLASS
		public PO_Main_HomePage removeUsersFromRegisteredClass(String searchKey_memberEmail,String dateValue, String eventKey,String SearchKey_ClassRegisteredUser, int searchKeyColumnIndex_ClassRegisteredUser, boolean wantToClickOnThreeDot_ClassRegisteredUser,boolean wantToclickOnFindSearckKey_ClassRegisteredUser) throws InterruptedException
		{
			
			String calendarClass_address = "//div[contains(text(),'Calendar')]";
			clickOnActionListButton(calendarClass_address);
			boolean bol = FindDateInCalendar.findDateInCallendar(driver, dateValue, monthYearAddress,address_BackStarTag_1_RU,address_NextStarTag_1_RU, calendarDateList, "date");
			if(bol) {
				selectEventFromCallender(eventKey);
				Thread.sleep(1000);
				int registeredUserRowListCount = findClassRegisteredUserFromRowListAndClickOnThreeDot(SearchKey_ClassRegisteredUser,searchKeyColumnIndex_ClassRegisteredUser,wantToClickOnThreeDot_ClassRegisteredUser,wantToclickOnFindSearckKey_ClassRegisteredUser);
  	  			Thread.sleep(1000);
  	  			logger.info("Class Registered user matched list count: "+registeredUserRowListCount);
  	  			
		  		String btnRemoveUsersFromRegisteredClass = "//div[contains(text(),'Remove')]";
				clickOnActionListButton(btnRemoveUsersFromRegisteredClass);
				boolean clickOnBtnRemove = clickOnBtnRemove_1_RU();
				if(clickOnBtnRemove) {
					String alertMsg = snakeAlertMessagesDisplayedContent_RU();
	  				if(alertMsg.contains(alertMsgUserRemovedFromClass)) {
	  					logger.info("Users removed from the registered class");
	  				}else {
	  					softAssert.assertTrue(false,"You want remove users from the registered class, but it not removed");
	  					clickOnCancelButton_1_RU();
	  				}
				}
			
			}
			
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
				
			
				
				
		//METHODS TO CLICK ON THE ACTION BUTTON
		public boolean clickOnActionListButton(String yourAddress)
		{
			String btn_address = yourAddress;
			int count =0;
			boolean flag = false;
			while(true) {
				count++;
				try {
					WebElement btnYour = driver.findElement(By.xpath("("+btn_address+")["+count+"]"));
					logger.info("Your button address: "+btnYour);
					if(btnYour.isDisplayed() && btnYour.isEnabled()) {
						logger.info("Clicked on your button address: "+btnYour.getText());
						action.moveToElement(btnYour).build().perform();
						Thread.sleep(500);
						btnYour.click();
						flag = true;
						Thread.sleep(1000);
						break;
					}
				}catch(Exception e) {
					logger.info("Exception from clickOnActionListButton :"+e.getMessage());
				}
				if(count>20) {
					break;
				}
			}
			return flag;
		}
		
		//FIND SCHEDULE CLASSES
		public void findScheduleClasses(String dateValue, String eventKey) throws InterruptedException
		{
			
			String calendarClass_address = "//div[contains(text(),'Calendar')]";
			clickOnActionListButton(calendarClass_address);
			boolean bol = FindDateInCalendar.findDateInCallendar(driver, dateValue, monthYearAddress,address_BackStarTag_1_RU,address_NextStarTag_1_RU, calendarDateList, "date");
			if(bol) {
				selectEventFromCallender(eventKey);
			}
			softAssert.assertAll();
		}
		
		//TO CANCEL THE SCHEDULED CLASS
		public PO_Main_HomePage cancelScheduleClass(String dateValue, String eventKey, String cancelClassReason) throws InterruptedException
		{
			findScheduleClasses(dateValue, eventKey);
			
			//TAKE ACTION ON SCHEDULED CLASSES
			clickOnBtnThreeDot();
			clickOnBtnCancelClass();
			setCancelClassReason(cancelClassReason);
			clickOnBtnInnerCancelClass();
			
			String alertMsg = snakeAlertMessagesDisplayedContent_RU();
			if(alertMsg.equals(alertMsgCancelClass)) {
				logger.info("Class canceled");
			}else {
				softAssert.assertTrue(false,"You want add a member in the class but member not added");
				clickOnCancelButton_1_RU();
			}
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
				
		}
		
		//TO BLACKOUT THE SCHEDULE CLASS
		public PO_Main_HomePage blackOutScheduleClass(String dateValue, String eventKey) throws InterruptedException
		{
			findScheduleClasses(dateValue, eventKey);
			
			//TAKE ACTION ON SCHEDULED CLASSES
			clickOnBtnThreeDot();
			clickOnBtnBlackoutClass();
			clickOnBtnInnerBlackoutClass();
			
			String alertMsg = snakeAlertMessagesDisplayedContent_RU();
			if(alertMsg.equals(alertMsgClassBlackout)) {
				logger.info("Class blackout");
			}else if(alertMsg.equals(alertMsgNoClassAvailabe)) {
				logger.info("You cant blackout override class");
				softAssert.assertTrue(false,"You can't blackout the override class ");
			}else {
				softAssert.assertTrue(false,"You want to blackout the class, but it wan't done");
				clickOnCancelButton_1_RU();
			}
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
				
		}
		
		//TO BLACKOUT THE SCHEDULE CLASS
		public PO_Main_HomePage removeClassFromBlackout(String dateValue, String eventKey) throws InterruptedException
		{
			findScheduleClasses(dateValue, eventKey);
			
			//TAKE ACTION ON SCHEDULED CLASSES
			clickOnBtnThreeDot();
			clickOnBtnRemoveFromBlackout();
			clickOnBtnInnerRemoveFromBlackoutClass();
			
			String alertMsg = snakeAlertMessagesDisplayedContent_RU();
			if(alertMsg.equals(alertMsgClassRemovedFromBlackout)) {
				logger.info("Class removed from blackout");
			}else {
				softAssert.assertTrue(false,"You want to remove the class from the blackout, but it wan't done");
				clickOnCancelButton_1_RU();
			}
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
				
		}
		
		

		//TO BLACKOUT THE SCHEDULE CLASS
		public PO_Main_HomePage overrideClass(String dateValue, String eventKey,String caochName,String classCapacity,String cancelationCutOffTime, String classDescription, String waitListSpot) throws InterruptedException
		{
			//TO FIND SCHEDULE CLASS
			findScheduleClasses(dateValue, eventKey);
			
			//TAKE ACTION ON SCHEDULED CLASSES
			clickOnBtnThreeDot();
			clickOnBtnOverrideClass();
			selectCoach(caochName);
			setClassCapacity(classCapacity);
			setCancelationCutoffTime(cancelationCutOffTime);
			clickOnCheckBox_1_RU();
			setWaitListSpot(waitListSpot);
			clickOnCheckBox_2_RU();
			setDescription_1_RU(classDescription);
			boolean flag = clickOnBtnSave_1_RU();
			
			if(flag) {
				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
				if(alertMsg.equals(alertMsgClassOverride)) {
					logger.info("Class Override successfully");
				}else {
					softAssert.assertTrue(false,"You want to override a class, but it wan't done");
					clickOnCancelButton_1_RU();
				}
			}else {
				clickOnCancelButton_1_RU();
				softAssert.assertTrue(false,"You want to override a class, but it wan't done");
			}
			
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
				
		}
		
		
		
  		
}
