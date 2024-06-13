package com.leonardoAI.Main.pageObject;

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
import org.testng.asserts.SoftAssert;

import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.projectUtility.DatePicker;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_PaymentsPage extends ReUseAbleElement {
		
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
		public PO_Main_PaymentsPage(WebDriver driver) {	
			super(driver);
		    this.driver = driver;
		    jsExecutor  = (JavascriptExecutor)driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait (driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);
		}

		
		//======START======PAGE OBJECT FOR PAYMENTS AND ACTOIN METHODS==========//
		
		//TO SELECT THE LOCATIONS
  		public void selectLocations(String locationName) throws InterruptedException {
  			ruae.clickOnDropdown_1_RU(driver);
  			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver,ruae.listOptionAddress_RU,locationName);
  			logger.info("Selected Locations from the list: "+locationName);
  			Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE PAYMETNS START DATE
  		public void setPaymentStartDate(String paymentStartDate) throws Throwable {
  			clickOnChangeDateIcon_1_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,paymentStartDate);
  		    Thread.sleep(1000);
  		}
  		
  		//TO SELECT THE PAYMETNS END DATE
  		public void setPaymentEndDate(String paymentEndDate) throws Throwable {
  			clickOnChangeDateIcon_2_RU();
  			DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver,paymentEndDate);
  		    Thread.sleep(1000);
  		}
  		
  		
  		//TEXT NO PAYMENTS MATCHED TO CURRENT APPLIED FILTER
  		@FindBy(xpath = "//*[.='No payment matches Current Filter")
  		@CacheLookup
  		public WebElement noPaymentMatchedWithApplieddFilter;
  		public boolean  isNoPaymentMatchedDisplayed() throws InterruptedException {
  			boolean flag = false;
  			try {
  				Thread.sleep(5000);
  				flag = noPaymentMatchedWithApplieddFilter.isDisplayed();
  				if(flag) {
  					logger.info("Searched key not present");
  					softAssert.assertTrue(flag,"Payment you are searching is not found");
  					clickOnP360Logo_RU();
  				}
  			}catch(Exception e) {
  				logger.info("Searched Payment list is present, after applied filter");
  				logger.info("Exception from : "+e.getMessage());
  			}
  			logger.info("noPaymentMatchedWithApplieddFilter: "+flag);
  			softAssert.assertAll();
  			return flag;
  		}
  		
  		
  		//PAYMENTS LIST 
  		@FindBy(xpath = "//div[contains(@class,'p-4 flex gap-2 flex-row')]")
  		@CacheLookup
  		List<WebElement> paymentList;
  		//PAYMETNS ROW LIST ADDRESS AND ACTION METHODS
  		public String paymentList_address = "//div[contains(@class,'p-4 flex gap-2 flex-row')]";
  		public int findPaymentFromRowListAndClickOnThreeDot(String paymentName, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
  			int listRowCount = 0; 
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(paymentList_address,paymentList,driver, paymentName, searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
				
			}catch(Exception e) {
				logger.info("Exception from findPaymentFromRowListAndClickOnThreeDot: "+e.getMessage());
			}
			return listRowCount;
  		}
  		
  		//PAYMENT HISTORY CONFIRMATION
  		String  paymentHistory =  "//span[contains(text(),'Payment History')]";
  		public boolean isPaymentHistoryPresent() {
  			boolean flag = false;
  			try {
  				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(paymentHistory)));
  				Thread.sleep(1000);
  				flag = true;
  			}catch(Exception e) {
  				logger.info("Exception from : "+e.getMessage());
  			}
  			
  			return flag;
  		}
  		
  		//======END======PAGE OBJECT FOR ADD PAYMENTS ACTOIN METHODS==========//
  			
  		//FIND PAYMENTS FROM THE LIST AND CLICK ON SEARCH KEY
  		public void findPaymentFromListAndClickOnSearchKey(String searchKey,String paymentName,boolean wantToClickOnThreeDot,int searchKeyColumnIndex, boolean wantToClickOnSearchKey) throws InterruptedException
  		{
  	  		findPaymentFromRowListAndClickOnThreeDot(paymentName, searchKeyColumnIndex, wantToClickOnThreeDot, wantToClickOnSearchKey);

  		}
  		
  		
  		
  		//TO CHECK THE PAYMENT USERS DETAILS FROM THE PAYMENT LIST
  		public PO_Main_HomePage  checkPaymentUserDetails(String locationName,String paymentStartDate, String paymentEndDate, String searchKey,String paymentName,boolean wantToClickOnThreeDot,int searchKeyColumnIndex, boolean wantToClickOnSearchKey) throws Throwable 
  		{
  			selectLocations(locationName);
  			setPaymentStartDate(paymentStartDate);
  			setPaymentEndDate(paymentEndDate);
  			searchBox_1_RU(driver, searchKey);
  			
  			boolean isPaymentListPresent = isNoPaymentMatchedDisplayed();
   			if(isPaymentListPresent) {
   				softAssert.assertTrue(false,"Payment users details not checked");
   				
   			}else {
   				findPaymentFromListAndClickOnSearchKey(searchKey, paymentName, wantToClickOnThreeDot, searchKeyColumnIndex, wantToClickOnSearchKey);
  				
  				boolean flag = isPaymentHistoryPresent();
  	  			if(flag) {
  	  				logger.info("Payment user details checked successfully");
  	  			}else {
  	  				logger.info("Payment users details not checked");
  	  				softAssert.assertTrue(false,"Payment users details not checked");
  	  			}
  			}
   			
  			softAssert.assertAll();
  			return new PO_Main_HomePage(driver);
  		}
  		 		
}
