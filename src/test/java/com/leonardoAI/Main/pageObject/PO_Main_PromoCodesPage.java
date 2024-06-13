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
import com.leonardoAI.actions.Action_Deactivate;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.projectUtility.DatePicker;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;

public class PO_Main_PromoCodesPage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	// CONSTRUCTOR CREATION
	public PO_Main_PromoCodesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);
	}

	// ALERT MESSAGES
	public String alertMsgPromoCodeAdded = "Promocode Added Successfully";
	public String alertMsgPromoCodeAlreadyExist = "Promo Code is already exists. Please use another Code";

	public String alertMsgPromoCodeDeActivated = "Promo Code Deactivated Successfully.";
	public String alertMsgPromoCodeActivated = "Promo Code Activated Successfully.";

	// ======START======PAGE OBJECT FOR PROMO CODES AND ACTOIN METHODS==========//
	// BUTTON MOVEMENT LISTING
	@FindBy(xpath = "//span[contains(normalize-space(),'Add Promo code')]")
	@CacheLookup
	public WebElement btnAddPromoCode;

	public void clickOnBtnAddPromoCodeListing() throws InterruptedException {
		btnAddPromoCode.click();
		logger.info("Clicked on the btnAddPromoCode");
		Thread.sleep(1000);
	}

	// TEXT FIELD CODES NAME
	@FindBy(xpath = "//input[@placeholder='Enter Code']")
	@CacheLookup
	public WebElement fieldCodeName;

	public void setPromoCodName(String codeName) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(fieldCodeName));
		fieldCodeName.sendKeys(Keys.CONTROL, "a");
		fieldCodeName.sendKeys(Keys.DELETE);
		fieldCodeName.sendKeys(codeName);
		logger.info("Entered the fieldCodeName: " + codeName);
		Thread.sleep(300);
	}

	// BUTTON DISCOUNT TYPE PERCENT
	@FindBy(xpath = "(//div[@class='w-full text-center font-bold text-xl'])[1]")
	@CacheLookup
	public WebElement btnDiscountInPercent;

	public void clickOnBtnDiscountInPercent() throws InterruptedException {
		btnDiscountInPercent.click();
		logger.info("Clicked on the btnDiscountInPercent");
		Thread.sleep(1000);
	}

	// BUTTON DISCOUNT TYPE DOLLER
	@FindBy(xpath = "(//div[contains(@class,'font-bold text-xl')][normalize-space()='$'])[1]")
	@CacheLookup
	public WebElement btnDiscountInDollar;

	public void clickOnBtnDiscountInDollar() throws InterruptedException {
		btnDiscountInDollar.click();
		logger.info("Clicked on the btnDiscountInDollar");
		Thread.sleep(1000);
	}

	// TEXT FIELD DISCOUNT VALUE
	@FindBy(xpath = "//input[contains(@placeholder,'Enter Discount Value')]")
	@CacheLookup
	public WebElement fielDiscountValue;

	public void setDiscountValue(String discountValue) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(fielDiscountValue));
		fielDiscountValue.sendKeys(Keys.CONTROL, "a");
		fielDiscountValue.sendKeys(Keys.DELETE);
		fielDiscountValue.sendKeys(discountValue);
		logger.info("Entered the fieldFirstName: " + discountValue);
		Thread.sleep(300);
	}

	// TO SELECT THE PROMO CODE START DATE
	public void setPromoCodeStartDate(String promoCodeStartDate) throws Throwable {
		clickOnChangeDateIcon_1_RU();
		DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver, promoCodeStartDate);
		Thread.sleep(500);
	}

	// TO SELECT THE PROMO CODE END DATE
	public void setPromoCodeEndDate(String promoCodeEndDate) throws Throwable {
		clickOnChangeDateIcon_2_RU();
		DatePicker.DatePicker_GenericMethod_WhenDateGridOnlyPresent(driver, promoCodeEndDate);
		Thread.sleep(500);
	}

	// CHECKBOX ALLOW FOR ALL LOCATIONS
	public void checkboxAllowForAllLocations() throws InterruptedException {
		ruae.clickOnCheckBox_1_RU();
	}

	// CHECKBOX ALLOW FOR ALL LOCATIONS
	public void unCheckboxAllowForAllLocations() throws InterruptedException {
		WebElement checkboxAllLocations = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		if (checkboxAllLocations.isSelected()) {
			checkboxAllLocations.click();
			logger.info("Unchecked all locations check box");
		} else {
			logger.info("Alrady unchecked all locations check box");
		}
		ruae.clickOnCheckBox_1_RU();
	}

	// TO SELECT THE LOCATIONS
	public void selectLocations(String locationName) throws InterruptedException {
		ruae.clickOnDropdown_1_RU(driver);
		Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver, ruae.listOptionAddress_RU,
				locationName);
		logger.info("Selected Locations from the list: " + locationName);
		Thread.sleep(500);
	}

	// CHECKBOX ALLOW FOR ALL USERS
	public void checkboxAllowForAllUsers() throws InterruptedException {
		ruae.clickOnCheckBox_2_RU();
	}

	// CHECKBOX ALLOW FOR ALL USERS
	public void unCheckboxAllowForAllUsers() throws InterruptedException {
		WebElement checkboxAllLocations = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		if (checkboxAllLocations.isSelected()) {
			checkboxAllLocations.click();
			logger.info("Unchecked all users check box");
		} else {
			logger.info("Alrady Unchecked all users check box");
		}
		ruae.clickOnCheckBox_1_RU();
	}

	// TEXT FIELD MAX NUMBER OF USERS
	@FindBy(xpath = "//input[@placeholder='Enter Max Number Of Users']")
	@CacheLookup
	public WebElement fielMaxNumberOfUsers;

	public void setMaxNumberOfUsers(String maxNumberOfUsers) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(fielMaxNumberOfUsers));
		fielMaxNumberOfUsers.sendKeys(Keys.CONTROL, "a");
		fielMaxNumberOfUsers.sendKeys(Keys.DELETE);
		fielMaxNumberOfUsers.sendKeys(maxNumberOfUsers);
		logger.info("Entered the fielMaxNumberOfUsers: " + maxNumberOfUsers);
		Thread.sleep(300);
	}

	// TEXT NO PROMO CODES MATCHED TO CURRENT APPLIED FILTER
	@FindBy(xpath = "//*[.='No Promo Code Matches Current Filter")
	@CacheLookup
	public WebElement noPromoCodeMatchedWithApplieddFilter;

	public boolean isNoPromoCodeMatchedDisplayed() throws InterruptedException {
		boolean flag = false;
		try {
			if (noPromoCodeMatchedWithApplieddFilter.isDisplayed()) {
				flag = true;
				logger.info("Searched key not present");
				softAssert.assertTrue(flag, "PromoCode you are searching is not found");
				clickOnP360Logo_RU();
			}
		} catch (Exception e) {
			flag = false;
			logger.info("Searched PromoCode is matched with the applied fileter");
			logger.info("Exception from : " + e.getMessage());
		}
		softAssert.assertAll();
		return flag;
	}

	// PROMO CODES LIST
	@FindBy(xpath = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]")
	@CacheLookup
	List<WebElement> promoCodeList;
	// PROMO CODE ROW LIST ADDRESS AND ACTION METHODS
	public String promoCodeList_address = "(//div[contains(@class,'w-full flex')])[4]//div[contains(@class,'p-4 flex gap-2 flex-row')]";

	public int findPromoCodeFromRowListAndClickOnThreeDot(String promoCodeName, int searchKeyColumnIndex,
			boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
		int listRowCount = 0;
		try {
			Thread.sleep(2000);
			listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(promoCodeList_address, promoCodeList,
					driver, promoCodeName, searchKeyColumnIndex, wantToClickOnThreeDot, wantToclickOnFindSearckKey);

		} catch (Exception e) {
			logger.info("Exception from findPromoCodeFromRowListAndClickOnThreeDot: " + e.getMessage());
			softAssert.assertTrue(false, "not click on the three dot action button");
		}
		return listRowCount;
	}
	// ======END======PAGE OBJECT FOR ADD PROMO CODES ACTOIN METHODS==========//

	// TO ADD OR CHANGE PROMOCODES
	public PO_Main_HomePage addOrChangePromoCodes(String promoCodeName, String discountTypes, String discountValue,
			String promoCodeStartDate, String promoCodeEndDate, boolean wantToAllowForAllLocations,
			boolean wantToAllowForAllUsers, String locationName, String maxNumberOfUsers) throws Throwable {
		StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTraceElement[2].getMethodName();
		logger.info("addOrChangeWorkout caller method name: " + callerMethodName);
		try {
			clickOnBtnAddPromoCodeListing();
			setPromoCodName(promoCodeName);

			if (discountTypes.equals("percent")) {
				clickOnBtnDiscountInPercent();
			} else if (discountTypes.equals("dollar")) {
				clickOnBtnDiscountInDollar();
			} else {
				logger.info("Wrong discount types");
				softAssert.assertTrue(false, "You are selecting wrong discount types");
			}

			setDiscountValue(discountValue);
			setPromoCodeStartDate(promoCodeStartDate);
			setPromoCodeEndDate(promoCodeEndDate);

			if (wantToAllowForAllLocations) {
				checkboxAllowForAllLocations();
			} else {
				unCheckboxAllowForAllLocations();
				selectLocations(locationName);
			}

			if (wantToAllowForAllUsers) {
				checkboxAllowForAllUsers();
			} else {
				unCheckboxAllowForAllUsers();
				setMaxNumberOfUsers(maxNumberOfUsers);
			}

			boolean flag = clickOnBtnSave_1_RU();

			if (flag) {
				if (isRequiredOrInvalidMessageDisplayed_RU()) {
					clickOnCancelButton_1_RU();
				} else {
					Thread.sleep(100);
					String alertMsg = snakeAlertMessagesDisplayedContent_RU();
					if (alertMsg.equals(alertMsgPromoCodeAdded)) {
						logger.info("Promo Code Added");
						softAssert.assertEquals(alertMsg, alertMsgPromoCodeAdded, "Promo Code Added Successfully");
					} else if (alertMsg.equals(alertMsgPromoCodeAlreadyExist)) {
						logger.info("Promo Code Already Exist");
						softAssert.assertEquals(alertMsg, alertMsgPromoCodeAlreadyExist,
								"Promo Code Added Successfully");
						clickOnCancelButton_1_RU();
					} else {
						softAssert.assertTrue(false, "Promocode not added");
						clickOnCancelButton_1_RU();
					}
				}
			} else {
				logger.info("Not clicked on the save button");
				softAssert.assertTrue(false, "You want to add Promo Code, but not clicked on the save button");
			}

		} catch (Exception e) {
			logger.info("Exception from addOrChangePromoCodes: " + e.getMessage());
		}
		softAssert.assertAll();
		return new PO_Main_HomePage(driver);
	}

	// FIND PROMO CODES FROM THE LIST AND CLICK ON THE THREE DOT BUTTON
	public void findPromoCodesFromListAndClickOnThreeDotButton(String searchKey, String promoCodeName,
			boolean wantToClickOnThreeDot, int searchKeyColumnIndex, boolean wantToClickOnSearchKey)
			throws InterruptedException {
		Thread.sleep(1000);
		searchBox_1_RU(driver, searchKey);
		Thread.sleep(5000);
		boolean flag = isNoPromoCodeMatchedDisplayed();
		if (!flag) {
			findPromoCodeFromRowListAndClickOnThreeDot(promoCodeName, searchKeyColumnIndex, wantToClickOnThreeDot,
					wantToClickOnSearchKey);

		} else {
			softAssert.assertTrue(false, "Promo Codes you are searching is not present");
		}
		softAssert.assertAll();
	}

	// TO ACTIVATE THE PROMO CODES
	public PO_Main_HomePage activatePromoCode() throws InterruptedException {
		
		Action_Activate.activate(driver, alertMsgPromoCodeActivated);
		softAssert.assertAll();
		return new PO_Main_HomePage(driver);
	}

	// TO DEACTIVATE THE PROMO CODES
	public PO_Main_HomePage deactivatePromoCode() throws InterruptedException {
		
		Action_Deactivate.deactivate(driver, alertMsgPromoCodeDeActivated);
		softAssert.assertAll();
		return new PO_Main_HomePage(driver);
	}

}
