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
import com.leonardoAI.projectUtility.FindThreeDotBasedOnSearchKeyAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_PackagesPage extends ReUseAbleElement {
		
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
		public PO_Main_PackagesPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgPackageCategoryCreatedSuccessfully = "Category Created successfully";
		public String alertMsgPackageNameIsRequired = "Package name is required";
		public String alertMsgPackageCategoryIsRequired = "Package category is required";
		public String alertMsgPackageDescriptionIsRequired = "Package Description is required";
		public String alertMsgPackageRegularPriceIsRequired = "Package regular Price is required";
		public String alertMsgTotalClassIsRequired = "Total Classes is required";
		public String alertMsgPackageCreatedSuccessfully = "Package created successfully";
		public String alertMsgPackageUpdatedSuccessfully = "Package updated successfully";
		public String alertMsgPackageActivated = "Status changed to Active successfully";
		public String alertMsgPackageDeActivated = "Status changed to Inactive successfully";
		public String alertMsgPackageArchived = "Archived successfully";
		public String alertMsgPackageRestored = "Restored successfully";
		
		public String alertMsgPackageCategoryActivated = "Status changed to Active successfully";
		public String alertMsgPackageCategoryDeActivated = "Status changed to Inactive successfully";
		public String alertMsgPackageCategoryArchived = "Archived successfully";
		public String alertMsgPackageCategoryRestored = "Restored successfully";
		
		
		
		
		//TEXT FIELD FIRST NAME
  		@FindBy(xpath = "//input[@placeholder='Enter First Name']")
  		@CacheLookup
  		public WebElement filedFirstName;
  		public void setFirstName(String firstName) throws InterruptedException {
  			filedFirstName.sendKeys(Keys.CONTROL,"a");
  			filedFirstName.sendKeys(Keys.DELETE);
  			filedFirstName.sendKeys(firstName);;
  			logger.info("Clicked on the field first name");
  			Thread.sleep(300);
  		}
		
  		//BUTTON ADD PACKAGES
  		@FindBy(xpath = "//span[normalize-space()='Add Package']")
  		@CacheLookup
  		public WebElement btnAddPackage;
  		public void clickOnBtnAddPackages() throws InterruptedException {
  			btnAddPackage.click();
  			logger.info("Clicked on the btn btnAddPackages");
  			Thread.sleep(2000);
  		}
  		
  		//BUTTON PACKAGES CATEGORY
  		@FindBy(xpath = "//span[normalize-space()='Package Categories']")
  		@CacheLookup
  		public WebElement btnPackagesCategory;
  		public void clickOnBtnPackagesCategory() throws InterruptedException {
  			btnPackagesCategory.click();
  			logger.info("Clicked on the btn btnPackagesCategory");
  			Thread.sleep(1000);
  		}
  		
  		
  		//BUTTON ADD CATEGORY
  		@FindBy(xpath = "//span[normalize-space()='Add Category']")
  		@CacheLookup
  		public WebElement btnAddCategory;
  		public void clickOnBtnAddCategory() throws InterruptedException {
  			btnAddCategory.click();
  			logger.info("Clicked on the btn btnAddCategory");
  			Thread.sleep(1000);
  		}
  	
  		//BUTTON ADD CATEGORY
  		@FindBy(xpath = "//span[normalize-space()='Reorder Categories']")
  		@CacheLookup
  		public WebElement btnReOrderCategory;
  		public void clickOnBtnReOrderCategory() throws InterruptedException {
  			btnReOrderCategory.click();
  			logger.info("Clicked on the btn btnReOrderCategory");
  			Thread.sleep(1000);
  		}
  		
  		//TEXT FIELD PACKAGE CATEGORY TITLE
  		@FindBy(xpath = "//input[@placeholder='title']")
  		@CacheLookup
  		public WebElement fieldPackgeCategoryTitle;
  		public void setPackageCategoryTitles(String packageCategoryTitle) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldPackgeCategoryTitle));
  			fieldPackgeCategoryTitle.sendKeys(Keys.CONTROL,"a");
  			fieldPackgeCategoryTitle.sendKeys(Keys.DELETE);
  			fieldPackgeCategoryTitle.sendKeys(packageCategoryTitle);
  			logger.info("Entered the field package category title: "+packageCategoryTitle);
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD PACKAGE CATEGORY INTERAL TITLE
  		@FindBy(xpath = "//input[@placeholder='internal title']")
  		@CacheLookup
  		public WebElement fielPackgeCategoryInternalTitle;
  		public void setPackageCategoryInternalTitle(String packageCategoryInternalTitle) throws InterruptedException {
  			fielPackgeCategoryInternalTitle.sendKeys(Keys.CONTROL,"a");
  			fielPackgeCategoryInternalTitle.sendKeys(Keys.DELETE);
  			fielPackgeCategoryInternalTitle.sendKeys(packageCategoryInternalTitle);;
  			logger.info("Entered the field package categoryInternalTitle");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD PACKAGE CATEGORY DESCRITPION
  		@FindBy(xpath = "//textarea[@placeholder='Description']")
  		@CacheLookup
  		public WebElement filedPackageCategoryDescription;
  		public void setPackageCategoryDescription(String packageCategoryDescription) throws InterruptedException {
  			filedPackageCategoryDescription.sendKeys(Keys.CONTROL,"a");
  			filedPackageCategoryDescription.sendKeys(Keys.DELETE);
  			filedPackageCategoryDescription.sendKeys(packageCategoryDescription);;
  			logger.info("Entered the  filedPackageCategoryDescription");
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD PACKAGE TITLE/NAME
  		@FindBy(xpath = "//input[@placeholder='e.g. 3x/Week']")
  		@CacheLookup
  		public WebElement fieldPackageTitle;
  		public void setPackageTitile(String packageTitle) throws InterruptedException {
  			wait.until(ExpectedConditions.elementToBeClickable(fieldPackageTitle));
  			fieldPackageTitle.sendKeys(Keys.CONTROL,"a");
  			fieldPackageTitle.sendKeys(Keys.DELETE);
  			fieldPackageTitle.sendKeys(packageTitle);;
  			logger.info("Entered the field fieldPackageTitle: "+packageTitle);
  			Thread.sleep(300);
  		}
  	
  		//TEXT PACKAGE DESCRIPTION
  		@FindBy(xpath = "//textarea[@placeholder='Enter package description']")
  		@CacheLookup
  		public WebElement fieldpackageDescription;
  		public void setPackageDescriptoin(String packageDescriptoin) throws InterruptedException {
  			fieldpackageDescription.sendKeys(Keys.CONTROL,"a");
  			fieldpackageDescription.sendKeys(Keys.DELETE);
  			fieldpackageDescription.sendKeys(packageDescriptoin);;
  			logger.info("Entered the fieldpackageDescription");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD TOTAL CLASSES
  		@FindBy(xpath = "//input[@name='numberOfClass']")
  		@CacheLookup
  		public WebElement fieldTotalClasses;
  		public void setTotalClasses(String numberOfClasses) throws InterruptedException {
  			fieldTotalClasses.sendKeys(Keys.CONTROL,"a");
  			fieldTotalClasses.sendKeys(Keys.DELETE);
  			fieldTotalClasses.sendKeys(numberOfClasses);
  			logger.info("Enetered the fieldTotalClasses");
  			Thread.sleep(300);
  		}
		
  		//TEXT FIELD MINIMUM DURATION(CLASSES)
  		@FindBy(xpath = "//input[@name='minimumDurationMonths']")
  		@CacheLookup
  		public WebElement feildMinimumDurationS;
  		public void setMinimumDuration(String minimumDuration) throws InterruptedException {
  			feildMinimumDurationS.sendKeys(Keys.CONTROL,"a");
  			feildMinimumDurationS.sendKeys(Keys.DELETE);
  			feildMinimumDurationS.sendKeys(minimumDuration);
  			logger.info("Enetered the field feildMinimumDurationS");
  			Thread.sleep(300);
  		}
  		
  		
  		//TEXT FIELD REGULAR PRICE
  		@FindBy(xpath = "//input[@name='regularPrice']")
  		@CacheLookup
  		public WebElement fieldRegularPrice;
  		public void setRegularPrice(String regularPrice) throws InterruptedException {
  			fieldRegularPrice.sendKeys(Keys.CONTROL,"a");
  			fieldRegularPrice.sendKeys(Keys.DELETE);
  			fieldRegularPrice.sendKeys(regularPrice);
  			logger.info("Enetered the field fieldRegularPrice");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD DESCLAIMERS(DESCRIPTIONS)
  		@FindBy(xpath = "//div[@class='ql-container ql-snow']//p")
  		@CacheLookup
  		public WebElement fieldDisclaimers;
  		public void setDesclaimers(String desclaimers) throws InterruptedException {
  			fieldDisclaimers.sendKeys(Keys.CONTROL,"a");
  			fieldDisclaimers.sendKeys(Keys.DELETE);
  			fieldDisclaimers.sendKeys(desclaimers);
  			logger.info("Enetered the field fieldDisclaimers");
  			Thread.sleep(300);
  		}
  		
  		//TO SELECT THE CATEGORY LOCATIONS
  		public void selectCategoryLocation(String categoryLocation) throws InterruptedException {
  			ruae.clickOnDropdown_2_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,categoryLocation);
  			logger.info("Category location: "+categoryLocation);
  			Thread.sleep(500);
  		}
  		
  		//TO SELECT THE PACKAGE LOCATIONS
  		public void selectPackageLocation(String packageLocation) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,packageLocation);
  			logger.info("Package location: "+packageLocation);
  			Thread.sleep(500);
  		}
  		
  		
  		//TO SELECT THE CATEGORY
  		public void selectPackageCategory(String packageCategory) throws InterruptedException {
  			StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTraceElement[2].getMethodName();
  			if(callerMethodName.equals("addAndUpdatePackage")) {
  				Thread.sleep(1000);
  	  			driver.findElement(By.xpath("//div[@id='mui-component-select-PackageCategory']")).click();
  	  			
  			}else {
  				ruae.clickOnDropdownBoxAddress_1_RU();
  			}
  			
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,packageCategory);
  			logger.info("Package category Name: "+packageCategory);
  			Thread.sleep(500);
  		}
  		
  		
  		//TO SELECT THE CATEGORY
  		public void selectChargeInterval(String chargeInterval) throws InterruptedException {
  			ruae.clickOnDropdownBoxAddress_2_RU();
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,chargeInterval);
  			Thread.sleep(500);
  		}
  		
  		//TO CHECK SEARCH PACKAGE IS PRESENT OR NOT
  		@FindBy(xpath = "//span[.='No packages Matches Current Filter']")
  		@CacheLookup
  		WebElement textNoPackageMatchesCurrentFiter;
  		public boolean isTextNoPackageMachesCurrentFilter() {
  			boolean flag = false;
  			try {
  				if(textNoPackageMatchesCurrentFiter.isDisplayed()) {
  					logger.info("No Package matched to applied filter");
  					softAssert.assertTrue(false,"No Package Matches to the applied Current Fiter");
  					flag = true;
  	  			}
  			}catch(Exception e) {
  				logger.info("Exception from isTextNoPackageMachesCurrentFilter: "+e.getMessage());
  				logger.info("Package Matched to the Current Fiter");
  				softAssert.assertTrue(true,"Package Matches to the applied Current Fiter");
  				flag = false;
  			}
  			return flag;
  		}
  		
  		//TO CHECK SEARCH PACKAGE CATEGORY IS PRESENT OR NOT
  		@FindBy(xpath = "//span[.='No categories Matches Current Filter']")
  		@CacheLookup
  		WebElement textNoPackageCategoryMatchesCurrentFiter;
  		public boolean isTextNoPackageCategoryMachesCurrentFilter() {
  			boolean flag = false;
  			try {
  				if(textNoPackageCategoryMatchesCurrentFiter.isDisplayed()) {
  					logger.info("No Package Category matched to applied filter");
  					softAssert.assertTrue(false,"No Package  Category Matches to the applied Current Fiter");
  					flag = true;
  	  			}
  			}catch(Exception e) {
  				logger.info("Exception from textNoPackageCategoryMatchesCurrentFiter: "+e.getMessage());
  				logger.info("Package Category Matched to the Current Fiter");
  				softAssert.assertTrue(true,"Package Category Matches to the applied Current Fiter");
  				flag = false;
  			}
  			return flag;
  		}
  		
  		
  		
  		//PACKAGE ROW LIST ADDRESS AND ACTION METHODS
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex flex-col')])[2]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		public List <WebElement> packageRowList;
  		public String packageRowList_address = "(//div[contains(@class,'w-full flex flex-col')])[2]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findPackageFromRowListAndClickOnThreeDot(String packageTitle, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(packageRowList_address, packageRowList,driver, packageTitle, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				//listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(packageRowList,driver, packageTitle, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
			}catch(Exception e) {
				logger.info("Exception from findPackageFromRowListAndClickOnThreeDot: "+e.getMessage());
				softAssert.assertTrue(false,"not click on the three dot action button");
			}
			return listRowCount;
  		}
  		
  		//PACKAGE CATEGORY ROW LIST ADDRESS AND ACTION METHODS
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex flex-col')])[2]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		public List <WebElement> packageCategoryRowList;
  		public String packageCategoryRowList_address = "(//div[contains(@class,'w-full flex flex-col')])[2]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findPackageCategoryFromRowListAndClickOnThreeDot(String packageCategoryTitle, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				//listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(packageCategoryRowList,driver, packageCategoryTitle, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(packageCategoryRowList_address,packageCategoryRowList,driver, packageCategoryTitle, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findPackageCategoryFromRowListAndClickOnThreeDot: "+e.getMessage());
				softAssert.assertTrue(false,"not click on the three dot action button");
			}
			return listRowCount;
  		}
  		
  		
  		//TO SELECT THE PACKAGE STATUS
  		public void selectPackageStatus(String packageStatus) throws InterruptedException {
  			ruae.clickOnDropdownBoxAddress_1_RU();
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,packageStatus);
  			logger.info("Package status Name: "+packageStatus);
  			Thread.sleep(500);
  		}
  		
  		@FindBy(xpath = "//div[contains(text(),'Report')]")
  		@CacheLookup
  		WebElement btnPackageReport;
  		public void clickOnBtnReport_Package() throws InterruptedException
  		{
  			if(btnPackageReport.isDisplayed() && btnPackageReport.isEnabled())
  			{
  				action.moveToElement(btnPackageReport).build().perform();
  				Thread.sleep(500);
  				action.moveToElement(btnPackageReport).click().build().perform();
  				logger.info("Clicked on the Report button");
  			}
  			else {
  				logger.info("Report action button not present");
  				softAssert.assertTrue(false,"Report action button not present");
  			}
  			Thread.sleep(3000);
  		}
  		
  	
  		//TO FIND AND VIEW PACKAGE BUYERS USERS
  		@FindBy(xpath = "(//div[contains(@class,'w-full flex flex-col')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List <WebElement> listPackageBuyersUsers;
  		public String listPackageBuyersUsers_address = "(//div[contains(@class,'w-full flex flex-col')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findPackageBuyersUserFromList(String packageBuyersEmail, int packageBuyerssearchKeyColumnIndex, boolean packageBuyerswantToClickOnThreeDot, boolean packageBuyerswantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(listPackageBuyersUsers,driver, packageBuyersEmail, packageBuyerssearchKeyColumnIndex,packageBuyerswantToClickOnThreeDot, packageBuyerswantToclickOnFindSearckKey);
				logger.info("Package buyers user matched");
			}catch(Exception e) {
				logger.info("Exception from findPackageBuyersUserFromList: "+e.getMessage());
				softAssert.assertTrue(false,"Not found package buyers users");
			}
			return listRowCount;
  		}
  		
  		//TEXT NO PACKAGE BUYERS FOUND FOR THIS PACKAGE
  		@FindBy(xpath = "//span[.='No Users Found for this Package']")
  		@CacheLookup
  		WebElement textNoPackageBuyersFoundForThisPackage;
  		public boolean isNoPackageBuyersFoundForThisPackagePresent() throws InterruptedException
  		{
  			boolean flag = false;
  			try {
  				if(textNoPackageBuyersFoundForThisPackage.isDisplayed()) {
  					logger.info("No Package buyeres found for the fiven package");
  					softAssert.assertTrue(false,"No Package buyeres found for the fiven package");
  					flag = true;
  	  			}
  			}catch(Exception e) {
  				logger.info("Exception from isNoPackageBuyersFoundForThisPackagePresent: "+e.getMessage());
  				logger.info("Package Buyers Matched to the Current Fiter");
  				softAssert.assertTrue(true,"Package Buyers Matches to the applied Current Fiter");
  				flag = false;
  			}
  			return flag;
  		}
  	
  				
  		//TEXT MEMBERSHIP INSIGHT PRESENT
  		@FindBy(xpath = "//span[normalize-space()='Membership Insights']")
  		@CacheLookup
  		WebElement textMembershipInsightPresent;
  		public boolean isTextMembershipInsightPresent() throws InterruptedException
  		{
  			boolean flag = false;
  			try {
  					wait.until(ExpectedConditions.visibilityOf(textMembershipInsightPresent));
  				if(textMembershipInsightPresent.isDisplayed()) {
  					logger.info("isTextMembershipInsightPresent"+textMembershipInsightPresent.isDisplayed());
  					softAssert.assertTrue(true,"MembershipInsightPresent");
  					flag = true;
  					Thread.sleep(2000);
  	  			}
  			}catch(Exception e) {
  				logger.info("Exception from isTextMembershipInsightPresent: "+e.getMessage());
  				logger.info("Membership Insight Not Present");
  				softAssert.assertTrue(false,"Membership Insight Not Present");
  				flag = false;
  			}
  			
  			return flag;
  		}
  		
  		
  		
  			
  				
//======START=============ACTION METHODS============//		
  		
  		//TO ADD PACKAGE CATEGORY
  		public PO_Main_HomePage addAndUpdatePackageCategory(String packageCategoryTitle,String packageCategoryInternalTitle,String packageCategoryDescription,String categoryLocation,String wantToMarkCategoryHidden) throws InterruptedException
  		{
  			StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTraceElement[2].getMethodName();
  			
  			if(callerMethodName.equals("test_Main_UpdatePackageCategory")) {
  				Action_Edit.change(driver);
  			}else {
  				clickOnBtnPackagesCategory();
  				Thread.sleep(3000);
  	  			clickOnBtnAddCategory();
  			}

			logger.info("Methods called addAndUpdatePackageCategory and caller method name: "+callerMethodName);
			
  			Thread.sleep(3000);
  			setPackageCategoryTitles(packageCategoryTitle);
  			setPackageCategoryInternalTitle(packageCategoryInternalTitle);
  			setPackageCategoryDescription(packageCategoryDescription);
  			selectCategoryLocation(categoryLocation);
  			if(wantToMarkCategoryHidden.equalsIgnoreCase("Yes")) {
  				clickOnCheckBox_1_RU();
  				logger.info("Category marked as hidden by selecting check box");
  			}else {
  				logger.info("Category is visible to users");
  			}
  			boolean flag = ruae.clickOnBtnSave_1_RU();
  			if(flag) {
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgPackageCategoryCreatedSuccessfully)) {
  					softAssert.assertEquals(alertMsg, alertMsgPackageCategoryCreatedSuccessfully,"Checks Package category created successfully");
  				}else if(alertMsg.contains("required") || alertMsg.contains("Required")){
  	  				logger.info("===>>> PackageCategory not created, some required field missing");
  	  				ruae.clickOnCancelButton_1_RU();
  	  			}
  			}
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		//TO ADD PACKAGE
  		public PO_Main_HomePage addAndUpdatePackage(String packageName,String packageLocation,String packageCategory,String packgeDescription,String wantToInternalUseOnly,String chargeInterval,String totalClasses,String miniumDurationInMonth,String regularPrice,String packagedisclaimers ) throws InterruptedException 
  		{
  			
  			StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
  			String callerMethodName = stackTraceElement[2].getMethodName();
  			
  			if(callerMethodName.equals("test_Main_UpdatePackage")) {
  				Action_Edit.change(driver);
  			}else {
  				clickOnBtnAddPackages();
  			}

			logger.info("Methods called addAndUpdatePackage and caller method name: "+callerMethodName);
  			Thread.sleep(3000);
  			setPackageTitile(packageName);
  			selectPackageLocation(packageLocation);
  			selectPackageCategory(packageCategory);
  			setPackageDescriptoin(packgeDescription);
  			if(wantToInternalUseOnly.equalsIgnoreCase("Yes")) {
  				clickOnCheckBox_1_RU();
  				logger.info("Internal Use Only check box selected");
  			}else {
  				logger.info("Internal Use Only check box not selected");
  			}
  			selectChargeInterval(chargeInterval);
  			setTotalClasses(totalClasses);
  			setMinimumDuration(miniumDurationInMonth);
  			
  			if(callerMethodName.equals("test_Main_UpdatePackage")) {
  				logger.info("While update regular price field not present");
  			}else {
  				setRegularPrice(regularPrice);
  			}
  			
  			
  			
  			setDesclaimers(packagedisclaimers);
  			boolean flag = ruae.clickOnBtnSave_1_RU();
  			if(flag) {
  				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  				if(alertMsg.equals(alertMsgPackageCreatedSuccessfully)) {
  					softAssert.assertEquals(alertMsg, alertMsgPackageCreatedSuccessfully,"Checks Package created successfully");
  				}else if(alertMsg.equals(alertMsgPackageUpdatedSuccessfully)) {
  					softAssert.assertEquals(alertMsg, alertMsgPackageUpdatedSuccessfully,"Checks Package updated successfully");
  				}else if(alertMsg.contains("required") || alertMsg.contains("Required")) {
  					logger.info("===>>> Package not created, some required field missing");
  	  				ruae.clickOnCancelButton_1_RU();
  	  				softAssert.assertTrue(false,"Package neigher created nor updated");
  				}
  				
  			}
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//FIND PACKAGE AND CLICK ON THREE DOT BUTTON
  		public void findPackageAndClickOnThreeDot(String packageTitle,int searchKeyColumnIndex,boolean wantToClickOnThreeDot,String packageLocation,String packageStatus, boolean wantToclickOnFindSearckKey) throws InterruptedException
  		{
  			jsExecutor.executeScript("window.scrollBy(0, 100);");
  			Thread.sleep(2000);
  			searchBox_1_RU(driver,packageTitle);
  			selectPackageStatus(packageStatus);
  			selectPackageLocation(packageLocation);
  			boolean flag = isTextNoPackageMachesCurrentFilter();
  			if(!flag) {
  				int packageRowListCount = findPackageFromRowListAndClickOnThreeDot(packageTitle,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
  	  			Thread.sleep(1000);
  	  			logger.info("Package matched list count: "+packageRowListCount);
  			}else {
  				clickOnP360Logo_RU();
  			}
  			Thread.sleep(2000);
  			softAssert.assertAll();
  		}
  		
  		
  		//FIND PACAKGE CATEGORY AND CLICK ON THE THREE DOT ACTION BUTTON
  		public void findPackageCategoryAndClickOnThreeDot(String packageCategoryTitle,int searchKeyColumnIndex,boolean wantToClickOnThreeDot,String packageLocation, boolean wantToclickOnFindSearckKey) throws InterruptedException
  		{
  			Thread.sleep(2000);
  			clickOnBtnPackagesCategory();
  			Thread.sleep(3000);
  			selectPackageLocation(packageLocation);
  			searchKeyWordsBox_1_RU(driver,packageCategoryTitle);
  			
  			boolean flag = isTextNoPackageCategoryMachesCurrentFilter();
  			if(!flag) {
  				int packageCategoryRowListCount = findPackageCategoryFromRowListAndClickOnThreeDot(packageCategoryTitle,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
  	  			Thread.sleep(1000);
  	  			logger.info("Package category matched list count: "+packageCategoryRowListCount);
  			}else {
  				clickOnP360Logo_RU();
  			}
  			Thread.sleep(2000);
  			softAssert.assertAll();
  		}
  		
  		//TO ACTIVATE THE PACKAGE CATEGORY
  		public PO_Main_HomePage activatePackageCategory() throws InterruptedException
  		{
  			Action_Activate.activate(driver, alertMsgPackageCategoryActivated);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO DEACTIVATE THE PACKAGE CATEGORY
  		public PO_Main_HomePage deActivatePackageCategory() throws InterruptedException
  		{
  			Action_Deactivate.deactivate(driver, alertMsgPackageCategoryDeActivated);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO ARCHIVE THE PACKAGE CATEGORY
  		public PO_Main_HomePage archivePackageCategory() throws InterruptedException
  		{
  			Action_Archive.archive(driver, alertMsgPackageCategoryArchived);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO RESTORE THE PACKAGE CATEGORY
  		public PO_Main_HomePage restorePackageCategory() throws InterruptedException
  		{
  			Action_Restore.restore(driver, alertMsgPackageCategoryRestored);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		
  		//TO ACTIVATE THE PACKAGE
  		public PO_Main_HomePage activatePackage() throws InterruptedException
  		{
  			Action_Activate.activate(driver, alertMsgPackageActivated);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO DEACTIVATE THE PACKAGE
  		public PO_Main_HomePage deActivatePackage() throws InterruptedException
  		{
  			Action_Deactivate.deactivate(driver, alertMsgPackageDeActivated);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO ARCHIVE THE PACKAGE
  		public PO_Main_HomePage archivePackage() throws InterruptedException
  		{
  			Action_Archive.archive(driver, alertMsgPackageArchived);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO RESTORE THE PACKAGE
  		public PO_Main_HomePage restorePackage() throws InterruptedException
  		{
  			Action_Restore.restore(driver, alertMsgPackageRestored);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO VIEW THE PACKAGE REPORTS
  		public void viewPackageReport() throws InterruptedException
  		{
  			clickOnBtnReport_Package();
  			softAssert.assertAll();
  		}
  		
  		//FIND PACKAGE BUYRES USERS LIST AND CHECK THE USERS DETAILS
  		public PO_Main_HomePage findPackageBuyersUserListAndViewUsersDetails(String packageBuyersEmail,int packageBuyersSearchKeyColumnIndex,boolean packageBuyersWantToClickOnThreeDot,boolean packageBuyerswantToclickOnFindSearckKey) throws InterruptedException
  		{
  			searchBox_1_RU(driver,packageBuyersEmail);
  			int rowLisCount = 0;
  			boolean isPackageBuyersFound = isNoPackageBuyersFoundForThisPackagePresent();
  			if(!isPackageBuyersFound) {
  				try {
  	  				rowLisCount = findPackageBuyersUserFromList(packageBuyersEmail, packageBuyersSearchKeyColumnIndex, packageBuyersWantToClickOnThreeDot, packageBuyerswantToclickOnFindSearckKey);
  	  	  		}catch(Exception e) {
  	  	  			logger.info("Excetion from findPackageBuyersUserListAndViewUsersDetails: "+e.getMessage());
  	  	  		}
  			}else {
  				clickOnP360Logo_RU();
  			}
  			
  			logger.info("rowLisCount: "+rowLisCount);
  			isTextMembershipInsightPresent();
  			Thread.sleep(2000);
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
}
