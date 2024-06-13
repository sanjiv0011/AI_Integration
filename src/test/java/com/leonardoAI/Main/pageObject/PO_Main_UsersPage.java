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
import com.leonardoAI.projectUtility.FindThreeDotBasedOnSearchKeyAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_UsersPage extends ReUseAbleElement {
		
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
		public PO_Main_UsersPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(45));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}
		
		//ALERT MESSAGES
		public String alertMsgMemberhsipPurchagedSuccessfully = "Membership purchased successfully";
		public String alertMsgYourCardNumberIncomplete = "Your card number is incomplete.";
		public String alertMsgAcceptTermCondition = "Please accept term and conditions.";
		public String alertMsgMembeshipChangeSuccessfully = "Membership paused successfully";
		public String alertMsgMembershipResumedSuccessfully = "Mermbership Resumed.";
		public String alertMsgUserEmailAlreadyExist = "User with given email already exists.";
		public String alertMsgUserEmailChanged = "Email is updated successfully.";
		public String alertMsgUserLabelAdded = "User label Added.";
		public String alertMsgUserLabelAlreadyAdded = "User Label is already exists. Please use another Label";
		public String alertMsgUserLabelAssignToUser = "User labels assigned to user.";
		public String alertMsgUserAccountSuspended = "User Account Suspended.";
		public String alertMsgUserAccountUnlocked = "Unlocked user Account.";
		public String alertMsgMembershipPackageChanged = "Membership package changed successfully.";
		public String alertMsgCancelSubscriptionError = "There was an error getting the Execute Cancel Subscription for the criteria provided.";
		public String alertMsgCanceledSuccessfully = "Membership Canceled.";
		public String alertMsgCreditUpdated = "Credits updated.";
		public String alertMsgInvoiceSent = "Invoice sent.";
		
		
		
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
		
  		//TEXT FIELD FIRST NAME
  		@FindBy(xpath = "//input[@placeholder='Enter Last Name']")
  		@CacheLookup
  		public WebElement filedLastName;
  		public void setLastName(String lastName) throws InterruptedException {
  			filedLastName.sendKeys(Keys.CONTROL,"a");
  			filedLastName.sendKeys(Keys.DELETE);
  			filedLastName.sendKeys(lastName);;
  			logger.info("Clicked on the field last name");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD EMIAL
  		@FindBy(xpath = "//input[@placeholder='Enter Email Address']")
  		@CacheLookup
  		public WebElement feildEmail;
  		public void setEmail(String email) throws InterruptedException {
  			feildEmail.sendKeys(Keys.CONTROL,"a");
  			feildEmail.sendKeys(Keys.DELETE);
  			feildEmail.sendKeys(email);;
  			logger.info("Clicked on the field email");
  			Thread.sleep(300);
  		}
  		
  		//USERS FILTERS
  		@FindBy(xpath = "(//*[name()='svg'][@title='User Filters'])[1]")
  		@CacheLookup
  		public WebElement userFilters;
  		public void iconClickOnUsersFilters() throws InterruptedException {
  			userFilters.click();
  			logger.info("Clicked on the field email");
  			Thread.sleep(300);
  		}
  		
  		//BUTTON CLEARS FILTERS
  		@FindBy(xpath = "//div[normalize-space()='Clear Filter']")
  		@CacheLookup
  		public WebElement btnClearFilters;
  		public void clickOnBtnClearFilters() throws InterruptedException {
  			btnClearFilters.click();
  			logger.info("Clicked on the btnClearFilters");
  			Thread.sleep(300);
  		}
  		
// 		//LIST RADIO BUTTON CLEARS FILTERS
//  		@FindBy(xpath = "//div[contains(@class,'MuiFormGroup-root')]")
//  		@CacheLookup
  		public String  listUsreFilterRadioBtn_Address ="//div[contains(@class,'MuiFormGroup-root')]";
  		public void clickOnRadioBtn(String userFilterName) throws InterruptedException {
	  		/*	Active Members
	  	  		On Hold
	  	  		Hold Upcoming
	  	  		Cancel Upcoming
	  	  		Cancelled Members
	  		*/
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listUsreFilterRadioBtn_Address,userFilterName);
  			Thread.sleep(1000);	
  		}
  	
 
  				
  		//TEXT FIELD PHONE NUMBER
  		@FindBy(xpath = "//input[@placeholder='Enter Phone Number']")
  		@CacheLookup
  		public WebElement feildPhoneNumber;
  		public void setPhoneNumber(String phoneNumber) throws InterruptedException {
  			feildPhoneNumber.sendKeys(Keys.CONTROL,"a");
  			feildPhoneNumber.sendKeys(Keys.DELETE);
  			feildPhoneNumber.sendKeys(phoneNumber);
  			logger.info("Clicked on the field phone number");
  			Thread.sleep(300);
  		}
		
  		//TO SELECT THE LOCATION THE FROM THE LIST
  		public void selectLocation(String location) throws InterruptedException{	
  			clickOnDropdown_1_RU(driver);
  			//BELOW LINE IS USED TO AVOID THE STALE ELEMENT REFERENCE
  			//List<WebElement> listOption_RU = driver.findElements(By.xpath(ruae.listOptionAvoidStaleElementReference_RU)); 
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listOptionAddress_RU,location);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE REGION THE FROM THE LIST
  		public void selectRegion(String regionName) throws InterruptedException{	
  			clickOnDropdown_1_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listOptionAddress_RU,regionName);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE LOCATION WHILE USERS SEARCHING THE FROM THE LIST
  		public void selectLocationWhileUsersSearch(String location) throws InterruptedException{	
  			clickOnDropdown_2_RU(driver);
  			//BELOW LINE IS USED TO AVOID THE STALE ELEMENT REFERENCE
  			//List<WebElement> listOption_RU = driver.findElements(By.xpath(ruae.listOptionAvoidStaleElementReference_RU)); 
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listOptionAddress_RU,location);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE PACKAGE CATEGORY
  		public void selectPackageCategory(String packageName) throws InterruptedException{	
  			logger.info("SelectPackage methods called");
  			clickOnDropdownBoxAddress_1_RU();
  			//BELOW LINE IS USED TO AVOID THE STALE ELEMENT REFERENCE
  			//List<WebElement> listOption_RU = driver.findElements(By.xpath(ruae.listOptionAvoidStaleElementReference_RU)); 
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listOptionAddress_RU,packageName);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE PACKAGE CATEGORY
  		public void selectMembershipPackage(String membershipName) throws InterruptedException{	
  			logger.info("selectMembershipPackage methods called");
  			clickOnDropdownBoxAddress_2_RU();
  			//BELOW LINE IS USED TO AVOID THE STALE ELEMENT REFERENCE
  			//List<WebElement> listOption_RU = driver.findElements(By.xpath(ruae.listOptionAvoidStaleElementReference_RU)); 
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listOptionAddress_RU,membershipName);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE MEMBERSHIP START DATE
  		public void setMembershipStartDate(String membershipStartDate) throws Throwable {
  			clickOnDateIcon_1_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,membershipStartDate);
  			logger.info("Custom date, month and year entered");
  		    Thread.sleep(500);
  		}
  		
  		//TO SELECT THE CREDIT START DATE
  		public void setCreditStartDate(String creditStartDate) throws Throwable {
  			clickOnChangeDateIcon_1_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,creditStartDate);
  			logger.info("Custom date, month and year entered");
  		    Thread.sleep(500);
  		}
  		
  		//TO SELECT THE CREDIT END DATE
  		public void setCreditEndDate(String creditEndDate) throws Throwable {
  			clickOnChangeDateIcon_2_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,creditEndDate);
  			logger.info("Custom date, month and year entered");
  		    Thread.sleep(500);
  		}
  		
  		
  		//TO SELECT THE ACTION MENU ITEMS
  		public boolean selectThreeDotActionMenuItem(String menuItemName) throws InterruptedException{	
  			boolean flag = false;
  			try {
  				logger.info("methods called: selectActionMenuItem");
  	  			flag = Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listActionMenuItem_RU,menuItemName);
  	  			Thread.sleep(1000);
  	  			
  			}catch(Exception e) {
  				logger.info("Exception from selectThreeDotActionMenuItem: "+e.getCause());  
  				softAssert.assertTrue(flag, "Action button you want to select is not present");
  			}
  			return flag;
  		}
  	
  		
		public int findUsersAndClickOnThreeDotOption(String searchKey,WebDriver driver,int searchKeyColumnIndex,boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
			Thread.sleep(2000);
			int listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(ruae.listData_RU,driver, searchKey, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
			return listRowCount;
		}
  		
		//TO SELECT THE PUASE MEMBESHIP START DATE
		public void setPauseMembershipStartDate(String pauseStartDate) throws InterruptedException {
			boolean flag = false;
			try {
				clickOnChangeDateIcon_1_RU();
				DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,pauseStartDate);
				flag = true;
			    Thread.sleep(1000);
			   
			}catch(Throwable e) {
				logger.info("Exception from setPauseMembershipStartDate: "+e.getMessage());
				softAssert.assertTrue(false,"To check pause membership start date");
			}
			if(!flag) {
				clickOnBtnCross_RU();
				Thread.sleep(500);
				clickOnBtnCross_RU();
		    }
		}
		
		//TO SELECT THE PAUSE MEMBERSHIP END DATE
		public void setPauseMembershipEndDate(String pauseEndDate) throws InterruptedException {
			boolean flag = false;
			try {
				clickOnChangeDateIcon_2_RU();
				DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,pauseEndDate);
				flag = true;
			    Thread.sleep(1000);
			}catch(Throwable e) {
				logger.info("Exeception from setPauseMembershipEndDate: "+e.getMessage());
				softAssert.assertTrue(false,"To check pause membership end date");
			}
			if(!flag) {
				clickOnBtnCross_RU();
				clickOnBtnCross_RU();
		    }
		}
		
		@FindBy(xpath = "//label[contains(text(),'Select a reason')]")
		@CacheLookup
		public WebElement btnDrpSelectReason;
		
		//TO CLICK ON DROPDWON BUTTON SELECT MEMBERSHIP PAUSE REASON
		public void clickOnDrpReason() throws InterruptedException {
			clickOnDropdownBoxAddress_1_RU();
		}
		
		//TO SELECT THE PAUSE MEMBERSHIP REASON
		public void selectReason(String reason) throws InterruptedException {
			clickOnDrpReason();
			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,reason);
			Thread.sleep(1000);
			logger.info("Pause membership reason selected");
		}
		
		//TO CLICK ON PAUSE MEMBERSHIP BUTTON
		@FindBy(xpath = "//span[normalize-space()='Pause Membership']")
		@CacheLookup
		public WebElement btnPauseMembership;
		public boolean clickOnPauseMembership() {
			boolean flag = false;
			if(btnPauseMembership.isDisplayed()) {
				btnPauseMembership.click();
				flag = true;
				logger.info("Clicked on the: btnPauseMembership");
			}else {
				logger.info("Pause membership button not displayed");
			}
			return flag;
		}
		
		//TO CLICK ON PAUSE MEMBERSHIP BUTTON
		public String textElementMembership = "//span[normalize-space()='Membership']";
		public boolean isDisplayedElementMembership() {
			boolean flag = false;
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(textElementMembership)));
			WebElement elementMembership = 	driver.findElement(By.xpath(textElementMembership));
				if(elementMembership.isDisplayed()) {
					flag = true;
					logger.info("Is Membership present: "+flag);
				}else {
					logger.info("Pause membership button not displayed");
				}
			}catch(Exception e) {
				
			}
			return flag;
		}
		
		//TEXT FIELD NEW EMAIL
  		@FindBy(xpath = "//input[contains(@placeholder,'Enter Your Email')]")
  		@CacheLookup
  		public WebElement filedNewEmail;
  		public void setNewEmail(String newEmail) throws InterruptedException {
  			filedNewEmail.sendKeys(Keys.CONTROL,"a");
  			Thread.sleep(100);
  			filedNewEmail.sendKeys(Keys.DELETE);
  			Thread.sleep(100);
  			filedNewEmail.sendKeys(newEmail);
  			logger.info("Clicked on the field new email");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD CONFIRM NEW EMAIL
  		@FindBy(xpath = "//input[@placeholder='Confirm Email']")
  		@CacheLookup
  		public WebElement filedConfirmNewEmail;
  		public void setConfirmNewEmail(String confirmNewEmail) throws InterruptedException {
  			filedConfirmNewEmail.sendKeys(Keys.CONTROL,"a");
  			Thread.sleep(100);
  			filedConfirmNewEmail.sendKeys(Keys.DELETE);
  			Thread.sleep(100);
  			filedConfirmNewEmail.sendKeys(confirmNewEmail);
  			logger.info("Clicked on the confirm new email");
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD USER LABEL
  		@FindBy(xpath = "//input[@placeholder='Enter User Label']")
  		@CacheLookup
  		public WebElement filedUserLabel;
  		public void setUserLabel(String userLabel) throws InterruptedException {
  			filedUserLabel.sendKeys(Keys.CONTROL,"a");
  			Thread.sleep(100);
  			filedUserLabel.sendKeys(Keys.DELETE);
  			Thread.sleep(100);
  			filedUserLabel.sendKeys(userLabel);;
  			logger.info("Clicked on the filedUserLabel");
  			Thread.sleep(300);
  		}
		
  		//ADD BUTTON
  		@FindBy(xpath = "(//span[normalize-space()='Add'])[1]")
  		@CacheLookup
  		public WebElement btnAdd;
  		public boolean clickOnBtnAdd() throws InterruptedException {
  			boolean flag = false;
  			if(btnAdd.isDisplayed()) {
  				btnAdd.click();
  				flag = true;
  	  			logger.info("Clicked on the btnAdd");
  			}
  			return flag;
  		}
  		
//  		//ADD BUTTON
//  		@FindBy(xpath = "//div[@class='w-full']//div")
//  		@CacheLookup
// 		public List<WebElement> listUserLabel;
//  		public String listUserLabelCheckBox = "//input[@type='checkbox']";
  		public String listUserLabels = "//div[@class='w-full']//div";
  		public void selectUserLabel(String userLabel) throws InterruptedException {
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listUserLabels,userLabel);
			Thread.sleep(1000);
  		}
  		
		//RADIO BUTTON
		@FindBy(xpath = "//input[@type='radio']")
		@CacheLookup
		WebElement btnRadio;
		public void clickOnRadioButton() throws InterruptedException {
			btnRadio.click();
			logger.info("Clicked on the radio button");
			Thread.sleep(500);
		}
  		
		//DESCRIPTION CANCEL MEMBERSIHP REGION
  		@FindBy(xpath = "//textarea[contains(@placeholder,'Enter Cancellation Reason')]")
  		@CacheLookup
  		public WebElement descriptionCancelMembershipReason;
  		public void setDescriptionCancelMembershipReason(String descriptionCancelMemebershipReason) throws InterruptedException {
  			descriptionCancelMembershipReason.sendKeys(Keys.CONTROL,"a");
  			Thread.sleep(100);
  			descriptionCancelMembershipReason.sendKeys(Keys.DELETE);
  			Thread.sleep(100);
  			descriptionCancelMembershipReason.sendKeys(descriptionCancelMemebershipReason);;
  			logger.info("Clicked on the descriptionCancelMembershipReason");
  			Thread.sleep(300);
  		}
		
  		//TO SELECT THE MEMBERSHIP START DATE
  		public void setCancelMembershipCustomDate(String CancelmembershipCustomDate) throws Throwable {
  			clickOnChangeDateIcon_1_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,CancelmembershipCustomDate);
  			logger.info("Custom date, month and year entered");
  		    Thread.sleep(500);
  		}
  		
  		//RADIO BUTTON
		@FindBy(xpath = "//span[@class='MuiButton-label'][normalize-space()='Cancel Membership']")
		@CacheLookup
		WebElement btnCancelMembershipFinal;
		public boolean clickOnBtnCancelMembershipFinal() throws InterruptedException {
			boolean flag = false;
			if(btnCancelMembershipFinal.isDisplayed()) {
				btnCancelMembershipFinal.click();
				flag = true;
				logger.info("Clicked on the radio button");
				Thread.sleep(500);
			}
			return flag;
		}
  		
		//RADIO BUTTON
		@FindBy(xpath = "//span[normalize-space()='Renew Membership']")
		@CacheLookup
		WebElement btnRenewMembership;
		public boolean clickOnBtnRenewMembership() throws InterruptedException {
			boolean flag = false;
			if(btnRenewMembership.isDisplayed()) {
				btnRenewMembership.click();
				flag = true;
				logger.info("Clicked on the button renew membership");
				Thread.sleep(500);
			}
			return flag;
		}
		
		//RADIO BUTTON END OF BILLING CYCLE
		@FindBy(xpath = "//span[normalize-space()='Cancel at End of Billing Cycle']")
		@CacheLookup
		WebElement radiOnBtnEndOfBillingCycle;
		public boolean clickOnRadioBtnEndOfBillingCycle() throws InterruptedException {
			boolean flag = false;
			try {
				if(radiOnBtnEndOfBillingCycle.isDisplayed()) {
					action.moveToElement(radioBtnCancelCustomDate).build().perform();
					radiOnBtnEndOfBillingCycle.click();
					flag = true;
					logger.info("Clicked on the button radiOnBtnEndOfBillingCycle");
					Thread.sleep(500);
				}
			}catch(Exception e) {
				logger.info("Exception from clickOnRadioBtnCancelCustomDate: "+e.getMessage());
				softAssert.assertEquals(flag,true,"radiOnBtnEndOfBillingCycle not found");
			}
			return flag;
		}
		
		//RADIO BUTTON SELECT CANCEL CUSTOME DATE
		@FindBy(xpath = "//span[normalize-space()='Cancel at a Custom Date']")
		@CacheLookup
		WebElement radioBtnCancelCustomDate;
		public boolean clickOnRadioBtnCancelCustomDate() throws InterruptedException {
			boolean flag = false;
			try {
				if(radioBtnCancelCustomDate.isDisplayed()) {
					action.moveToElement(radioBtnCancelCustomDate).build().perform();
					radioBtnCancelCustomDate.click();
					flag = true;
					logger.info("Clicked on the button renew membership");
					Thread.sleep(500);
				}
			}catch(Exception e) {
				logger.info("Exception from clickOnRadioBtnCancelCustomDate: "+e.getMessage());
				softAssert.assertEquals(flag,true,"radioBtnCancelCustomDate not found");
			}
			return flag;
		}
			
		//TO SELECT THE CHECKBOX AGREE PRICING
		@FindBy(xpath = "//input[@id='agreeToPricing']")
		@CacheLookup
		WebElement checkboxAgreePricing;
		public void checkCheckboxAgreePricing() throws InterruptedException {
			if(checkboxAgreePricing.isSelected()) {
				logger.info("Agree pricing checkbox already selected");
			}else {
				checkboxAgreePricing.click();
				logger.info("Agree pricing checkbox selected");
				Thread.sleep(500);
			}
		}
		
		//TO SELECT THE CHECKBOX AGREE PRICING
		@FindBy(xpath = "(//input[@id='agreeCheckbox'])[1]")
		@CacheLookup
		WebElement checkboxAgreeCondition;
		public void checkCheckboxAgreeCondition() throws InterruptedException {
			if(checkboxAgreeCondition.isSelected()) {
				logger.info("Agree pricing checkbox already selected");
			}else {
				checkboxAgreeCondition.click();
				logger.info("Agree pricing checkbox selected");
				Thread.sleep(500);
			}
		}
  
		//CLASS HISOTRY LIST
		@FindBy(xpath = "(//div[contains(@class,'grid grid-cols-1 gap-2')])[1]//div[contains(@class,'flex-row')]")
		@CacheLookup
		WebElement listClassHistory;
		public void selectClassHistory() throws InterruptedException {
			
		}
				
		//PAYMENT HISOTRY LIST
		@FindBy(xpath = "(//div[contains(@class,'grid grid-cols-1 gap-2')])[2]//div[contains(@class,'flex-row')]")
		@CacheLookup
		public List<WebElement> listPaymentHistory;
		public String listPaymentHistory_address = "(//div[contains(@class,'grid grid-cols-1 gap-2')])[2]//div[contains(@class,'flex-row')]";
		public boolean findHistoryAndClickOnThreeDotOption(String searchKey,WebDriver driver,int searchKeyColumnIndex,boolean wantToClickOnThreeDot,boolean wantToclickOnFindSearckKey) throws InterruptedException {
			int listRowCount = 0;
			boolean flag = false;
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(listPaymentHistory,driver, searchKey, searchKeyColumnIndex,wantToClickOnThreeDot, wantToclickOnFindSearckKey);
				String sendInvoice_Address = "(//div[contains(text(),'Send Invoice')])["+listRowCount+"]";
				Thread.sleep(500);
				WebElement sendInvoice = driver.findElement(By.xpath(sendInvoice_Address));
				action.moveToElement(sendInvoice).build().perform();
				Thread.sleep(300);
				sendInvoice.click();
				flag  = true;
				logger.info("Clicked no the send invoice button");
			}catch(Exception e) {
				logger.info("Exception from findHistoryAndClickOnThreeDotOption: "+e.getMessage());
				softAssert.assertTrue(flag,"findHistoryAndClickOnThreeDotOption");
			}
			return flag;
		}
		
		//MEMBERS CREDIT HISOTRY LIST
		@FindBy(xpath = "(//div[contains(@class,'grid grid-cols-1 gap-2')])[3]//div[contains(@class,'flex-row')]")
		@CacheLookup
		public List <WebElement> listMemberCreditHistory;
		public String listMemberCreditHistory_address = "(//div[contains(@class,'grid grid-cols-1 gap-2')])[3]//div[contains(@class,'flex-row')]";
		public int findMemberCreditAndClickOnThreeDotOption(String searchKey,WebDriver driver,int searchKeyColumnIndex,boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
			boolean flag = false;
			int listRowCount =0;
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotBasedOnSearchKeyAndClick.findThreedActionButtonAndClick(listMemberCreditHistory,driver, searchKey, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				String changeMembeshipCredit_Address = "(//div[contains(@class,'ml-2 font-RobotoMedium')][normalize-space()='Change'])["+listRowCount+"]";
				Thread.sleep(500);
				driver.findElement(By.xpath(changeMembeshipCredit_Address)).click();
				flag = true;
				logger.info("Clicked no the change button");
			}catch(Exception e) {
				logger.info("Exceptin from findMemberCreditAndClickOnThreeDotOption: "+e.getMessage());
				softAssert.assertTrue(flag,"findMemberCreditAndClickOnThreeDotOption");
			}
			return listRowCount;
		}
		
		
		//TEXT FIELD TOTAL CREDITS
  		@FindBy(xpath = "//input[contains(@placeholder,'Enter Available Credits')]")
  		@CacheLookup
  		public WebElement fieldTotalCredit;
  		public void setTotalCredit(String totalCredit) throws InterruptedException {
  			fieldTotalCredit.sendKeys(Keys.CONTROL,"a");
  			Thread.sleep(100);
  			fieldTotalCredit.sendKeys(Keys.DELETE);
  			Thread.sleep(100);
  			fieldTotalCredit.sendKeys(totalCredit);;
  			logger.info("Clicked on the fieldTotalCredit");
  			Thread.sleep(300);
  		}
		
  		//TEXT FIELD USED CREDITS
  		@FindBy(xpath = "//input[@placeholder='Enter Used Credits']")
  		@CacheLookup
  		public WebElement fieldUsedCredit;
  		public void setUsedCredit(String usedCredit) throws InterruptedException {
  			fieldUsedCredit.sendKeys(Keys.CONTROL,"a");
  			Thread.sleep(100);
  			fieldUsedCredit.sendKeys(Keys.DELETE);
  			Thread.sleep(100);
  			fieldUsedCredit.sendKeys(usedCredit);;
  			logger.info("Clicked on the fieldUsedCredit");
  			Thread.sleep(300);
  		}
  		
  		//TEXT AREA ADD COMMENTS
		@FindBy(xpath = "//textarea[@placeholder='Add comments here']")
		@CacheLookup
		public WebElement textAreaAddComment;
		public void setComment(String comment) throws InterruptedException {
			textAreaAddComment.sendKeys(Keys.CONTROL,"a");
			Thread.sleep(100);
			textAreaAddComment.sendKeys(Keys.DELETE);
			Thread.sleep(100);
			textAreaAddComment.sendKeys(comment);;
			logger.info("Clicked on the textAreaAddComment");
			Thread.sleep(300);
		}
  		
		
		
		
  		
//=======START============ACTIONS METHODS========================//	
		
		
  		//TO ADD MEMBER
  		public PO_Main_HomePage addMember(String firstName, String lastName, String phoneNumber, String email, String location, String packageName, String membershipName, String membershipStartDate) throws Throwable 
  		{
  			clickOnAddMember_RU();
  			setFirstName(firstName);
  			setLastName(lastName);
  			setEmail(email);
  			logger.info("User first name: "+firstName);
  			logger.info("User last name: "+lastName);
  			logger.info("User email: "+email);
  			setPhoneNumber(phoneNumber);
  			clickONBtnContinue_RU();
  			selectLocation(location);
  			Thread.sleep(300);
  			selectPackageCategory(packageName);
  			Thread.sleep(300);
  			selectMembershipPackage(membershipName);
  			Thread.sleep(300);
  			setMembershipStartDate(membershipStartDate);
  			clickONBtnContinueAvoidStaleElemenetRefernce_RU(driver);
  			clickOnCheckBox_1_RU();
  			logger.info("Waiting for 20 seconds to enter the card details");
  			Thread.sleep(20000);
  			jsExecutor.executeScript("window.scrollBy(0, 200);");
  			Thread.sleep(500);
  			clickOnCheckBox_2_RU();
  			action.scrollByAmount(0, 300).build().perform();
  			Thread.sleep(1000);
  			clickOnAddMemberAvoidStaleElementReference_1_RU(driver);
  			Thread.sleep(1000);
  			String alertMsg = snakeAlertMessagesDisplayedContent_RU();
  			if(alertMsg.equals(alertMsgMemberhsipPurchagedSuccessfully)) {
  				softAssert.assertEquals(alertMsg,alertMsgMemberhsipPurchagedSuccessfully,"Check user added successfully");
  				logger.info("===>>> "+alertMsg);
  			}else {
  				logger.info("Alert Message displayed: "+alertMsgMemberhsipPurchagedSuccessfully);
  			}
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		
  		
  		//TO FIND SPECIFIC USERS AND CLICK ON IT
  		public void findUsersAndViewUsersDetails(String searchKeyuserNameOrEmail,String regionName,String locationName,int searchKeyColumnIndex, boolean wantToClickOnUser,int listActionIndex,boolean wantToclickOnFindSearckKey) throws InterruptedException
  		{
  			selectRegion(regionName);
  			selectLocationWhileUsersSearch(locationName);
  			searchBox_1_RU(driver,searchKeyuserNameOrEmail);
  			int listRowCount = findUsersAndClickOnThreeDotOption(searchKeyuserNameOrEmail,driver,searchKeyColumnIndex,wantToClickOnUser,wantToclickOnFindSearckKey);
  			logger.info("listRowCount:  "+listRowCount);
  			if(listRowCount != -1) {	
  				clickOnAnyActionBtnPresentUnderThreeDotOption_RU(driver,listActionIndex);
  				Thread.sleep(3000);
			}else {
				softAssert.assertTrue(false,"User you want to search is not present");
			}
  			softAssert.assertAll();
  			//NOTE: NOT TAKING RETURN TYPE IN THIS, SO THAT IT WILL STAY ON THE USERS DETAILS PAGE
  		}
  		
  		//TO PAUSE MEMBERSHIP
  		public PO_Main_HomePage pauseMembership(String pauseStartDate, String pauseEndDate, String pauseReason) throws InterruptedException {
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			boolean bol = selectThreeDotActionMenuItem("Pause Membership");
  	  			if(bol) {
	  	  			setPauseMembershipStartDate(pauseStartDate);
	  	  			setPauseMembershipEndDate(pauseEndDate);
	  	  			selectReason(pauseReason);
	  	  			boolean flag = clickOnPauseMembership();
	  	  			if(flag) {
	  	  				String alertContent = snakeAlertMessagesDisplayedContent_RU();
	  	  				if(alertContent.equalsIgnoreCase(alertMsgMembeshipChangeSuccessfully)) {
	  	  					logger.info("===>>> "+alertMsgMembeshipChangeSuccessfully);
	  	  				}else {
	  	  					logger.info("===>>> "+alertContent);
	  	  				}
	  	  			softAssert.assertEquals(alertContent, alertMsgMembeshipChangeSuccessfully,"To check membership paused or not");
	  	  			}
  	  			}else {
  	  				softAssert.assertTrue(false,"You want to pause membership but this action button not present");
  	  				clickOnP360Logo_RU();
	  			}
  	  			
  			}
  			softAssert.assertAll();	
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO RESUME MEMBERSHIP
  		public PO_Main_HomePage resumeMembership() throws InterruptedException {
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			boolean bol = selectThreeDotActionMenuItem("Resume Membership");
  	  			if(bol) {
	  	  			boolean flag = clickOnBtnYes_RU(driver);
	  	  			if(flag) {
  	  				String alertContent = snakeAlertMessagesDisplayedContent_RU();
  	  				if(alertContent.equalsIgnoreCase(alertMsgMembershipResumedSuccessfully)) {
  	  					logger.info("===>>> "+alertMsgMembershipResumedSuccessfully);
  	  				}else {
  	  					logger.info("===>>> "+alertContent);
  	  				}
  	  				softAssert.assertEquals(alertContent, alertMsgMembershipResumedSuccessfully,"To check membership resume or  not");
  	  				}
  	  			}else {
  	  				softAssert.assertTrue(false,"You want to resume membership but this action button not present");
  	  				clickOnP360Logo_RU();
	  				
  	  			}
  			}
  			softAssert.assertAll();	
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//AGREED TERM
  		public PO_Main_HomePage checkAgreedTerm() throws InterruptedException {
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			boolean bol = selectThreeDotActionMenuItem("Agreed Terms");
  	  			if(bol) {
	  	  			jsExecutor.executeScript("window.scrollBy(0, 200);");
	  	  			clickOnCancelButton_1_RU();
  	  			}else {
  	  				softAssert.assertTrue(false,"You want to check agreement but this action button not present");
	  				clickOnP360Logo_RU();
  	  			}
  			}
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO CHANGE EMAIL
  		public PO_Main_HomePage changeEmail(String newEmail,String confirmNewEmail) throws InterruptedException {
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			boolean bol = selectThreeDotActionMenuItem("Change Email");
	  	  		if(bol) {
		  	  		setNewEmail(newEmail);
		  	  		setConfirmNewEmail(confirmNewEmail);
		  	  		clickOnBtnSave_1_RU();
		  	  		String alertContent = snakeAlertMessagesDisplayedContent_RU();
					if(alertContent.equalsIgnoreCase(alertMsgUserEmailChanged)) {
						logger.info("===>>> "+alertMsgUserEmailChanged);
					}else {
						logger.info("===>>> "+alertContent);
						clickOnCancelButton_1_RU();
						Thread.sleep(500);
					}
					softAssert.assertEquals(alertContent, alertMsgUserEmailChanged,"To check email change or not");
			
	  	  		}else {
		  	  		softAssert.assertTrue(false,"You want to change email but this action button not present");
	  	  			clickOnP360Logo_RU();
	  	  		}
  			}
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO CREATE AND ASSIGN USER LABELS
  		public PO_Main_HomePage userLabelAssignment(String userLabel) throws InterruptedException {
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			boolean bol = selectThreeDotActionMenuItem("Assign Labels");
  	  			if(bol) {
	  	  			WebElement userLabelFram = driver.findElement(By.xpath("//div[@class='w-full']"));
	  	  			Thread.sleep(1000);
	  	  			action.moveToElement(userLabelFram).build().perform();
	  	  			Thread.sleep(1000);
	  	  			jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	  	  			Thread.sleep(2000);
	  	  			selectUserLabel(userLabel);
	  	  			Thread.sleep(1000);
	  	  			clickOnBtnSave_1_RU();
		  	  		String alertContent = snakeAlertMessagesDisplayedContent_RU();
					if(alertContent.equalsIgnoreCase(alertMsgUserLabelAssignToUser)) {
						logger.info("===>>> "+alertMsgUserLabelAssignToUser);
					}else {
						clickOnCancelButton_1_RU();
						logger.info("===>>> "+alertContent);
						softAssert.assertTrue(false,"User label not assigned to the users");
						Thread.sleep(500);
					}
  	  			}else {
  	  				softAssert.assertTrue(false,"You want to assign labels but this action button not present");
  	  				clickOnP360Logo_RU();
  	  			}
  	  		}
  	  		
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO CREATE USER LABELS
  		public PO_Main_HomePage createUserLabel(String newUserLabelName) throws InterruptedException {
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			boolean bol = selectThreeDotActionMenuItem("Assign Labels");
  				if(bol) {
  					setUserLabel(newUserLabelName);
  	  				boolean flag = clickOnBtnAdd();
  	  				if(flag) {
  	  					String alertContent = snakeAlertMessagesDisplayedContent_RU();
  	  					if(alertContent.equalsIgnoreCase(alertMsgUserLabelAdded)) {
  	  						logger.info("===>>> "+alertMsgUserLabelAdded);
  	  					}else if(alertContent.equalsIgnoreCase(alertMsgUserLabelAlreadyAdded)) {
  	  						clickOnCancelButton_1_RU();
  	  						softAssert.assertTrue(false,"User label already exist");
  	  					}else {
  	  						logger.info("===>>> "+alertContent);
  	  						clickOnCancelButton_1_RU();
  	  						softAssert.assertTrue(false,"User label not added");
  	  						Thread.sleep(500);
  	  					}
  	  				}
  				}else {
  	  				softAssert.assertTrue(false,"You want to user label but this action button not present");
  	  				clickOnP360Logo_RU();
  				}
  	  
  			}
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO SUSPENDS ACCOUNT
  		public PO_Main_HomePage suspendsAccount() throws InterruptedException {
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			
  	  			boolean bol = selectThreeDotActionMenuItem("Suspend Account");
  	  			if(bol) {
	  	  			if(clickOnBtnYes_RU(driver)) {
	  	  				String alertContent = snakeAlertMessagesDisplayedContent_RU();
						if(alertContent.equalsIgnoreCase(alertMsgUserAccountSuspended)) {
							logger.info("===>>> "+alertMsgUserAccountSuspended);
						}else {
							clickOnCancelButton_1_RU();
							softAssert.assertTrue(false,"User account not suspended");
						}
	  	  			}
  	  			}else {
  	  				softAssert.assertTrue(false,"You want to suspend user account but this action button not present");
  	  				clickOnP360Logo_RU();
  	  			}
  	  			
  			}
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO UNLOCK ACCOUNT
  		public PO_Main_HomePage unlockUserAccount() throws InterruptedException {
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			
  	  			boolean bol = selectThreeDotActionMenuItem("Unlock Account");
  	  			
  	  			if(bol) {
	  	  			if(clickOnBtnYes_RU(driver)) {
	  	  				String alertContent = snakeAlertMessagesDisplayedContent_RU();
						if(alertContent.equalsIgnoreCase(alertMsgUserAccountUnlocked)) {
							logger.info("===>>> "+alertMsgUserAccountUnlocked);
						}else {
							clickOnCancelButton_1_RU();
							softAssert.assertTrue(false,"User account not Unlocked");
						}
	  	  			}
  	  			}else {
  	  				softAssert.assertTrue(false,"You want to unlock user account but this action button not present");
  	  				clickOnP360Logo_RU();
  	  			}
  			}
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO CHANGE MEMBERSHIP
  		public PO_Main_HomePage changeMembership(String packageName, String membershipName) throws InterruptedException {
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			
  	  			boolean bol = selectThreeDotActionMenuItem("Change Membership Package");
  	  			
  	  			if(bol) {
	  	  			selectPackageCategory(packageName);
	  	  			selectMembershipPackage(membershipName);
	  	  			clickOnCheckBox_1_RU();
	  	  			clickOnRadioButton();
	  	  			boolean flag = clickOnBtnSave_1_RU();
	  				if(flag) {
	  					String alertContent = snakeAlertMessagesDisplayedContent_RU();
	  					if(alertContent.equalsIgnoreCase(alertMsgMembershipPackageChanged)) {
	  						logger.info("===>>> "+alertMsgMembershipPackageChanged);
	  					}else {
	  						clickOnCancelButton_1_RU();
	  						logger.info("===>>> "+alertContent);
	  						softAssert.assertTrue(false,"User membership not change");
	  					}
	  				}
  	  			
  	  			}else {
  	  				softAssert.assertTrue(false,"You want to change membership but this action button not present");
  	  				clickOnP360Logo_RU();
  	  			}
  			}
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//TO CANCEL MEMBERSHIP
  		public PO_Main_HomePage cancelMembership(String CancelmembershipCustomDate, String description, boolean wantToSelectCustomDate) throws Throwable {
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			
  	  			boolean bol = selectThreeDotActionMenuItem("Cancel Membership");
  	  			if(bol) {
	  	  			if(wantToSelectCustomDate) {
	  	  				clickOnRadioBtnCancelCustomDate();
	  	  				setCancelMembershipCustomDate(CancelmembershipCustomDate);
	  	  			}else {
	  	  				clickOnRadioBtnEndOfBillingCycle();
	  	  			}
	  	  			setDescriptionCancelMembershipReason(description);
	  	  			
	  	  			clickOnBtnSave_1_RU();
	  	  			boolean flag = clickOnBtnCancelMembershipFinal();
	  				if(flag) {
	  					String alertContent = snakeAlertMessagesDisplayedContent_RU();
	  					if(alertContent.equalsIgnoreCase(alertMsgCanceledSuccessfully)) {
	  						logger.info("===>>> "+alertMsgCanceledSuccessfully);
	  					}else {
	  						Thread.sleep(500);
	  						clickOnCancelButton_2_RU();
	  						logger.info("===>>> "+alertContent);
	  						Thread.sleep(300);
	  						softAssert.assertTrue(false,"Membership not Canceled");
	  					}
	  				}
  	  			}else {
  	  				softAssert.assertTrue(false,"You want to cancel membership but this action button not present");
  	  				clickOnP360Logo_RU();
  	  			}
  	  			
  	  			
  			}
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  		}
  		
  		//RENEW MEMBERSHIP
  		public PO_Main_HomePage renewMembership(String location, String packageName, String membershipName,String membershipStartDate) throws Throwable 
  		{
  			if(isDisplayedElementMembership()) {
  				Thread.sleep(1000);
  				clickOnActionButton_1_RU();
  	  			
  	  			boolean bol = selectThreeDotActionMenuItem("Renew Membership");
  	  			if(bol) {

  		  	  		selectLocation(location);
  		  			Thread.sleep(300);
  		  			selectPackageCategory(packageName);
  		  			Thread.sleep(300);
  		  			selectMembershipPackage(membershipName);
  		  			setMembershipStartDate(membershipStartDate);
  		  			clickOnCheckBox_1_RU();
  		  			clickONBtnContinue_RU();
  		  			checkCheckboxAgreePricing();
  		  			clickOnRadioButton_1_RU();
  		  			checkCheckboxAgreeCondition();
  		  			
  	  	  			boolean flag = clickOnBtnRenewMembership();
  	  				if(flag) {
  	  					String alertContent = snakeAlertMessagesDisplayedContent_RU();
  	  					if(alertContent.equalsIgnoreCase(alertMsgMemberhsipPurchagedSuccessfully)) {
  	  						logger.info("===>>> "+alertMsgMemberhsipPurchagedSuccessfully);
  	  					}else {
  	  						Thread.sleep(500);
  	  						clickOnCancelButton_2_RU();
  	  						logger.info("===>>> "+alertContent);
  	  						Thread.sleep(300);
  	  						softAssert.assertTrue(false,"Membership not renew");
  	  					}
  	  				}
  	  			}else {
  	  				softAssert.assertTrue(false,"You want to renew membership but this action button not present");
  	  				clickOnP360Logo_RU();
  	  			}
  	  			
  			}
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  			
  		}
  		
  		//CHANGE MEMBERS CREDIT
  		public PO_Main_HomePage changeMemberCredit(String creditStartDate, String creditEndDate, String totalCredit,String usedCredit, String comment,String searchKey, int searchKeyColumnIndex,boolean wantToClickOnThreeDot,boolean wantToclickOnFindSearckKey) throws Throwable 
  		{
  			jsExecutor.executeScript("window.scrollBy(0, 400);");
  			Thread.sleep(2000);
  			
			findMemberCreditAndClickOnThreeDotOption(searchKey,driver,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
  			setTotalCredit(totalCredit);
  			setUsedCredit(usedCredit);
  			setComment(comment);
  			setCreditStartDate(creditStartDate);
  			setCreditEndDate(creditEndDate);
  			
  			boolean flag = clickOnBtnSaveChangesSpan_RU();
			if(flag) {
				String alertContent = snakeAlertMessagesDisplayedContent_RU();
				if(alertContent.equalsIgnoreCase(alertMsgCreditUpdated)) {
					logger.info("===>>> "+alertMsgCreditUpdated);
				}else {
					Thread.sleep(500);
					clickOnCancelButton_1_RU();
					logger.info("===>>> "+alertContent);
					Thread.sleep(300);
					softAssert.assertTrue(false,"Members credit not change");
				}
			}
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  			
  		}
  		
  		
  		//SEND INVOICE
  		public PO_Main_HomePage sendInvoice(String searchKey, int searchKeyColumnIndex,boolean wantToClickOnThreeDot,boolean wantToclickOnFindSearckKey) throws Throwable 
  		{
  			jsExecutor.executeScript("window.scrollBy(0, 400);");
  			Thread.sleep(2000);
  			boolean flag = false;
  			flag = findHistoryAndClickOnThreeDotOption(searchKey,driver,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
  			
			if(flag) {
				String alertContent = snakeAlertMessagesDisplayedContent_RU();
				if(alertContent.equalsIgnoreCase(alertMsgInvoiceSent)) {
					logger.info("===>>> "+alertMsgInvoiceSent);
				}else {
					Thread.sleep(500);
					logger.info("===>>> "+alertContent);
					Thread.sleep(300);
					softAssert.assertTrue(false,"Invoice not sent");
				}
			}
  			softAssert.assertAll();	
  			Thread.sleep(1000);
  			return new PO_Main_HomePage(driver);
  			
  		}
  		
  		
}
