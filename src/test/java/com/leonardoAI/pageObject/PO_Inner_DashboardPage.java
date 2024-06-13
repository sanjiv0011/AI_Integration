package com.leonardoAI.pageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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
import com.leonardoAI.pageObject.pageLocators.PL_Inner_DashboardPage;

public class PO_Inner_DashboardPage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	// HOMEPAGE CONSTRUCTOR CREATION
	public PO_Inner_DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// =========START========HOME PAGE OBJECTS=============//

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_LOGGED_USED_NAME)
	@CacheLookup
	WebElement loggedUserName;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_TOTAL_ASSET_COUNT)
	@CacheLookup
	WebElement totalAssetCount;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_TOTAL_AVAILABLE_ASSET_COUNT)
	@CacheLookup
	WebElement totalAvailableAssetCount;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_TOTAL_CATEGORY_COUNT)
	@CacheLookup
	WebElement totalCategoryCount;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_TOTAL_USED_ASSET_COUNT)
	@CacheLookup
	WebElement totalUsedAssetCount;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_DASHBOARD)
	@CacheLookup
	WebElement menuDashboard;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_ASSETS)
	@CacheLookup
	WebElement menuAssets;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_ASSET_CATEGORIES)
	@CacheLookup
	WebElement menuAssetCategories;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_REPORTS)
	@CacheLookup
	WebElement menuReports;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_ASSET_CONFIGURATIONS)
	@CacheLookup
	WebElement menuAssetConfigurations;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_VENDORS)
	@CacheLookup
	WebElement menuVendors;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_USERS)
	@CacheLookup
	WebElement menuUsers;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_INVOICES)
	@CacheLookup
	WebElement menuInvoices;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_SERVICES)
	@CacheLookup
	WebElement menuServices;

	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_SETTINGS)
	@CacheLookup
	WebElement menuSettings;
	
	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_DEPARTMENTS)
	@CacheLookup
	WebElement menuDepartments;
	
	@FindBy(xpath = PL_Inner_DashboardPage.ADDRESS_LOCATIONS)
	@CacheLookup
	WebElement menuLocations;

	// =========END========HOME PAGE OBJECTS=============//

	// =========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	public void getLoggedUserName() throws InterruptedException {
		String loggedUser = loggedUserName.getText().toString();
		logger.info("loggedUser: " + loggedUser);
	}

	public void getTotolCategoryCount() throws InterruptedException {
		String totalCategroy = totalCategoryCount.getText().toString();
		logger.info("totalCategoryCount: " + totalCategroy);
	}

	public void getTotalAssetsCount() throws InterruptedException {
		String totalAsset = totalAssetCount.getText().toString();
		logger.info("totalAssetCount: " + totalAsset);
	}

	public void getTotalAvailableAssetCount() throws InterruptedException {
		String totalAvailableAsset = totalAvailableAssetCount.getText().toString();
		logger.info("totalAvailableAsset: " + totalAvailableAsset);
	}

	public void getTotalUsedAssetCount() throws InterruptedException {
		String totalUsedAsset = totalUsedAssetCount.getText().toString();
		logger.info("totalUsedAsset: " + totalUsedAsset);
	}

	public void clickOnMenuDashbaord() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		menuDashboard.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuDashboard");
	}

	public void clickOnMenuAssets() throws InterruptedException {
		menuAssets.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuAssets");
	}

	public void clickOnMenuAssetCategories() throws InterruptedException {
		menuAssetCategories.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuAssetCategories");
	}

	public void clickOnMenuReports() throws InterruptedException {
		menuReports.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuReports");
	}

	public void clickOnMenuAssetConfigurations() throws InterruptedException {
		menuAssetConfigurations.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuAssetConfigurations");
	}

	public void clickOnMenuVendors() throws InterruptedException {
		menuVendors.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuVendors");
	}

	public void clickOnMenuUsers() throws InterruptedException {
		menuUsers.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuUsers");
	}

	public void clickOnMenuInvoices() throws InterruptedException {
		menuInvoices.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuInvoices");
	}

	public void clickOnMenuServices() throws InterruptedException {
		menuServices.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuServices");
	}

	public boolean clickOnMenuSettings() throws InterruptedException {
		menuSettings.click();
		boolean flag = true;
		Thread.sleep(2000);
		logger.info("Clicked on the menuSettings");
		return flag;
	}
	
	public void clickOnMenuLocations() throws InterruptedException {
		menuLocations.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuLocations");
	}
	
	public void clickOnMenuDepartments() throws InterruptedException {
		menuDepartments.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuDepartments");
	}

	// =========END========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	// TO CHECK LOCKED USER AND IT'S COUNTS
	public PO_Inner_DashboardPage checkDashboardCounts() throws InterruptedException {
		logger.info("Method called: checkDashboardCount");
		Thread.sleep(1000);
		getLoggedUserName();
		getTotolCategoryCount();
		getTotalAssetsCount();
		getTotalAvailableAssetCount();
		getTotalUsedAssetCount();
		return new PO_Inner_DashboardPage(driver);
	}

	// TO CHECK THE MENUS
	public PO_Inner_DashboardPage checkDashboardInnerMenus() throws InterruptedException {
		clickOnMenuAssets();
		clickOnMenuAssetCategories();
		clickOnMenuReports();
		clickOnMenuAssetConfigurations();
		clickOnMenuVendors();
		clickOnMenuInvoices();
		clickOnMenuUsers();
		clickOnMenuServices();
		boolean isClickOnSetting  = clickOnMenuSettings();
		if(isClickOnSetting) {
			clickOnMenuLocations();
			clickOnMenuDepartments();
		}
		
		return new PO_Inner_DashboardPage(driver);
	}
}
