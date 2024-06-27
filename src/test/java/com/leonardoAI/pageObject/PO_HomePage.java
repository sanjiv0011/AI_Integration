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
import com.leonardoAI.pageObject.pageLocators.PL_HomePage;
import com.leonardoAI.utilities.ClickOnAnyButton;
import com.leonardoAI.utilities.NavigateToNewOpenTab;
import com.leonardoAI.utilities.SetDataIntoTextInputField;

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
	public SetDataIntoTextInputField setDataIntoTextInputField = new SetDataIntoTextInputField();
	public NavigateToNewOpenTab navigateToNewTab = new NavigateToNewOpenTab();
	public ClickOnAnyButton clickOnAnyButton = new ClickOnAnyButton();

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


	// TO LOGOUT
	public PO_LoginPage UserLogout() throws InterruptedException {
		logger.info("Method called: Logout");
		try {
			Thread.sleep(2000);
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "User Menus", PL_HomePage.ADDRESS_MENU_BUTTON);
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Logout", PL_HomePage.ADDRESS_LOGOUT_BUTTON);
			Thread.sleep(500);
			if (driver.getPageSource().contains("Sign up or Login with")) {
				softAssert.assertTrue(true);
				logger.info("... LOGOUT DONE ...");
			} else {
				softAssert.assertTrue(false);
				logger.info("!!! LOGOUT FAILEED !!!");
			}
		} catch (Exception e) {
			logger.info("Logout Exception: " + e.getMessage());
			softAssert.assertTrue(false, "After logout it lookin for [Sign up or Login with] text");
		}
		softAssert.assertAll();
		return new PO_LoginPage(driver);
	}

	// TO CHECK THE MENUS
	public PO_HomePage checkMenus() throws InterruptedException {
		return new PO_HomePage(driver);
	}
}
