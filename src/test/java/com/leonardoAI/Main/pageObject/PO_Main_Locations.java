

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
import com.leonardoAI.actions.Action_Edit;
import com.leonardoAI.actions.Action_View;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;
import com.leonardoAI.projectUtility.FindThreeDotBasedOnSearchKeyAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_Locations extends ReUseAbleElement {
		
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
		public PO_Main_Locations(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgRegionCreatedSuccessfully = "Region Created Successfully";
		public String alertMsgLocationCreatedSuccessfully = "Package name is required";
		public String alertMsgValidationError = "Validation Error Occurred. Errors:";
		public String alertMsgLocationUpdatedSuccessfully = "Location Updated Successfully";
		public String alertMsgRegionUpdatedSuccessfully = "Region Updated Successfully";
//		public String alertMsgTotalClassIsRequired = "Total Classes is required";
//		public String alertMsgPackageCreatedSuccessfully = "Package created successfully";
		
		
		//======START======PAGE OBJECT FOR ADD REGIONS AND ACTOIN METHODS==========//
		//BUTTON ADD ADD LOCATIONS
  		@FindBy(xpath = "//span[normalize-space()='Add Locations']")
  		@CacheLookup
  		public WebElement btnAddLocations;
  		public void clickOnBtnAddLocations() throws InterruptedException {
  			btnAddLocations.click();
  			logger.info("Clicked on the btn btnAddLocations");
  			Thread.sleep(1000);
  		}
		
  		//BUTTON ADD ADD REGIONS
  		@FindBy(xpath = "//span[normalize-space()='Add Regions']")
  		@CacheLookup
  		public WebElement btnRegions;
  		public void clickOnBtnAddRegions() throws InterruptedException {
  			btnRegions.click();
  			logger.info("Clicked on the btn btnRegions");
  			Thread.sleep(1000);
  		}
  		
  		
  		//TEXT FIELD REGIONS NAME/TITLE
  		@FindBy(xpath = "//input[contains(@name,'regionName')]")
  		@CacheLookup
  		public WebElement fieldRegionName;
  		public void setRegionName(String regionName) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldRegionName));
  			fieldRegionName.sendKeys(Keys.CONTROL,"a");
  			fieldRegionName.sendKeys(Keys.DELETE);
  			fieldRegionName.sendKeys(regionName);
  			logger.info("Entered the fieldRegionName: "+regionName);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD REGIONS CODE
  		@FindBy(xpath = "//input[contains(@name,'regionCode')]")
  		@CacheLookup
  		public WebElement fieldRegionCode;
  		public void setRegionCode(String regionCode) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldRegionCode));
  			fieldRegionCode.sendKeys(Keys.CONTROL,"a");
  			fieldRegionCode.sendKeys(Keys.DELETE);
  			fieldRegionCode.sendKeys(regionCode);
  			logger.info("Entered the fieldRegionCode: "+regionCode);
  			Thread.sleep(300);
  		}
  	
  		
  		//TEXT FIELD REGOIN DESCRITPION
  		@FindBy(xpath = "//textarea[@name='description']")
  		@CacheLookup
  		public WebElement filedRegionDescription;
  		public void setRegionDescription(String regionDescription) throws InterruptedException {
  			filedRegionDescription.sendKeys(Keys.CONTROL,"a");
  			filedRegionDescription.sendKeys(Keys.DELETE);
  			filedRegionDescription.sendKeys(regionDescription);;
  			logger.info("Entered the  filedRegionDescription: "+regionDescription);
  			Thread.sleep(300);
  		}
  	
  		
  		//TO SELECT THE PARENT REGION
  		public void selectParentRegion(String parentRegion) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,parentRegion);
  			logger.info("Parent Region: "+parentRegion);
  			Thread.sleep(500);
  		}
  	//======END======PAGE OBJECT FOR ADD REGIONS AND ACTOIN METHODS==========//
  		
  		
  	//======START======PAGE OBJECT FOR ADD LOCATIONS AND ACTOIN METHODS==========//
  		
  		//TEXT FIELD LOCATIONS NAME/TITLE
  		@FindBy(xpath = "//input[contains(@name,'displayName')]")
  		@CacheLookup
  		public WebElement fieldLocationName;
  		public void setLocationName(String locationName) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldLocationName));
  			fieldLocationName.sendKeys(Keys.CONTROL,"a");
  			fieldLocationName.sendKeys(Keys.DELETE);
  			fieldLocationName.sendKeys(locationName);
  			logger.info("Entered fieldLocationName: "+locationName);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD INTERNAL NAME
  		@FindBy(xpath = "//input[contains(@name,'internalName')]")
  		@CacheLookup
  		public WebElement fieldLocationInternalName;
  		public void setLocatonInternalName(String locationInternalName) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldLocationInternalName));
  			fieldLocationInternalName.sendKeys(Keys.CONTROL,"a");
  			fieldLocationInternalName.sendKeys(Keys.DELETE);
  			fieldLocationInternalName.sendKeys(locationInternalName);
  			logger.info("Entered the fieldLocationInternalName: "+locationInternalName);
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD LOCATOINS CODE
  		@FindBy(xpath = "//input[contains(@name,'locationCode')]")
  		@CacheLookup
  		public WebElement fieldLocationCode;
  		public void setLocationCode(String locatoinCode) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldLocationCode));
  			fieldLocationCode.sendKeys(Keys.CONTROL,"a");
  			fieldLocationCode.sendKeys(Keys.DELETE);
  			fieldLocationCode.sendKeys(locatoinCode);
  			logger.info("Entered the fieldLocationCode: "+locatoinCode);
  			Thread.sleep(300);
  		}


  		//TO SELECT THE LOCATIONS REGIONS 
  		public void selectLocationRegion(String locationRegionName) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,locationRegionName);
  			Thread.sleep(500);
  		}
  		
  		//TEXT FIELD LOCATION DESCRIPTION
  		@FindBy(xpath = "//div[contains(@class,'ql-container')]//p")
  		@CacheLookup
  		public WebElement fieldDescirption;
  		public void setDescrition(String description) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldDescirption));
  			fieldDescirption.sendKeys(Keys.CONTROL,"a");
  			fieldDescirption.sendKeys(Keys.DELETE);
  			fieldDescirption.sendKeys(description);
  			logger.info("Entered the fieldDescirption: "+description);
  			Thread.sleep(300);
  		}
  		
  		
  		
  		//TEXT FIELD ADDRESS LINE 1
  		@FindBy(xpath = "//input[contains(@name,'addressLine1')]")
  		@CacheLookup
  		public WebElement fieldAddressLine1;
  		public void setAddressLine1(String addressLine1) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldAddressLine1));
  			fieldAddressLine1.sendKeys(Keys.CONTROL,"a");
  			fieldAddressLine1.sendKeys(Keys.DELETE);
  			fieldAddressLine1.sendKeys(addressLine1);
  			logger.info("Entered the fieldAddressLine1: "+addressLine1);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD ADDRESS LINE 2
  		@FindBy(xpath = "//input[contains(@name,'addressLine2')]")
  		@CacheLookup
  		public WebElement fieldAddressLine2;
  		public void setAddressLine2(String addressLine2) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldAddressLine2));
  			fieldAddressLine2.sendKeys(Keys.CONTROL,"a");
  			fieldAddressLine2.sendKeys(Keys.DELETE);
  			fieldAddressLine2.sendKeys(addressLine2);
  			logger.info("Entered the fieldAddressLine2: "+addressLine2);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD CITY
  		@FindBy(xpath = "//input[contains(@name,'city')]")
  		@CacheLookup
  		public WebElement fieldCity;
  		public void setCity(String city) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldCity));
  			fieldCity.sendKeys(Keys.CONTROL,"a");
  			fieldCity.sendKeys(Keys.DELETE);
  			fieldCity.sendKeys(city);
  			logger.info("Entered the fieldCity: "+city);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD POSTAL CODE
  		@FindBy(xpath = "//input[contains(@name,'postalCode')]")
  		@CacheLookup
  		public WebElement fieldPostalCode;
  		public void setPostalCode(String postalCode) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldPostalCode));
  			fieldPostalCode.sendKeys(Keys.CONTROL,"a");
  			fieldPostalCode.sendKeys(Keys.DELETE);
  			fieldPostalCode.sendKeys(postalCode);
  			logger.info("Entered the fieldPostalCode1: "+postalCode);
  			Thread.sleep(300);
  		}
  		
  		//TO SELECT THE STATE/PROVINCE
  		public void selectState(String stateName) throws InterruptedException {
  			ruae.clickOnDropdown_2_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,stateName);
  			Thread.sleep(500);
  		}
  		
  		
  		//TEXT FIELD LOCATOIN EMAIL
  		@FindBy(xpath = "//input[contains(@name,'locationEmail')]")
  		@CacheLookup
  		public WebElement fieldLocatoinEmail;
  		public void setLocationEmail(String locationEmail) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldLocatoinEmail));
  			fieldLocatoinEmail.sendKeys(Keys.CONTROL,"a");
  			fieldLocatoinEmail.sendKeys(Keys.DELETE);
  			fieldLocatoinEmail.sendKeys(locationEmail);
  			logger.info("Entered the fieldLocatoinEmail: "+locationEmail);
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD LOCATOIN EMAIL
  		@FindBy(xpath = "//input[contains(@name,'locationPhoneNumber')]")
  		@CacheLookup
  		public WebElement fieldLocatoinPhoneNumber;
  		public void setLocationPhoneNumber(String locationPhoneNumber) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldLocatoinPhoneNumber));
  			fieldLocatoinPhoneNumber.sendKeys(Keys.CONTROL,"a");
  			fieldLocatoinPhoneNumber.sendKeys(Keys.DELETE);
  			fieldLocatoinPhoneNumber.sendKeys(locationPhoneNumber);
  			logger.info("Entered the fieldLocatoinPhoneNumber: "+locationPhoneNumber);
  			Thread.sleep(300);
  		}
  		
  		//LOCATIONS ROW LIST ADDRESS AND ACTION METHDS
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex flex-col')])[2]//div[contains(@class,'p-2 flex gap-2 flex-row')]")
  		@CacheLookup
  		public List <WebElement> locationRowList;
  		public String locationRowList_address = "(//div[contains(@class,'w-full flex flex-col')])[2]//div[contains(@class,'p-2 flex gap-2 flex-row')]";
  		public int findLocationFromRowListAndClickOnThreeDot(String locationName,int searchKeyColumnIndex,boolean wantToClickOnThreeDot,boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0;
			try {
				Thread.sleep(2000);
				//listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(locationRowList,driver, locationName, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(locationRowList_address,locationRowList,driver, locationName, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
			}catch(Exception e) {
				logger.info("Exception from findLocationFromRowListAndClickOnThreeDot: "+e.getMessage());
				softAssert.assertTrue(false,"not click on the three dot action button");
			}
			return listRowCount;
  		}
  		
  				
  		//REGIONS ROW LIST ADDRESS AND ACTION METHODS
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex flex-col')])[3]//div[contains(@class,'p-2 flex gap-2 flex-row')]")
  		@CacheLookup
  		public List <WebElement> regionRowList;
  		public String regionRowList_address = "(//div[contains(@class,'w-full flex flex-col')])[2]//div[contains(@class,'p-2 flex gap-2 flex-row')]";
  		public int findRegionFromRowListAndClickOnThreeDot(String regionName, int searchKeyColumnIndex,boolean wantToClickOnThreeDot,boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0;
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(regionRowList,driver, regionName, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
			}catch(Exception e) {
				logger.info("Exception from findRegionFromRowListAndClickOnThreeDot: "+e.getMessage());
				softAssert.assertTrue(false,"not click on the three dot action button");
			}
			return listRowCount;
  		}		
  		
	
  		
  		
  		
  		//TO CHECK SEARCH LOCAITN IS PRESENT OR NOT
  		@FindBy(xpath = "//span[.='No Locations Matches Current Filter']")
  		@CacheLookup
  		WebElement textNoLocationMatchesCurrentFiter;
  		public boolean isTextNoLocationMachesCurrentFilter() {
  			boolean flag = false;
  			try {
  				if(textNoLocationMatchesCurrentFiter.isDisplayed()) {
  					logger.info("No locations matched to applied filter");
  					softAssert.assertTrue(false,"No Location Matched to the Current Fiter");
  	  				flag = true;
  	  			}
  			}catch(Exception e) {
  				logger.info("Exception from isTextNoLocationMachesCurrentFilter: "+e.getMessage());
  				logger.info("Location Matched to the Current Fiter");
  				softAssert.assertTrue(true,"Location Matched to the Current Fiter");
  				flag = false;
  			}
  			return flag;
  		}

  		//TO CHECK SEARCH REGION IS PRESENT OR NOT
  		@FindBy(xpath = "//span[.='No Regions Matches Current Filter']")
  		@CacheLookup
  		WebElement textNoRegionMatchesCurrentFiter;
  		public boolean isTextNoRegionMachesCurrentFilter() {
  			boolean flag = false;
  			try {
  				if(textNoRegionMatchesCurrentFiter.isDisplayed()) {
  					logger.info("No regions matched to applied filter");
  					softAssert.assertTrue(false,"No Region Matches to the applied Current Fiter");
  					flag = true;
  	  			}
  			}catch(Exception e) {
  				logger.info("Exception from isTextNoRegionMachesCurrentFilter: "+e.getMessage());
  				logger.info("Region Matched to the Current Fiter");
  				softAssert.assertTrue(true,"Region Matches to the applied Current Fiter");
  				flag = false;
  			}
  			return flag;
  		}
  				
  		//======END======PAGE OBJECT FOR ADD LOCATIONS AND ACTOIN METHODS==========//
  		
  		
  		
  		//======START======PAGE OBJECT FOR LOCATION SETTING AND ACTOIN METHODS==========//
  		
		//TEXT TO CHECK LOCATION SETTING PAGE IS OPEND OR NOT
  		@FindBy(xpath = "(//div[contains(text(),'Locations Settings')])[1]")
  		@CacheLookup
  		public WebElement textLocationSetting;
  		public boolean isTextLocationSettinPresent() throws InterruptedException {
  			boolean flag = false;
  			try {
  				wait.until(ExpectedConditions.elementToBeClickable(textLocationSetting));
  				flag = textLocationSetting.isDisplayed();
  			}catch(Exception e) {
  				logger.info("Exception from : "+e.getMessage());
  			}
  			Thread.sleep(300);
  			return flag;
  		}
	  		
  		//TO SELECT THE TIMEZONE
  		public void selectTimeZone(String timeZone) throws InterruptedException {
  			//ruae.clickOnDropdown_1_RU();
  			driver.findElement(By.xpath("(//button[@title='Open']//*[name()='svg'])[1]")).click();
  			//Will avoid the stale element reference
  			Thread.sleep(500);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,timeZone);
  			Thread.sleep(500);
  		}
  		
  		//TEXT FIELD P360 SHARES
  		@FindBy(xpath = "//input[contains(@name,'revenueSplit')]")
  		@CacheLookup
  		public WebElement fieldP360Shares;
  		public void setP360Shares(String p360Shares) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldP360Shares));
  			fieldP360Shares.sendKeys(Keys.CONTROL,"a");
  			fieldP360Shares.sendKeys(Keys.DELETE);
  			fieldP360Shares.sendKeys(p360Shares);
  			logger.info("Entered the fieldP360Shares: "+p360Shares);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD LOCATION VITLES DECRIPTOINS
  		@FindBy(xpath = "//div[contains(@class,'ql-container')]//p")
  		@CacheLookup
  		public WebElement fieldLocatoinVitlesDescriptions;
  		public void setLocationVitlesDescriptoin(String locationVitalsDescription) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldP360Shares));
  			fieldLocatoinVitlesDescriptions.sendKeys(Keys.CONTROL,"a");
  			fieldLocatoinVitlesDescriptions.sendKeys(Keys.DELETE);
  			fieldLocatoinVitlesDescriptions.sendKeys(locationVitalsDescription);
  			logger.info("Entered the fieldLocatoinVitlesDescriptions: "+locationVitalsDescription);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD NO SHOW FEE
  		@FindBy(xpath = "//input[contains(@name,'noShowFee')]")
  		@CacheLookup
  		public WebElement fieldNoShowFee;
  		public void setNoShowFee(String noShowFee) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldNoShowFee));
  			fieldNoShowFee.sendKeys(Keys.CONTROL,"a");
  			fieldNoShowFee.sendKeys(Keys.DELETE);
  			fieldNoShowFee.sendKeys(noShowFee);
  			logger.info("Entered the fieldNoShowFee: "+noShowFee);
  			Thread.sleep(300);
  		}
  		
//======START======PAGE OBJECT FOR LOCATION SETTING AND ACTOIN METHODS==========//
  				
  				
//=======START============ACTIONS METHODS========================//	
  		
  		//TO ADD AND UPDATES REGIONS 
  		public PO_Main_HomePage addAndUpdateRegion(String regionName,String parentRegion,String regionCode,String regionDescription) throws InterruptedException
  		{
  			StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTraceElement[2].getMethodName();
  			
  			if(callerMethodName.equals("test_Main_UpdateRegion")) {
  				logger.info("addRegion methods is called to update the region");
  			}else {
  				clickOnBtnAddRegions();
  			}
  			
  			Thread.sleep(3000);
  			setRegionName(regionName);
  			selectParentRegion(parentRegion);
  			setRegionCode(regionCode);
  			setRegionDescription(regionDescription);
  			
  			boolean flag = false; 
				if(callerMethodName.equals("test_Main_UpdateRegion")) {
					flag = clickOnBtnUpdate_1_RU();
	  			}else {
	  				flag = clickOnBtnSaveAndClose_1_RU();
	  			}
				
  			boolean requiredMsg = isRequiredOrInvalidMessageDisplayed_RU();
  			if(requiredMsg) 
  			{
  				Thread.sleep(1000);
  				clickOnCancelButton_1_RU();
  				softAssert.assertTrue(false,"Required Message Displayed");
  			}
  			else if(flag) 
			{
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgRegionCreatedSuccessfully)) {
  					softAssert.assertEquals(alertMsg, alertMsgRegionCreatedSuccessfully,"Checks Regoin created successfully");
  				}else if(alertMsg.equals(alertMsgRegionUpdatedSuccessfully)){
  					softAssert.assertEquals(alertMsg, alertMsgRegionUpdatedSuccessfully,"Checks Regoin updated successfully");
  	  			}else if(alertMsg.contains("required") || alertMsg.contains("Required")){
  	  				logger.info("===>>> Region not created, some required field missing");
  	  				softAssert.assertTrue(false, "Neither region created nor updated");
  	  				ruae.clickOnCancelButton_1_RU();
  	  				
  	  			}
  			}
  			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		//TO ADD LOCATIONS
  		public PO_Main_HomePage addAndUpdateLocation(String locationName,String locationInternalName,String locationRegionName,String locatoinCode, String locationDescription,String addressLine1,String addressLine2, String city,String postalCode,String stateName,String locationEmail,String locationPhoneNumber,String locationVitalsDescription,String timeZone,String p360Shares,String wantEnableNoShow, String noShowFee) throws InterruptedException
  		{
  			StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTraceElement[2].getMethodName();
  			
  			if(callerMethodName.equals("test_Main_UpdateLocatoin")) {
  				logger.info("addLocation methods is called to update the location");
  			}else {
  				clickOnBtnAddLocations();
  			}
  			
  			Thread.sleep(3000);
  			setLocationName(locationName);
  			setLocatonInternalName(locationInternalName);
  			selectLocationRegion(locationRegionName);
  			setLocationCode(locatoinCode);
  			setDescrition(locationDescription);
  			setAddressLine1(addressLine1);
  			setAddressLine2(addressLine2);
  			setCity(city);
  			setPostalCode(postalCode);
  			selectState(stateName);
  			setLocationEmail(locationEmail);
  			setLocationPhoneNumber(locationPhoneNumber);
  			clickONBtnContinue_RU();
  			
  			boolean requiredMsg = isRequiredOrInvalidMessageDisplayed_RU();
  			if(requiredMsg) {
  				Thread.sleep(1000);
  				clickOnCancelButton_1_RU();
  				softAssert.assertTrue(false,"Required Message Displayed");
  			}
  			else if(isTextLocationSettinPresent())
  			{
  				selectTimeZone(timeZone);
  				setP360Shares(p360Shares);
  				setLocationVitlesDescriptoin(locationVitalsDescription);
  				setNoShowFee(noShowFee);
  				if(wantEnableNoShow.equalsIgnoreCase("Yes")) {
  					clickOnCheckBox_1_RU();
  				}
  				
  				boolean flag = false; 
  				if(callerMethodName.equals("test_Main_UpdateLocatoin")) {
  					flag = clickOnBtnUpdate_1_RU();
  	  			}else {
  	  				flag = clickOnBtnSaveAndClose_1_RU();
  	  			}
  				
  				if(flag) 
  				{	boolean requiredMsg2 = isRequiredOrInvalidMessageDisplayed_RU();
	  				if(requiredMsg2) 
	  				{
	  	  				Thread.sleep(1000);
	  	  				clickOnCancelButton_1_RU();
	  	  				softAssert.assertTrue(false,"Required/Invalid Message Displayed");
	  	  			}
	  				else
	  	  			{
	  	  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
	  	  				if(alertMsg.equals(alertMsgLocationCreatedSuccessfully)){
	  	  					softAssert.assertEquals(alertMsg, alertMsgLocationCreatedSuccessfully,"Checks Location created successfully");
	  	  				}else if(alertMsg.contains(alertMsgLocationUpdatedSuccessfully)) {
	  	  					softAssert.assertEquals(alertMsg, alertMsgLocationUpdatedSuccessfully,"Checks Location updated successfully");
	  	  				}else if(alertMsg.contains(alertMsgValidationError)) {
	  	  					ruae.clickOnCancelButton_1_RU();
	  	  				}
  	  				}
  					
	  			}
  				
  			}
  			else {
  				clickOnCancelButton_1_RU();
  				softAssert.assertTrue(false);
  			}
  				
  			softAssert.assertAll();
  			Thread.sleep(2000);
  			return new PO_Main_HomePage(driver);
  			
  		}
  		
  		//FIND LOACTION FROM THE LIST AND VIEW DETAILS
  		public void findLocatoinAndViewDetails(String locationName,int searchKeyColumnIndex,boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException
  		{
  			jsExecutor.executeScript("window.scrollBy(0, 100);");
  			searchBox_1_RU(driver,locationName);
  			boolean flag = isTextNoLocationMachesCurrentFilter();
  			if(!flag) {
  				findLocationFromRowListAndClickOnThreeDot(locationName,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
  				Action_View.clickOnThreeDotActionBtnDetails(driver);
  			}else {
  				clickOnP360Logo_RU();
  			}
  			Thread.sleep(2000);
  			softAssert.assertAll();
  		}
  		
  		//FIND REGIONS FROM THE LIST AND VIEW DETAILS
  		public void findRegionAndViewDetails(String regionName,int searchKeyColumnIndex,boolean wantToClickOnThreeDot,boolean wantToclickOnFindSearckKey) throws InterruptedException
  		{
  			jsExecutor.executeScript("window.scrollBy(0, 300);");
  			Thread.sleep(2000);
  			searchBox_2_RU(regionName);
  			boolean flag = isTextNoRegionMachesCurrentFilter();
  			if(!flag) {
  				findRegionFromRowListAndClickOnThreeDot(regionName,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
  				Action_View.clickOnThreeDotActionBtnDetails(driver);
  	  			Thread.sleep(2000);
  			}else {
  				clickOnP360Logo_RU();
  			}
  			ruae.clickOnBtnCross_RU();
  			Thread.sleep(2000);
  			softAssert.assertAll();
  		}
  		
  		//FIND THE LOCATOIN FROM THE LIST AND UPDATE IT
  		public boolean findAndUpdateLocation(String locationName,int searchKeyColumnIndex,boolean wantToClickOnThreeDot,boolean wantToclickOnFindSearckKey) throws InterruptedException
  		{
  			jsExecutor.executeScript("window.scrollBy(0, 100);");
  			searchBox_1_RU(driver,locationName);
  			boolean isClickOnChangeBtn = false;
  			boolean flag = isTextNoLocationMachesCurrentFilter();
  			if(!flag) {
  				findLocationFromRowListAndClickOnThreeDot(locationName,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
  				isClickOnChangeBtn = Action_Edit.change(driver);
  			}else {
  				clickOnP360Logo_RU();
  			}
  			Thread.sleep(2000);
  			softAssert.assertAll();
  			return isClickOnChangeBtn;
  		}
  		
  		
  		//FIND THE REGION FROM THE LIST AND UPDATE IT
  		public boolean findAndUpdateRegion(String regionName,int searchKeyColumnIndex,boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException
  		{
  			jsExecutor.executeScript("window.scrollBy(0, 300);");
  			searchBox_2_RU(regionName);
  			boolean isClickOnChangeBtn = false;
  			boolean flag = isTextNoRegionMachesCurrentFilter();
  			if(!flag) {
  				findRegionFromRowListAndClickOnThreeDot(regionName,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
  				isClickOnChangeBtn = Action_Edit.change(driver);
  			}else {
  				clickOnP360Logo_RU();
  			}
  			Thread.sleep(2000);
  			softAssert.assertAll();
  			return isClickOnChangeBtn;
  		}
  		
  		
}
