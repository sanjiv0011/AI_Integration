package com.leonardoAI.pageObject;

import java.io.IOException;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;
import com.leonardoAI.actions.Action_Activate;
import com.leonardoAI.actions.Action_Archive;
import com.leonardoAI.actions.Action_ClickOnAnyColumnElementBasedOnSelectedRowItem;
import com.leonardoAI.actions.Action_Deactivate;
import com.leonardoAI.actions.Action_Edit;
import com.leonardoAI.actions.Action_Restore;
import com.leonardoAI.actions.Action_View;
import com.leonardoAI.pageObject.pageLocators.PL_AssetCategoriesPage;
import com.leonardoAI.pageObject.pageLocators.PL_TenantsPage;
import com.leonardoAI.projectUtility.FindThreeDotAndClick;

public class PO_AssetCategoriesPage extends ReUseAbleElement {

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
	public PO_AssetCategoriesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// ======START======PAGE OBJECT AND ACTOIN METHODS==========//

	@FindBy(xpath = PL_AssetCategoriesPage.ADDRESS_ASSET_CATEGORY_NAME)
	@CacheLookup
	public WebElement field_assetCategoryName;

	public void setAssetCategoryName(String assetCategoryName) throws InterruptedException {
		field_assetCategoryName.sendKeys(Keys.CONTROL, "a");
		field_assetCategoryName.sendKeys(Keys.DELETE);
		field_assetCategoryName.sendKeys(assetCategoryName);
		Thread.sleep(500);
		logger.info("Entered assetCategoryName");

	}

	@FindBy(xpath = PL_AssetCategoriesPage.ADDRESS_ASSET_CATEGORY_CODE)
	@CacheLookup
	public WebElement field_assetCategoryCode;

	public void setAssetCategoryCode(String assetCategoryCode) throws InterruptedException {
		field_assetCategoryCode.sendKeys(Keys.CONTROL, "a");
		field_assetCategoryCode.sendKeys(Keys.DELETE);
		field_assetCategoryCode.sendKeys(assetCategoryCode);
		Thread.sleep(500);
		logger.info("Entered assetCategoryCode");

	}

	@FindBy(xpath = PL_AssetCategoriesPage.ADDRESS_ASSET_CATEGORY_DESCRIPTION)
	@CacheLookup
	public WebElement field_assetCategoryDescription;

	public void setAssetCategoryDescription(String assetCategoryDescription) throws InterruptedException {
		field_assetCategoryDescription.sendKeys(Keys.CONTROL, "a");
		field_assetCategoryDescription.sendKeys(Keys.DELETE);
		field_assetCategoryDescription.sendKeys(assetCategoryDescription);
		Thread.sleep(500);
		logger.info("Entered assetCategoryDescription");

	}

	public void selectAssignmentTypes(int[] assingmentTypesNumber) throws InterruptedException {
		int checkboxNumber = 0;
		logger.info("assingmentTypesNumber: " + assingmentTypesNumber);
		if (assingmentTypesNumber.length <= 4) {
			for (int assingmentType : assingmentTypesNumber) {
				logger.info("assingmentType: " + assingmentType);
				checkboxNumber = assingmentType;
				ruae.selectCheckbox_RU(driver, checkboxNumber);
			}
		} else {
			logger.warn("Assignment Type array length should not be greather then 4");
		}
	}

	@FindBy(xpath = PL_AssetCategoriesPage.ADDRESS_ASSET_CATEGORY_IMAGE)
	@CacheLookup
	public WebElement field_assetCategoryImage;

	public void setAssetCategoryImage(String assetCategoryImage) throws InterruptedException {
		// Click on the tenant image upload button
		// driver.findElement(By.xpath(PL_TenantsPage.ADD_TENANT_IMAGE));
		logger.info("Waiting for the 15 seconds pls check add the image");
		Thread.sleep(8000);

		// jsExecutor.executeScript("arguments[0].click();", field_tenantImage);

//	    // Run the AutoIt script
//	    try {
//	        //String[] command = {"."+"//autoIt.exe", "C:\\Users\\User\\Downloads\\logo.png"};
//	        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt.exe");
//	        Thread.sleep(2000);
//	        logger.info("Entered field_tenantImage");
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        logger.error("Failed to execute AutoIt script", e);
//	    }
	}

	// ASSET CATEGORY LIST
	@FindBy(xpath = PL_AssetCategoriesPage.ADDRESS_ASSET_CATEGORY_LIST)
	@CacheLookup
	List<WebElement> listAssetCategory;

	public int findAssetCategoryFromRowListAndClickOnThreeDot(String assetCategoryName, String searchKey,
			int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey)
			throws InterruptedException {
		searchBox_1_RU(driver, searchKey);
		if (!driver.getPageSource().contains("assetCategoryNotFound")) {
			int listRowCount = 0;
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(
						PL_AssetCategoriesPage.ADDRESS_ASSET_CATEGORY_LIST, listAssetCategory, driver, searchKey,
						searchKeyColumnIndex, wantToClickOnThreeDot, wantToclickOnFindSearckKey);

			} catch (Exception e) {
				logger.info("Exception from findAssetCategoryFromRowListAndClickOnThreeDot: " + e.getMessage());
			}
			logger.info("listRowCount: " + listRowCount);
			return listRowCount;
		} else {
			logger.info("AssetCategoryNotFound");
			return -1;
		}

	}
	// ======END======PAGE OBJECT AND ACTOIN METHODS==========//

	// TO ASSUME A ROLE AS TENANTS
	public PO_AssetCategoriesPage assumeRoleAsTenant(String tenantName, int rowListCount, int columnCount,
			boolean wantToclickColumnELement, WebDriver driver) throws InterruptedException {
		Action_ClickOnAnyColumnElementBasedOnSelectedRowItem.clickOnSelectedColumnElementBasedOnGivenRowCount(
				PL_TenantsPage.ADD_TENANT_LIST, rowListCount, columnCount, true, driver);
		String address_selectedTenant = "//*[text()='" + tenantName + "']";

		String selectedTenant = driver.findElement(By.xpath(address_selectedTenant)).getText();
		logger.info("Role Assumed for: " + selectedTenant);
		softAssert.assertEquals(tenantName, selectedTenant);
		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

	// TO ADD AND UPDATE
	public PO_AssetCategoriesPage addOrEditAssetCategory(String assetCategoryName, String assetCategoryCode,
			String assetCategoryDescription, int[] assingmentTypesNumber, String assetCategoryImage, String searchKey,
			int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey)
			throws Throwable {

		StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTrace[2].getMethodName();
		logger.info("Caller methods name: " + callerMethodName);

		boolean flag = false;
		boolean isClickedOnAddOrEditButton = false;
		if (callerMethodName.contains("test_Add")) {
			isClickedOnAddOrEditButton = ruae.clickOnAdd_RU();

			Thread.sleep(1000);
		} else if (callerMethodName.contains("test_Edit")) {

			int isItemfindInList = findAssetCategoryFromRowListAndClickOnThreeDot(assetCategoryName, searchKey,
					searchKeyColumnIndex, wantToClickOnThreeDot, wantToclickOnFindSearckKey);
			logger.info("Item found in row number: " + isItemfindInList);
			if (isItemfindInList != -1) {
				isClickedOnAddOrEditButton = Action_Edit.edit(driver);
			}
		}

		logger.info("isClickedOnAddOrEditButton: " + isClickedOnAddOrEditButton);
		if (isClickedOnAddOrEditButton) {
			setAssetCategoryName(assetCategoryName);
			setAssetCategoryCode(assetCategoryCode);
			setAssetCategoryDescription(assetCategoryDescription);
			selectAssignmentTypes(assingmentTypesNumber);
			setAssetCategoryImage(assetCategoryImage);

			if (callerMethodName.contains("test_Edit")) {
				flag = clickOnBtnUpdate_1_RU();
			} else {
				flag = clickOnBtnSave_1_RU();
			}

			if (flag) {
				if (driver.getPageSource().contains("Please")
						|| driver.getPageSource().contains("allow only alphabets")) {
					clickOnCancelButton_1_RU();
					logger.info("Asset Category not added");
					softAssert.assertTrue(false, "Asset Category is emplty");
					return new PO_AssetCategoriesPage(driver);
				} else {

					String alertMsg = snakeAlertMessagesDisplayedContent_RU();
					logger.info("Alert Message: " + alertMsg);
					if (alertMsg.contains("already exists") || alertMsg.contains("error")) {
						clickOnCancelButton_1_RU();
					} else {
						if (callerMethodName.contains("test_Add")) {
							softAssert.assertEquals(alertMsg, PL_AssetCategoriesPage.MESSAGE_ASSET_CATEGORY_CREATEDED,
									"Check user Asset Category added or not");
						} else if (callerMethodName.contains("test_Edit")) {
							softAssert.assertEquals(alertMsg, PL_AssetCategoriesPage.MESSAGE_ASSET_CATEGORY_UPDATED,
									"Check user Asset Category updated or not");
						}
					}

				}
			}
		}

		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

	// TO VIEW/VISIT
	public PO_HomePage viewAssetCategory() throws InterruptedException {
		Action_View.view(driver);
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}

	// TO DEACTIVATE
	public PO_AssetCategoriesPage deactivateAssetCategroy() throws InterruptedException {
		Action_Deactivate.deactivate(driver, PL_AssetCategoriesPage.MESSAGE_ASSET_CATEGORY_DEACTIVATED);
		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

	// TO ACTIVATE
	public PO_AssetCategoriesPage activateAssetCategroy() throws InterruptedException {
		Action_Activate.activate(driver, PL_AssetCategoriesPage.MESSAGE_ASSET_CATEGORY_ACTIVATED);
		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

	// TO ARCHIVE
	public PO_AssetCategoriesPage archiveAssetCategroy() throws InterruptedException {
		Action_Archive.archive(driver, PL_AssetCategoriesPage.MESSAGE_ASSET_CATEGORY_ARCHIVED);
		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

	// TO RESTORE
	public PO_AssetCategoriesPage restoreAssetCategroy() throws InterruptedException {
		Action_Restore.restore(driver, PL_AssetCategoriesPage.MESSAGE_ASSET_CATEGORY_RESTORED);
		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

}
