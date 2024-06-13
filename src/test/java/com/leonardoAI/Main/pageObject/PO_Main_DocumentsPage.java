package com.leonardoAI.Main.pageObject;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;
import com.leonardoAI.actions.Action_Activate;
import com.leonardoAI.actions.Action_Deactivate;
import com.leonardoAI.actions.Action_Edit;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_DocumentsPage extends ReUseAbleElement {
		
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
		public PO_Main_DocumentsPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);
		}

		
		//ALERT MESSAGES
		public static String pleaseAddValidLink = "Please add valid file link.";
		public static String pleaseAddDocumentTitle =  "Please add documnet title.";
		public static String pleaseSelectLocation =  "Please select location.";
		public static String pleaseUplaodImage =  "Please upload file.";
		public static String pleaseAddLink = "Please add file link.";
		public String documentAdded = "Documnet added.";
		public String documentChanged = "Documnet updated.";
		public String documentDeactivate = "Document deactivated.";
		public String documentActivated = "Document activated.";

		//ALL REQUIRED FILED IN THE SINGLE SET
		Set<String> requiredFieldWhileAddOrChangeDocument = new HashSet<String>(
				Arrays.asList(pleaseAddValidLink, pleaseAddDocumentTitle,pleaseSelectLocation,pleaseUplaodImage,pleaseAddLink));
		
	
		//======START======PAGE OBJECT FOR DOCUMENTS AND ACTOIN METHODS==========//
		@FindBy(xpath = "(//span[normalize-space()='Add Document'])[1]")
		@CacheLookup
		public WebElement btnAddDocuments;
		public void clickOnBtnDocuments() throws InterruptedException {
			btnAddDocuments.click();
			Thread.sleep(3000);
			logger.info("Clicked on the btnAddDocuments");
			
		}
		
		@FindBy(xpath = "(//input[@placeholder='Enter document title'])[1]")
		@CacheLookup
		public WebElement textFieldDocumentName;
		public void setDocumentName(String documentName) throws InterruptedException {
			textFieldDocumentName.sendKeys(Keys.CONTROL,"a");
			textFieldDocumentName.sendKeys(Keys.DELETE);
			textFieldDocumentName.sendKeys(documentName);
			Thread.sleep(3000);
			logger.info("Entered document name");
			
		}
		
		@FindBy(xpath = "(//textarea[@placeholder='Add document description here'])[1]")
		@CacheLookup
		public WebElement textFieldDocuementDescription;
		public void setDocumentDescription(String documentDescritpion) throws InterruptedException {
			textFieldDocuementDescription.sendKeys(Keys.CONTROL,"a");
			textFieldDocuementDescription.sendKeys(Keys.DELETE);
			textFieldDocuementDescription.sendKeys(documentDescritpion);
			Thread.sleep(3000);
			logger.info("Entered document name");
			
		}
		
		@FindBy(xpath = "(//input[@placeholder='Enter file link'])[1]")
		@CacheLookup
		public WebElement textFieldDocumentLink;
		public void setDocumentLink(String documentLink) throws InterruptedException {
			textFieldDocumentLink.sendKeys(Keys.CONTROL,"a");
			textFieldDocumentLink.sendKeys(Keys.DELETE);
			textFieldDocumentLink.sendKeys(documentLink);
			Thread.sleep(3000);
			logger.info("Entered textFieldDocumentLink");
			
		}
		
		//TO SELECT THE LOCATIONS
  		public void selectLocations(String locationName) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU(driver);
  			WebElement locationField = driver.findElement(By.xpath("(//input[@id='tags-outlined'])[1]"));
  			locationField.sendKeys(Keys.BACK_SPACE);
  			logger.info("Backspace key pressed");
  			locationField.sendKeys(Keys.BACK_SPACE);
  			logger.info("Backspace key pressed");
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,locationName);
  			logger.info("Selected Locations from the list: "+locationName);
  			Thread.sleep(1000);
  		}
  		
  		
		@FindBy(xpath = "(//span[normalize-space()='Link To File'])[1]")
		@CacheLookup
		public WebElement radioBtnDocumentLink;
		public void clickOnRadioBtnDocumentLink() throws InterruptedException {
			if(radioBtnDocumentLink.isSelected()) {
				logger.info("Document link radio button already selected");
			}else {
				radioBtnDocumentLink.click();
				logger.info("Document link radio button selected");
			}
			Thread.sleep(500);
		}
		
		@FindBy(xpath = "(//span[normalize-space()='Upload File'])[1]")
		@CacheLookup
		public WebElement radioBtnUploadImage;	
		public void clickOnRadioBtnUploadImage() throws InterruptedException {
			if(radioBtnUploadImage.isSelected()) {
				logger.info("Upload image radio button already selected");
			}else {
				radioBtnUploadImage.click();
				logger.info("Upload image radio button selected");
			}
			Thread.sleep(500);
		}
		
		@FindBy(xpath = "//div[@class='MuiDropzoneArea-root image-dropzone show-icon']")
		@CacheLookup
		public WebElement btnUploadImage;	
		public void clickOnBtnUploadImage() throws InterruptedException {
			btnUploadImage.click();
			logger.info("Upload image button");
			Thread.sleep(500);
		}
										
		
  		//TEXT NO DOCUMENT MATCHED TO CURRENT APPLIED FILTER
  		@FindBy(xpath = "//*[.='No Document Matches Current Filter")
  		@CacheLookup
  		public WebElement noDocumentMatchedWithApplieddFilter;
  		public boolean  isNoDocumentMatchedDisplayed() throws InterruptedException {
  			boolean flag = false;
  			try {
  				Thread.sleep(5000);
  				flag = noDocumentMatchedWithApplieddFilter.isDisplayed();
  				if(flag) {
  					logger.info("Searched key not present");
  					softAssert.assertTrue(flag,"Document you are searching is not found");
  					clickOnP360Logo_RU();
  				}
  			}catch(Exception e) {
  				logger.info("Searched Document list is present, after applied filter");
  				logger.info("Exception from : "+e.getMessage());
  			}
  			logger.info("noDocumentMatchedWithApplieddFilter: "+flag);
  			softAssert.assertAll();
  			return flag;
  		}
  		
  		
  		//DOCUMENTS LIST 
  		@FindBy(xpath = "//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List<WebElement> listDocuments;
  		
  		//DOCUMENT ROW LIST ADDRESS AND ACTION METHODS
  		public String listUsreLabels_address = "//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findDocumentsFromRowListAndClickOnThreeDot(String DocumentsName,String searchKey, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			searchBox_1_RU(driver,searchKey);
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(listUsreLabels_address,listDocuments,driver, searchKey, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findDocumentsFromRowListAndClickOnThreeDot: "+e.getMessage());
			}
			return listRowCount;
  		}
  		//======END======PAGE OBJECT FOR ADD DOCUMENTS ACTOIN METHODS==========//
  		
  		
  		//TO ADD THE DOCUMENTS
  		public PO_Main_HomePage  addOrChangeDocuments(String documentName,String documentDescritpion,String documentLink,String locationName, String selectRadioBtnDocumentLinkOrUploadImage,String searchKey, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws Throwable 
  		{
  			//TO CATCH CALLER METHOD NAME
  			StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTrace[2].getMethodName();
  			logger.info("Caller methods name: "+callerMethodName);
  			
  			
  			boolean flag  = false;
  			
  			//TO DECIDE THE ACTION ADD OR CHANGE
  			if(callerMethodName.equals("test_Main_AddDocuments")) {
  				clickOnBtnDocuments();
  			}else {
  				findDocumentsFromRowListAndClickOnThreeDot(documentName,searchKey, searchKeyColumnIndex, wantToClickOnThreeDot, wantToclickOnFindSearckKey);
  				Action_Edit.change(driver);
  			}
  			
  			setDocumentName(documentName);
  			setDocumentDescription(documentDescritpion);
  			selectLocations(locationName);
  			
  			//TO SELECT THE ANY ONE RADIO BUTTON
  			if(selectRadioBtnDocumentLinkOrUploadImage.equals("documentLink")) {
  				clickOnRadioBtnDocumentLink();
  	  			setDocumentLink(documentLink);
  			}else if(selectRadioBtnDocumentLinkOrUploadImage.equals("uploadImage")){
  				clickOnRadioBtnUploadImage();
  			}else {
  				logger.info("Invalid radio button selection");
  			}
  		
  			
  			//TO DECIDE THE BUTTON SELECTION SAVE OR SAVE CHANGES
  			if(callerMethodName.equals("test_Main_AddDocuments")) {
  				 flag = clickOnBtnSave_1_RU();
  			}else {
  				flag = clickOnBtnSaveChangesSpan_RU();
  			}
  			
  			//ALERT MESSAGES CONFIRMATION
  			if(flag) {
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				
  				
  				if(requiredFieldWhileAddOrChangeDocument.contains(alertMsg)) {
  					clickOnCancelButton_1_RU();
  					logger.info("Document not added");
  					softAssert.assertTrue(false,alertMsg);
  				}else if(callerMethodName.equals("test_Main_AddDocument")){
  					softAssert.assertEquals(alertMsg,documentAdded,"Check document added or not");
  				}else if(callerMethodName.equals("test_Main_ChangeDocument")){
  					softAssert.assertEquals(alertMsg,documentChanged,"Check document changed or not");
  				}
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		 		
  		//TO ACTIVATE THE DOCUMENTS
  		public PO_Main_HomePage activateDocument() throws InterruptedException
  		{
  			Action_Activate.activate(driver, documentActivated);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO DEACTIVATE THE DOCUMENTS
  		public PO_Main_HomePage deactivateDocument() throws InterruptedException
  		{
  			Action_Deactivate.deactivate(driver, documentDeactivate);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
}
