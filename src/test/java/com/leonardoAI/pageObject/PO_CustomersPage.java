package com.leonardoAI.pageObject;

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
import com.leonardoAI.actions.Action_View;
import com.leonardoAI.pageObject.pageLocators.PL_CustomersPage;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;

public class PO_CustomersPage extends ReUseAbleElement {

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
	public PO_CustomersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// ALERT MESSAGES
	public String pleaseEnterLabelName = "Please enter label.";
	public String customersAdded = "Customer created successfully.";
	public String customersUpdated = "Customer updated successfully.";
	public String customerDeactivate = "Customer deactivated successfully.";
	public String customerArchived = "Customer archived successfully.";
	public String customerRestored = "Customer restored successfully.";
	public String customerActivated = "Customer activated successfully.";

	// USER | SUGGEGETIONS MESSAGES
	public String customeNotFound = "No customers found";

	// ======START======PAGE OBJECT FOR USER LEBELS AND ACTOIN METHODS==========//

	@FindBy(xpath = PL_CustomersPage.ADD_CUSTOMER_NAME)
	@CacheLookup
	public WebElement field_customerName;

	public void setLablesName(String customerName) throws InterruptedException {
		field_customerName.sendKeys(Keys.CONTROL, "a");
		field_customerName.sendKeys(Keys.DELETE);
		field_customerName.sendKeys(customerName);
		Thread.sleep(3000);
		logger.info("Entered customerName");

	}

	// CUSTOMERS LIST
	@FindBy(xpath = PL_CustomersPage.ADD_CUSTOMERS_LIST)
	@CacheLookup
	List<WebElement> listCustomers;

	// CUSTOMERS ROW LIST ADDRESS AND ACTION METHODS
	// List_address: //div[contains(@class,'flex flex-col gap-2 items-center')]
	// Pointer_address: //div[contains(@class, 'cursor-pointer')])[2]
	// public String listUsreLabels_address = "//div[contains(@class,'p-4 flex gap-2
	// flex-row')]";

	public int findCustomerFromRowListAndClickOnThreeDot(String customersName, String searchKey,
			int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey)
			throws InterruptedException {
		searchBox_1_RU(driver, searchKey);
		if (!driver.getPageSource().contains("customeNotFound")) {
			int listRowCount = 0;
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(PL_CustomersPage.ADD_CUSTOMERS_LIST,
						listCustomers, driver, searchKey, searchKeyColumnIndex, wantToClickOnThreeDot,
						wantToclickOnFindSearckKey);

			} catch (Exception e) {
				logger.info("Exception from findCustomersFromRowListAndClickOnThreeDot: " + e.getMessage());
			}
			logger.info("listRowCount: " + listRowCount);
			return listRowCount;
		} else {
			logger.info(customeNotFound);
			return -1;
		}

	}
	// ======END======PAGE OBJECT FOR ADD USERS LEBELS ACTOIN METHODS==========//

	// TO ADD AND UPDATE THE CUSTOMERS
	public PO_HomePage addOrEditCustomer(String customersName, String searchKey, int searchKeyColumnIndex,
			boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws Throwable {
		StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTrace[2].getMethodName();
		logger.info("Caller methods name: " + callerMethodName);
		boolean flag = false;
		if (callerMethodName.equals("test_AddCustomer")) {
			ruae.clickOnAdd_RU();
		} else if (callerMethodName.equals("test_EditCustomer")) {

			int isItemfindInList = findCustomerFromRowListAndClickOnThreeDot(customersName, searchKey,
					searchKeyColumnIndex, wantToClickOnThreeDot, wantToclickOnFindSearckKey);
			logger.info("Item found in row number: " + isItemfindInList);
			if (isItemfindInList != -1) {
				Action_Edit.edit(driver);
			}
		}

		setLablesName(customersName);

		flag = clickOnBtnSave_1_RU();

		if (flag) {
			if (driver.getPageSource().contains("Please add customer name.") || driver.getPageSource()
					.contains("Customer names should allow only alphabets, with spaces and numbers optional.")) {
				clickOnCancelButton_1_RU();
				logger.info("Customer not added");
				softAssert.assertTrue(false, "Customer is emplty");
				return new PO_HomePage(driver);
			} else {

				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
				logger.info("Alert Message: " + alertMsg);

				if (callerMethodName.equals("test_AddCustomer")) {
					softAssert.assertEquals(alertMsg, customersAdded, "Check user customers added or not");
				} else if (callerMethodName.equals("test_EditCustomer")) {
					softAssert.assertEquals(alertMsg, customersUpdated, "Check user customers updated or not");
				}

			}
		}

		softAssert.assertAll();
		return new PO_HomePage(driver);
	}

	// TO VIEW/VISIT COSTOMER
	public PO_HomePage viewCustomer() throws InterruptedException {
		Action_View.view(driver);
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}

	// TO VIEW/VISIT COSTOMER[TO RETURN ON TENANT PAGE OBJECT]
	public PO_TenantsPage viewCustomerAndTenantPageOjbect() throws InterruptedException {
		Action_View.view(driver);
		softAssert.assertAll();
		return new PO_TenantsPage(driver);
	}

	// TO DEACTIVATE THE CUSTOMERS
	public PO_HomePage deactivateCustomer() throws InterruptedException {
		Action_Deactivate.deactivate(driver, customerDeactivate);
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}

	// TO ACTIVATE THE CUSTOMERS
	public PO_HomePage activateCustomer() throws InterruptedException {
		Action_Activate.activate(driver, customerActivated);
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}

	// TO ARCHIVE THE CUSTOMERS
	public PO_HomePage archiveCustomer() throws InterruptedException {
		Action_Archive.archive(driver, customerArchived);
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}

	// TO RESTORE THE CUSTOMERS
	public PO_HomePage restoreCustomer() throws InterruptedException {
		Action_Restore.restore(driver, customerRestored);
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}

}
