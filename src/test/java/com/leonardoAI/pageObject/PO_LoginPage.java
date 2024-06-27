package com.leonardoAI.pageObject;

import java.time.Duration;
import java.util.Set;

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
import com.leonardoAI.pageObject.pageLocators.PL_LoginPage;
import com.leonardoAI.utilities.ClickOnAnyButton;
import com.leonardoAI.utilities.NavigateToNewOpenTab;
import com.leonardoAI.utilities.SetDataIntoTextInputField;

public class PO_LoginPage extends ReUseAbleElement {

	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();
	public SetDataIntoTextInputField setDataIntoTextInputField = new SetDataIntoTextInputField();
	public NavigateToNewOpenTab navigateToNewTab = new NavigateToNewOpenTab();
	public ClickOnAnyButton clickOnAnyButton = new ClickOnAnyButton();

	public PO_LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
	}

	// FIND ELMENTS
	@FindBy(xpath = PL_LoginPage.addressTabDashboard)
	@CacheLookup
	WebElement tabDashboard;

	@FindBy(xpath = PL_LoginPage.addressBtnCloseModel)
	@CacheLookup
	WebElement btnCloseModel;

	@FindBy(xpath = PL_LoginPage.addresslogoLeonardoAI)
	@CacheLookup
	WebElement logoLeonardoAI;
	


	public boolean isLoginDone() throws InterruptedException {
		boolean isLoginDone = false;
		driver.getCurrentUrl();
		wait.until(ExpectedConditions.elementToBeClickable(logoLeonardoAI));
		if (logoLeonardoAI.isDisplayed()) {
			isLoginDone = true;
		}
		return isLoginDone;
	}

	// TO CLICK ON THE CLOSE MODEL BUTTON
	public void clickBtnCloseModel() throws InterruptedException {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(btnCloseModel));
			if (btnCloseModel.isDisplayed() && btnCloseModel.isEnabled()) {
				btnCloseModel.click();
				logger.info("clicke on btnCloseModel");
			}
		} catch (Exception e) {
			logger.info("Exception From:clickBtnCloseModel >> "+e.getMessage());
		}
		Thread.sleep(1000);
	}

	// FOR USER LOGIN
	public PO_HomePage Login(String userEmail, String userPassword) throws InterruptedException {
		try {
			logger.info("Method called Login: Login");
			navigateToNewTab.changeBetweenTabs(driver,"Launch App", PL_LoginPage.addressBtnLaunchApp);
			
			//USE THIS ONLY FOR BACK TO BACK ENTRY
			String[] inputFieldLables = {"Email","Password"};
			String[] inputFiledAddresses = {PL_LoginPage.addressFieldEmail,PL_LoginPage.addressFieldPassword};
			String[] inputFiledValues = {userEmail,userPassword};
			setDataIntoTextInputField.callMeToFillDataIntoTextInputFieldWithNameAndXpathAndValue(driver,inputFieldLables, inputFiledAddresses, inputFiledValues);
			
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Submit", PL_LoginPage.addressBtnSumbit);
			clickBtnCloseModel();

			try {
				Thread.sleep(200);
				if (isLoginDone()) {
					softAssert.assertTrue(true);
					logger.info("...LOGIN DONE...");
				} else {
					softAssert.assertTrue(false);
					logger.info("!!!LOGIN FAILED!!!");
				}
			} catch (Exception e) {
				logger.info("Login exception message: " + e.getMessage());
				softAssert.assertEquals(driver.getPageSource().contains("Welcome"), "To check the login");
			}
		} catch (Exception e) {
		}

		softAssert.assertAll();
		return new PO_HomePage(driver);
	}

}
