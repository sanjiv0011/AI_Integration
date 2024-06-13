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
import com.leonardoAI.actions.Action_Activate;
import com.leonardoAI.actions.Action_Archive;
import com.leonardoAI.actions.Action_Deactivate;
import com.leonardoAI.actions.Action_Edit;
import com.leonardoAI.actions.Action_Restore;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_TrailsPage extends ReUseAbleElement {
		
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
		public PO_Main_TrailsPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgAddTitle = "Please add title.";
		public String alertMsgTemplateCreatedSuccessfully= "Template created successfully.";
		public String alertMsgTemplateActivated = "Trial Template Activated Successfully.";
		public String alertMsgTemplateDeActivated = "Trial Template Deactivated Successfully.";
		public String alertMsgTemplateArchived = "Trial Template Archived Successfully.";
		public String alertMsgTemplateRestored = "Trial Template Restored Successfully.";
		public String alertMsgTemplateUpdated = "Template updated successfully.";
		
		
		//======START======PAGE OBJECT FOR TEMPLATE AND ACTOIN METHODS==========//
		//BUTTON TEMPLATE
  		@FindBy(xpath = "//span[normalize-space()='Templates']")
  		@CacheLookup
  		public WebElement btnTemplate;
  		public void clickOnBtnTemplate() throws InterruptedException {
  			btnTemplate.click();
  			logger.info("Clicked on the btn btnTemplate");
  			Thread.sleep(1000);
  		}
  		
  		//BUTTON ADD NEW TEMPLATE
  		@FindBy(xpath = "//span[normalize-space()='Add New Template']")
  		@CacheLookup
  		public WebElement btnAddNewTemplate;
  		public void clickOnBtnAddNewTemplate() throws InterruptedException {
  			btnAddNewTemplate.click();
  			logger.info("Clicked on the btn btnAddNewTemplate");
  			Thread.sleep(1000);
  		}
  		
  		//BUTTON SMS
  		@FindBy(xpath = "//div[contains(@class,'cursor-pointer')][normalize-space()='SMS']")
  		@CacheLookup
  		public WebElement btnSMS;
  		public void clickOnBtnSMS() throws InterruptedException {
  			btnSMS.click();
  			logger.info("Clicked on the btn btnSMS");
  			Thread.sleep(1000);
  		}
  		
  		//BUTTON EAMIL
  		@FindBy(xpath = "//div[contains(@class,'cursor-pointer')][normalize-space()='Email']")
  		@CacheLookup
  		public WebElement btnEmail;
  		public void clickOnBtnEmail() throws InterruptedException {
  			btnEmail.click();
  			logger.info("Clicked on the btn btnEmail");
  			Thread.sleep(1000);
  		}
		
  		
  		//TEXT FIELD TEMPLATE TITLE
  		@FindBy(xpath = "(//input[@placeholder='Enter title'])[1]")
  		@CacheLookup
  		public WebElement fieldTitle;
  		public void setTemplateTitle(String templateTitle) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldTitle));
  			fieldTitle.sendKeys(Keys.CONTROL,"a");
  			fieldTitle.sendKeys(Keys.DELETE);
  			fieldTitle.sendKeys(templateTitle);
  			logger.info("Entered the fieldTitle: "+templateTitle);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD TEMPLATE EMAIL SUBJECT
  		@FindBy(xpath = "(//input[@placeholder='Enter email subject'])[1]")
  		@CacheLookup
  		public WebElement fieldEmailSubject;
  		public void setEmailSubject(String emailSubject) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldEmailSubject));
  			fieldEmailSubject.sendKeys(Keys.CONTROL,"a");
  			fieldEmailSubject.sendKeys(Keys.DELETE);
  			fieldEmailSubject.sendKeys(emailSubject);
  			logger.info("Entered the fieldEmailSubject: "+emailSubject);
  			Thread.sleep(300);
  		}
  		
  		
  				
  		//TEXT FIELD TEMPLATE DESCRIPTION
  		@FindBy(xpath = "//textarea[@placeholder='Add description here']")
  		@CacheLookup
  		public WebElement fieldTemplateDescription;
  		public void setTemplateDescription(String templateDescription) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldTemplateDescription));
  			fieldTemplateDescription.sendKeys(Keys.CONTROL,"a");
  			fieldTemplateDescription.sendKeys(Keys.DELETE);
  			fieldTemplateDescription.sendKeys(templateDescription);
  			logger.info("Entered the fieldTemplateDescription: "+templateDescription);
  			Thread.sleep(300);
  		}
  	
  		//TO SELECT THE LOCATION
  		public void selectLocation(String templateLocation) throws InterruptedException {
  			//ruae.clickOnDropdown_3_RU();
  			driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])[2]")).click();
  			//Will avoid the stale element reference
  			Thread.sleep(500);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,templateLocation);
  			Thread.sleep(500);
  		}
  		
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List<WebElement> templateList;
  		//PACKAGE CATEGORY ROW LIST ADDRESS AND ACTION METHODS
  		public String templateRowList_address = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findTemplateFromRowListAndClickOnThreeDot(String templateTitle, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				//listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(packageCategoryRowList,driver, packageCategoryTitle, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(templateRowList_address,templateList,driver, templateTitle, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findTemplateFromRowListAndClickOnThreeDot: "+e.getMessage());
				softAssert.assertTrue(false,"not click on the three dot action button");
			}
			return listRowCount;
  		}
  		
  		//TO SELECT THE TEMPLATE LOCATIONS
  		public void selectTemplateLocation(String templateLocation) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,templateLocation);
  			logger.info("Package location: "+templateLocation);
  			Thread.sleep(500);
  		}
  		
  		
  		
  		//======END======PAGE OBJECT FOR ADD TEMPLATE ACTOIN METHODS==========//
  				
  				
  				
  		//TO ADD TEMPLATE
  		public PO_Main_HomePage addTemplate(String temlateTypes,String templateTitle, String templateDescription, boolean wantToEnableGlobal,String templateLocation, String templateEmailSubject, String templateEmailDescription) throws InterruptedException
  		{
  			StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTraceElement[2].getMethodName();
  			logger.info("caller method name: "+callerMethodName);
  			
  			
  			logger.info("Methods called: addTemplate");
  			boolean flag = false;
  			
  			if(callerMethodName.equals("changeTemplate")) {
  				logger.info("Change changed methods called");
  			}else {
  				clickOnBtnTemplate();
  	  			clickOnBtnAddNewTemplate();
  			}
  			
  			
  			//CONFIRM FIRST USER WANT TO CREATE TEMPLATE BY SMS OR EMAIL
  			if(temlateTypes.equals("SMS")) {
  				clickOnBtnSMS();
  				setTemplateTitle(templateTitle);
  				setTemplateDescription(templateDescription);
  				if(wantToEnableGlobal) {
  					clickOnCheckBox_1_RU();
  				}else {
  					selectLocation(templateLocation);
  				}
  				flag = clickOnBtnSave_1_RU();
  				 
  			}else if(temlateTypes.equals("Email")) {
  				clickOnBtnEmail();
  				setEmailSubject(templateEmailSubject);
  				setDescription_1_RU(templateEmailDescription);
  				if(wantToEnableGlobal) {
  					clickOnCheckBox_1_RU();
  				}else {
  					selectLocation(templateLocation);
  				}
  				flag = clickOnBtnSave_1_RU();
  			}
  			if(flag) 
  			{
				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgTemplateCreatedSuccessfully)){
  					softAssert.assertEquals(alertMsg, alertMsgTemplateCreatedSuccessfully,"Template created successfully");
  					logger.info("Template created successfully");
  				}else if(alertMsg.equals(alertMsgTemplateUpdated)) {
  					softAssert.assertEquals(alertMsg, alertMsgTemplateUpdated,"Template updated successfully");
  					logger.info("Template updated");
  				}else if(alertMsg.contains(alertMsgAddTitle)) {
  					softAssert.assertEquals(alertMsg, alertMsgAddTitle,"Add title alert displayed");
  					clickOnCancelButton_1_RU();
  					logger.info("Template not created");
  				}else {
  					clickOnCancelButton_1_RU();
  					softAssert.assertTrue(false,"Template not added");
  					
  				}
	  		}else {
	  			softAssert.assertTrue(false,"Template not added");
	  		}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  	//FIND TEMPLATE AND CLICK ON THREE DOT BUTTON
	public void findTemplateAndClickOnThreeDot(String templateName,int searchKeyColumnIndex,boolean wantToClickOnThreeDot,boolean wantToclickOnFindSearckKey,String templateLocation) throws InterruptedException
	{
		logger.info("Methods called: findTemplateAndClickOnThreeDot ");
		jsExecutor.executeScript("window.scrollBy(0, 10);");
		Thread.sleep(2000);
		clickOnBtnTemplate();
		selectTemplateLocation(templateLocation);

		int templateRowListCount = findTemplateFromRowListAndClickOnThreeDot(templateName,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
		Thread.sleep(1000);
		logger.info("Template matched list count: "+templateRowListCount);
		
		Thread.sleep(2000);
		softAssert.assertAll();
	}
	
		//TO ACTIVATE THE TEMPLATE
		public PO_Main_HomePage activateTemplate() throws InterruptedException
		{	logger.info("Methods called: activateTemplate ");
			Action_Activate.activate(driver, alertMsgTemplateActivated);
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
		
		//TO DEACTIVATE THE TEMPLATE
		public PO_Main_HomePage deActivateTemplate() throws InterruptedException
		{
			logger.info("Methods called: deActivateTemplate ");
			Action_Deactivate.deactivate(driver, alertMsgTemplateDeActivated);
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
		
		//TO ARCHIVE THE TEMPLATE
		public PO_Main_HomePage archiveTemplate() throws InterruptedException
		{
			logger.info("Methods called: archiveTemplate ");
			Action_Archive.archive(driver, alertMsgTemplateArchived);
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
		
		//TO RESTORE THE TEMPLATE
		public PO_Main_HomePage restoreTemplate() throws InterruptedException
		{
			logger.info("Methods called: restoreTemplate ");
			Action_Restore.restore(driver, alertMsgTemplateRestored);
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
		}
		
		//TO CHANGE THE TRAIL TEMPLATE
		public PO_Main_HomePage changeTemplate(String temlateTypes,String templateTitle, String templateDescription, boolean wantToEnableGlobal,String templateLocation, String templateEmailSubject, String templateEmailDescription) throws InterruptedException
		{
			logger.info("Methods called: changeTemplate");
			Action_Edit.change(driver);
			
			addTemplate(temlateTypes,templateTitle, templateDescription, wantToEnableGlobal,templateLocation, templateEmailSubject, templateEmailDescription);
			softAssert.assertAll();
			return new PO_Main_HomePage(driver);
			
		}
  		
}
