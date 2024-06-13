package com.leonardoAI.pageObject;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;
import com.leonardoAI.dataBaseTesting.DBT_User_Membership;
import com.leonardoAI.projectUtility.DatePicker;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;


public class PO_MembershipPage extends ReUseAbleElement{
	
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
	public PO_MembershipPage(WebDriver driver) {	
		super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);
		

	}
	
	//ALERT MESSAGES
	String alertMsgResumeMembership = "Your membership has been resumed successfully";
	String alertMsgPauseMembershipMoreThenOneTimeInAQuarter = "Memberships can only be paused once in a quarter";
	String alertMsgPauseMembership = "Pause Membership Successfully";
	String alertMsgSelectMemberhsipPackage = "Please select membership package.";
	String alertMsgChangeMembership = "Membership Package Changed.";
	String alertMsgNoActiveSubscription = "No active subscription found matching the user";
	String alertMsgErrorChangeSubscription = "There was an error creating change subscription.";
	
	//=========START========MEMBERSHIP PAGE OBJECTS=============//
	@FindBy(xpath = "//span[normalize-space()='Manage Membership']")
	@CacheLookup
	public WebElement btnManageMembership;
	
	@FindBy(xpath = "//div[contains(@class,\"MuiInputBase-fullWidth\")]")
	@CacheLookup
	public WebElement btnDrpSelctCategory;
	
	
//	// it is give the list of category present under this dropdown
//	@FindBy(xpath = "//div[@class='text-red text-base capitalize']")
//	@CacheLookup
//	public List <WebElement> listPackageName;
	public String listPackageName = "//div[@class='text-red text-base capitalize']";
			
	@FindBy(xpath = "//span[contains(text(), 'Change Membership')]")
	@CacheLookup
	public WebElement btnChangeMembership;
	
	@FindBy(xpath = "//div[@id='notistack-snackbar']")
	@CacheLookup
	public WebElement slidebarConfirmation;
	
	@FindBy(xpath = "//span[normalize-space()='Agreed Terms']")
	@CacheLookup
	public WebElement btnAgreeTerm;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[3]")
	@CacheLookup
	public WebElement RadioBtn_3;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[4]")
	@CacheLookup
	public WebElement RadioBtn_4;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[5]")
	@CacheLookup
	public WebElement RadioBtn_5;
	
	@FindBy(xpath = "//span[normalize-space()='Pause Membership']")
	@CacheLookup
	public WebElement btnPauseMembership;
	
	@FindBy(xpath = "//span[normalize-space()='Resume Membership']")
	@CacheLookup
	public WebElement btnResumeMembership;
	
	@FindBy(xpath = "//label[contains(text(),'Select a reason')]")
	@CacheLookup
	public WebElement btnDrpSelectReason;
	
	@FindBy(xpath = "(//span[contains(normalize-space(),'Pause My Membership')])[2]")
	@CacheLookup
	public WebElement btnPauseMyMembership;
	
	@FindBy(xpath = "(//span[normalize-space()='Resume My Membership'])[2]")
	@CacheLookup
	public WebElement btnResumeMyMembership;
	
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[6]")
	@CacheLookup
	public WebElement iconDateNewSubscriptionDate;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[3]")
	@CacheLookup
	public WebElement iconStartDatePauseMembership;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiIconButton-label')])[4]")
	@CacheLookup
	public WebElement iconEndDatePauseMembership;
	
	
	
	//=========END========MEMBERSHIP PAGE OBJECTS=============//
	
	
	//=========START========ACTION METHODS FOR MEMBERSHIP PAGE OBJECTS=============//
	//TO MANAGE MEMBERSHIP BUTTON
	public void clickOnBtnManageMembership() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnManageMembership));
		Thread.sleep(500);
		btnManageMembership.click();
		logger.info("Clicked on the manage membership button");
		Thread.sleep(500);
	}
	
	//TO CLICK THE CATEGORY LIST
	public void clickOnDrpCategory() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnDrpSelctCategory));
		Thread.sleep(300);
		btnDrpSelctCategory.click();
		logger.info("Clicked on the category field to open the list");
		Thread.sleep(500);
	}
	
	//TO SELECT THE CATEGORY THE FROM THE LIST
	public void selectCategory(String categoryName) throws InterruptedException{	
		clickOnDrpCategory();
		Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,categoryName);
		Thread.sleep(1000);
	}
	
	//TO SELECT THE PACKAGE
	public void selectPackage(String packageName) throws InterruptedException{	
		logger.info("SelectPackage methods called");
		Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,listPackageName,packageName);
		Thread.sleep(1000);
	}
	
	//TO CLICK ON THE CHANGE MEMBERSHIP BUTTON
	public boolean clickOnBtnChangeMembership() throws InterruptedException {
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnChangeMembership));
			if(btnChangeMembership.isDisplayed()) {
				btnChangeMembership.click();
				flag = true;
				logger.info("Clicked on the Change membership button");
				Thread.sleep(500);
			}
		}catch(Exception e) {
			softAssert.assertTrue(btnChangeMembership.isDisplayed(),"Is Check resume button is present or not");
			logger.info("Exceptoin from clickOnBtnChangeMembership: "+e.getMessage());
		}
		return flag;
	}
	
	//TO THE RADIO BUTTONS
	public void selectRadioBtn(String radioButtonName) throws InterruptedException {	
	    try {
	    	if((driver.getPageSource().contains("Effective Immediately"))) {
	    		 if (radioButtonName.equals("Effective Immediately")) {
	 	            wait.until(ExpectedConditions.elementToBeClickable(RadioBtn_3));
	 	            RadioBtn_3.click();
	 	            logger.info("Selected radio button: Effective Immediately");
	 	            Thread.sleep(500);
	 	        } else if (radioButtonName.equals("The end of the current period")) {
	 	            wait.until(ExpectedConditions.elementToBeClickable(RadioBtn_4));
	 	            RadioBtn_4.click();
	 	            logger.info("Selected radio button: The end of the current period");
	 	            Thread.sleep(500);
	 	        } else if (radioButtonName.equals("Custom Date")) {
	 	            wait.until(ExpectedConditions.elementToBeClickable(RadioBtn_5));
	 	            RadioBtn_5.click();
	 	            logger.info("Selected radio button: Custom Date");
	 	            Thread.sleep(500);
	 	        } else {
	 	            logger.info("Given radio button name not matched");
	 	        }
	    	}else {
	    		wait.until(ExpectedConditions.elementToBeClickable(RadioBtn_3));
 	            RadioBtn_3.click();
 	            logger.info("Selected radio button: The end of the current period");
 	            Thread.sleep(500);
	    	}
	       
	    } catch (Exception e) {
	        logger.error("Error occurred while selecting radio button: " + e.getMessage());
	    }
	    Thread.sleep(1000);
	}

	
	public void clickOnIconDateNewSubscription() throws InterruptedException {
		iconDateNewSubscriptionDate.click();
		logger.info("Clicked on the custome date selector icon");
		Thread.sleep(500);
	}
	
	//TO SELECT THE CUSTOME DATE
	public void setNewSubsriptionDate(String Customdate) throws Throwable {
		clickOnIconDateNewSubscription();
		DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,Customdate);
		logger.info("Custom date, month and year entered");
	    Thread.sleep(500);
	}
	
	//TO SELECT THE CHECK BOX
	public void clickOnCheckBoxAgreePricingOption() throws InterruptedException {
		try {
			ruae.clickOnCheckBox_1_RU();
		}catch(Exception e) {
			logger.info("Exception from clickOnCheckBoxAgreePricingOption: "+e.getMessage());
		}
	}
	
	//TO CLICK BUTTON AGREED TERMS
	public void clickOnBtnAgreedTerm() throws InterruptedException {
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAgreeTerm));
			if(btnAgreeTerm.isDisplayed()) {
				flag = true;
				Thread.sleep(5000);
				btnAgreeTerm.click();
				logger.info("Clicked on the agreed terms");
				Thread.sleep(2000);
			}
		}catch(Exception e) {
			softAssert.assertEquals(true,flag,"Is clickOnBtnAgreedTerm Displayed");
			logger.info("Exception From clickOnBtnAgreedTerm :"+e.getMessage());
		}
		softAssert.assertAll();
	}
	
	//TO CLICK ON PAUSE MEMBERSHIP BUTTON
	public void clickOnPauseMembership() throws InterruptedException {
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnPauseMembership));
			if(btnPauseMembership.isDisplayed()) {
				Thread.sleep(500);
				flag = true;
				btnPauseMembership.click();
				logger.info("Clicked on the pause member ship button");
				Thread.sleep(1000);
			}
		}catch(Exception e) {
			softAssert.assertEquals(true,flag,"Is btnPauseMembership Displayed");
			logger.info("Exception From clickOnPauseMembership :"+e.getMessage());
		}
		softAssert.assertAll();
	}
	
	//TO CLICK ON RESUME MEMBERSHIP BUTTON
	public void clickOnResumeMembership() throws InterruptedException {
		boolean flag = false;
		try {
			flag = btnResumeMembership.isDisplayed();
			Thread.sleep(1000);
			if(flag) {
				Thread.sleep(500);
				btnResumeMembership.click();
				logger.info("Clicked on the resume member ship button");
				Thread.sleep(1000);
			}
		}catch(Exception e) {
			softAssert.assertEquals(true,flag,"Is clickOnResumeMembership Displayed");
			logger.info("Exception From clickOnResumeMembership :"+e.getMessage());
		}
	}
	
	//TO CLICK ON DROPDWON BUTTON SELECT REASON
	public void clickOnDrpReason() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(btnDrpSelectReason));
		Thread.sleep(300);
		//btnDrpSelectReason.click();
		action.click(btnDrpSelectReason).build().perform();
		logger.info("Clicked on the dropdown reason while puase membership");
		Thread.sleep(500);
	}
	
	public void selectReason(String reason) throws InterruptedException {
		clickOnDrpReason();
		Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,reason);
		Thread.sleep(1000);
		logger.info("Pause membership reason selected");
	}
	

	public void clickOnBtnPauseMyMembership() throws InterruptedException {
		boolean flag = false;
		try {
			flag = btnPauseMyMembership.isDisplayed();
			if(flag) {
				btnPauseMyMembership.click();
				logger.info("Clicked on the pause my membership");
				Thread.sleep(300);
			}
			
		}catch(Exception e) {
			softAssert.assertEquals(true,flag,"Is clickOnBtnPauseMyMembership Displayed");
		}
	}
	
	public void clickOnBtnResumeMyMembership() throws InterruptedException {
		boolean flag = false;
		try {
			Thread.sleep(1000);
			if(btnResumeMyMembership.isDisplayed()) {
				btnResumeMyMembership.click();
				logger.info("Clicked on the resume my membership");
				flag = true;
				Thread.sleep(300);
			}
			
		}catch(Exception e) {
			logger.info("Exception from clickOnBtnResumeMyMembership: "+e.getMessage());
			softAssert.assertEquals(true,flag,"Is clickOnBtnResumeMyMembership button Displayed");
		}
	}
	
	
	//TO SELECT THE PUASE MEMBESHIP START DATE
	public void setPauseMembershipStartDate(String startDate) throws InterruptedException {
		boolean flag = false;
		try {
			clickOnIconStartDatePauseMembership();
			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,startDate);
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
	
	
	//TO SELECT THE PUASE MEMBESHIP END DATE
	public void setPauseMembershipEndDate(String endDate) throws InterruptedException {
		boolean flag = false;
		try {
			clickOnIconEndDatePauseMembership();
			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,endDate);
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
	
	//TO CLICK ON THE PAUSE MEMBERSHIP START DATE
	public void clickOnIconStartDatePauseMembership() throws InterruptedException {
		iconStartDatePauseMembership.click();
		logger.info("Clicked on the pause membership start date icon");
		Thread.sleep(500);
	}
	
	//TO CLICK ON THE PAUSE MEMBERSHIP END DATE
	public void clickOnIconEndDatePauseMembership() throws InterruptedException {
		iconEndDatePauseMembership.click();
		logger.info("Clicked on the pause membership end date icon");
		Thread.sleep(500);
	}

	//=========START========ACTION METHODS FOR MEMBERSHIP PAGE OBJECTS=============//
	
	
	
	
	
	//TO CHANGE THE MEMBERSHIP
	public PO_HomePage changeMembership(String userEmail, String categoryName,String packageName,String radioButtonName,String membershipDate ) throws Throwable {
		try {
			logger.info("Method called: changeMembership");
			clickOnBtnManageMembership();
			selectCategory(categoryName);
			Thread.sleep(500);
			selectRadioBtn(radioButtonName);
			if(radioButtonName.equals("Custom Date")) {
				logger.info("Start filling custom date");
				setNewSubsriptionDate(membershipDate);
				logger.info("Custom date radio button selected and membership date entered");
			}else {
				logger.info("Selected radio button is not Custom Date");
			}
			selectPackage(packageName);
			clickOnCheckBoxAgreePricingOption();
			boolean flag = clickOnBtnChangeMembership();
			if(flag) 
			{
				String alertMsgContent = snakeAlertMessagesDisplayedContent_RU();
				if(alertMsgContent.equals(alertMsgChangeMembership)) {
					logger.info("===>>> Membership Changed Successfully");
					DBT_User_Membership.test_DBT_ChangeMembership(userEmail,packageName);
				} else if(alertMsgContent.equals(alertMsgSelectMemberhsipPackage)) {
					logger.info("===>>> Membership package not selected");
					ruae.clickOnCancelButton_1_RU();
				}else if(alertMsgContent.equals(alertMsgErrorChangeSubscription)){
					ruae.clickOnCancelButton_1_RU();
				}else {
					ruae.clickOnCancelButton_1_RU();
				}
				softAssert.assertEquals(alertMsgContent,alertMsgChangeMembership,"To check the membership package change");
			}
		}catch(Exception e) {
			logger.info("Exception from changeMembership: "+e.getMessage());
		}
		
		logger.info("Method call done: changeMembership ");
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}
	
	//TO CHECK AGREED TERMS
	public PO_HomePage checkAgreedTerm() throws InterruptedException {
		try {
			logger.info("Method called: checkAgreedTerm");
			clickOnBtnAgreedTerm();
			ruae.clickOnCancelButton_1_RU();
		}catch(Exception e) {
			logger.info("Exception from checkAgreedTerm: "+e.getMessage());
		}
		
		logger.info("Method call done: checkAgreedTerm");
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}
	
	//TO PAUSE THE MEMBERSHIP
	public PO_HomePage pasueMembership(String userEmail, String pauseStartDate, String pauseEndDate, String pauseReason) throws Throwable {
		try {
			logger.info("Method called: pasueMembership");
			clickOnPauseMembership();
			
			selectReason(pauseReason);
			setPauseMembershipStartDate(pauseStartDate);
			setPauseMembershipEndDate(pauseEndDate);
			clickOnBtnPauseMyMembership();
			Thread.sleep(500);
			boolean flag = clickOnBtnConfirm_RU();
			if(flag) 
			{	String alertMsgContent = snakeAlertMessagesDisplayedContent_RU();
				if(alertMsgContent.equals(alertMsgPauseMembership)) {
					logger.info("===>>> Membership Paused Successfully");
					//DATABASE TESTING
					DBT_User_Membership.test_DBT_PauseMembership(userEmail,pauseStartDate,pauseEndDate);
				} else if(alertMsgContent.equals(alertMsgPauseMembershipMoreThenOneTimeInAQuarter)) {
					logger.info("===>>> Membership not paused");
				}else if(alertMsgContent.equals(alertMsgNoActiveSubscription)) {
					logger.info("===>>> Membership not paused");
				}else {
					ruae.clickOnCancelButton_1_RU();
				}
				softAssert.assertEquals(alertMsgContent,alertMsgPauseMembership,"To check the pause membership");
			}else {
				softAssert.assertTrue(flag,"Pause membership confirm button");
			}
		}catch(Exception e) {
			logger.info("Exception from pasueMembership: "+e.getMessage());
		}
		
		logger.info("Method call done: pasueMembership");
		softAssert.assertAll();
		return new PO_HomePage(driver);	
	}
	
	//TO RERSUME THE MEMBERSHIP
	public PO_HomePage resumeMembership(String userEmail) throws InterruptedException, SQLException {
		try {
			logger.info("Method called: resumeMembership");
			clickOnResumeMembership();
			clickOnBtnResumeMyMembership();
			Thread.sleep(500);
			String alertMsgContent=null;
			boolean flag = clickOnBtnConfirm_RU();
			if(flag)
			{
				alertMsgContent = snakeAlertMessagesDisplayedContent_RU();
				if(alertMsgContent.equals(alertMsgResumeMembership)) {
					logger.info("===>>> Membership Resumed Successfully");
					DBT_User_Membership.test_DBT_ResumeMembership(userEmail);
				}else {
					ruae.clickOnCancelButton_1_RU();
				}
				softAssert.assertEquals(alertMsgContent,alertMsgResumeMembership,"To check the resume membership");
			}
			softAssert.assertEquals(true, flag,"To check is click on the confirm button or not");
		}catch(Exception e) {
			logger.info("Exception from resumeMembership: "+e.getMessage());
		}
		
		logger.info("Method call done: pasueMembership");
		softAssert.assertAll();
		return new PO_HomePage(driver);	
	}
	
}
