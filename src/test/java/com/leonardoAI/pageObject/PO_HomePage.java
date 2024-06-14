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

public class PO_HomePage extends ReUseAbleElement {

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
	public PO_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// ALERT MESSAGES
	public String alertMsgCardAddedSuccesfully = "Card Added Successfully.";

	// =========START========HOME PAGE OBJECTS=============//
	final String add_tab_dashaboard = "//div[contains(@class,'sidebarCategory')]//span[contains(text(),'Dashboard')]";
	final String add_tab_customer = "//div[contains(@class,'sidebarCategory')]//span[contains(text(),'Customers')]";
	final String add_userlogo = "//div[@class='flex items-center gap-2']";
	final String add_bnt_profile = "//li[contains(@role,'menuitem')]//div[contains(text(),'Profile')]";
	final String add_bnt_settings = "//li[contains(@role,'menuitem')]//div[contains(text(),'Settings')]";
	final String add_bnt_lockScreen = "//li[contains(@role,'menuitem')]//div[contains(text(),'Lock Screen')]";
	final String add_bnt_logout = "//li[contains(@role,'menuitem')]//div[contains(text(),'Logout')]";
	final String add_btn_yes = "//button//div[text()='Yes']";
	final String add_btn_no = "//button//div[text()='No']";

	// to find page elements
	@FindBy(xpath = "(//a[@title='Launch App'])[2]")
	@CacheLookup
	public WebElement btnLaunchApp;

	@FindBy(xpath = add_tab_customer)
	@CacheLookup
	WebElement menuCustomer;

	

	// =========END========HOME PAGE OBJECTS=============//

	// =========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	public void clickBtnLaunchApp() throws InterruptedException {
		btnLaunchApp.click();
		logger.info("clicked on btnLaunchApp");
		Thread.sleep(1000);
	}

	

	// =========END========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	// TO LOGOUT
	public PO_LoginPage UserLogout() throws InterruptedException {
		logger.info("Method called: Logout");
		try {
			Thread.sleep(2000);
			clickOnUserProfile();
			clickOnLogout();
			clickOnYes();
			Thread.sleep(500);
			if (driver.getPageSource().contains("Login with Google")) {
				softAssert.assertTrue(true);
				logger.info("... LOGOUT DONE ...");
			} else {
				softAssert.assertTrue(false);
				logger.info("!!! LOGOUT FAILEED !!!");
			}
		} catch (Exception e) {
			logger.info("Logout Exception: " + e.getMessage());
			softAssert.assertTrue(false, "After logout it lookin for [Login with Google] text");
		}
		softAssert.assertAll();
		return new PO_LoginPage(driver);
	}

	// TO CHECK THE MENUS
	public PO_HomePage checkMenus() throws InterruptedException {
		clickOnMenuDashboard();
		clickOnMenuCustomer();
		return new PO_HomePage(driver);
	}
}
