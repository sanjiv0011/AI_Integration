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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;
import com.leonardoAI.actions.Action_Activate;
import com.leonardoAI.actions.Action_Archive;
import com.leonardoAI.actions.Action_Deactivate;
import com.leonardoAI.actions.Action_Edit;
import com.leonardoAI.actions.Action_Restore;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;

public class PO_Main_UserLablesPage extends ReUseAbleElement {
		
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
		public PO_Main_UserLablesPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);
		}

		
		//ALERT MESSAGES
		public String pleaseEnterLabelName = "Please enter label.";
		public String userLabelAdded = "User label Added.";
		public String userLabelChanged = "User label changes saved.";
		public String userLabelDeactivate = "Label Deactivated.";
		public String userLabelArchived = "Label Archived.";
		public String userLabelRestored = "Label restored.";
		public String userLabelActivated = "Label Activated.";
		
		
		
		//======START======PAGE OBJECT FOR USER LEBELS AND ACTOIN METHODS==========//
		@FindBy(xpath = "(//span[normalize-space()='Add User Label'])[1]")
		@CacheLookup
		public WebElement btnAddUserLabels;
		public void clickOnBtnUserLabels() throws InterruptedException {
			btnAddUserLabels.click();
			Thread.sleep(3000);
			logger.info("Clicked on the btnAddUserLables");
			
		}
		
		@FindBy(xpath = "(//input[@placeholder='Enter User Label'])[1]")
		@CacheLookup
		public WebElement textFieldUserLabelName;
		public void setLablesName(String userLabelName) throws InterruptedException {
			textFieldUserLabelName.sendKeys(Keys.CONTROL,"a");
			textFieldUserLabelName.sendKeys(Keys.DELETE);
			textFieldUserLabelName.sendKeys(userLabelName);
			Thread.sleep(3000);
			logger.info("Entered labels name");
			
		}
  		
  	
  		//USER LABELS LIST 
  		@FindBy(xpath = "//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List<WebElement> listUserLabels;
  		
  		//USER LABELS ROW LIST ADDRESS AND ACTION METHODS
  		public String listUsreLabels_address = "//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findUserLabelsFromRowListAndClickOnThreeDot(String userLabelsName,String searchKey, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			searchBox_1_RU(driver,searchKey);
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(listUsreLabels_address,listUserLabels,driver, searchKey, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findUserLabelsFromRowListAndClickOnThreeDot: "+e.getMessage());
			}
			return listRowCount;
  		}
  		//======END======PAGE OBJECT FOR ADD USERS LEBELS ACTOIN METHODS==========//
  		
  		
  		//TO ADD AND UPDATE THE USER LABELS
  		public PO_Main_HomePage  addOrChangeUserLabels(String userLabelsName,String searchKey, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws Throwable 
  		{
  			StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTrace[2].getMethodName();
  			logger.info("Caller methods name: "+callerMethodName);
  			boolean flag  = false;
  			if(callerMethodName.equals("test_Main_AddUserLabels")) {
  				clickOnBtnUserLabels();
  			}else {
  				
  				findUserLabelsFromRowListAndClickOnThreeDot(userLabelsName,searchKey, searchKeyColumnIndex, wantToClickOnThreeDot, wantToclickOnFindSearckKey);
  				Action_Edit.change(driver);
  			}
  			
  			setLablesName(userLabelsName);
  			
  			if(callerMethodName.equals("test_Main_AddUserLabels")) {
  				 flag = clickOnBtnSave_1_RU();
  			}else {
  				flag = clickOnBtnSaveChangesSpan_RU();
  			}
  			
  			if(flag) {
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(pleaseEnterLabelName)) {
  					clickOnCancelButton_1_RU();
  					logger.info("Label name is not added");
  					softAssert.assertTrue(false,"Label is emplty");
  					return new PO_Main_HomePage(driver); 
  				}else if(callerMethodName.equals("test_Main_AddUserLabels")){
  					softAssert.assertEquals(alertMsg,userLabelAdded,"Check user label added or not");
  				}else if(callerMethodName.equals("test_Main_ChangeUserLabels")){
  					softAssert.assertEquals(alertMsg,userLabelChanged,"Check user label changed or not");
  				}
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		 		
  		//TO ACTIVATE THE USER LABELS
  		public PO_Main_HomePage activateUserLabels() throws InterruptedException
  		{
  			Action_Activate.activate(driver, userLabelActivated);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO DEACTIVATE THE USER LABELS
  		public PO_Main_HomePage deactivateUserLabels() throws InterruptedException
  		{
  			Action_Deactivate.deactivate(driver, userLabelDeactivate);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO RESTORE THE USER LABELS
  		public PO_Main_HomePage restoreUserLabels() throws InterruptedException
  		{
  			Action_Restore.restore(driver, userLabelRestored);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO ARCHIVE THE USER LABELS
  		public PO_Main_HomePage archiveUserLabels() throws InterruptedException
  		{
  			Action_Archive.archive(driver, userLabelArchived);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
}
