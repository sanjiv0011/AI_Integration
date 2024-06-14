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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;

public class PO_LoginPage extends ReUseAbleElement {

	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	public PO_LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
	}

	// FIND ELMENTS

	// LAUNCH APP
	@FindBy(xpath = "(//a[@title='Launch App'])[2]")
	@CacheLookup
	public WebElement btnLaunchApp;

//	// LOGIN WITH GOOGLE, BUTTON
//	@FindBy(xpath = "(//button[@type='button'])[2][.='Google']")
//	@CacheLookup
//	public WebElement btnLoginWithGoogle;
//
//	// LOGIN WITH GOOGLE, EMAIL
//	@FindBy(xpath = "//input[@type='email']")
//	@CacheLookup
//	public WebElement textLoginWithGoogleEmail;
//	
//	// LOGIN WITH GOOGLE, 	NEXT
//	@FindBy(xpath = "//button//span[text()='Next']")
//	@CacheLookup
//	public WebElement btnLoginWithGoogleNext;
//	
//	// LOGIN WITH GOOGLE, PASSWORD
//	@FindBy(xpath = "//input[@type='password']")
//	@CacheLookup
//	public WebElement textLoginWithGooglePassword;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	@CacheLookup
	WebElement textemail;

	@FindBy(xpath = "(//input[@id='password'])[1]")
	@CacheLookup
	WebElement textpassword;

	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	@CacheLookup
	WebElement btnsubmit;

	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Dashboard')])[2]")
	@CacheLookup
	WebElement tabDashboard;

	@FindBy(xpath = "(//button[@aria-label='Close Modal'])[1]")
	@CacheLookup
	WebElement btnCloseModel;

	@FindBy(xpath = "//h1[contains(@class,'chakra-heading')]")
	@CacheLookup
	WebElement textGetStartedHere;

	// TO CLICK ON THE SUBMIT BUTTON
	public void clickBtnLaunchApp() throws InterruptedException {
		btnLaunchApp.click();
		logger.info("clicke on btnLaunchApp");
		Thread.sleep(1000);
	}

	public void changeBetweenTabs() throws InterruptedException {
		// Capture the original window handle[use it for come back]
		String originalWindow = driver.getWindowHandle();
		logger.info("originalWindow: " + driver.getTitle());
		// Capture all the open window tabs[show the number of current window opened]
		Set<String> existingWindows = driver.getWindowHandles();
		for (String tabs : existingWindows) {
			logger.info("Open Windows: " + tabs);
		}

		btnLaunchApp.click();
		logger.info("clicke on btnLaunchApp");
		Thread.sleep(1000);

		// Wait for the new tab to appear
		wait.until(driver -> driver.getWindowHandles().size() > existingWindows.size());

		/*
		 * driver.getWindowHandles().size() gives the current number of open
		 * windows/tabs. existingWindows.size() gives the number of windows/tabs before
		 * the button click.
		 */

		// Get the new window handle
		Set<String> newWindowHandles = driver.getWindowHandles();
		newWindowHandles.removeAll(existingWindows);
		String newWindowHandle = newWindowHandles.iterator().next();

		// Switch to the new tab
		driver.switchTo().window(newWindowHandle);
		logger.info("newWindowHandle: " + driver.getTitle());
		driver.getCurrentUrl();
		logger.info("New Window: " + driver.getTitle());
		logger.info("Switched to the new tab");
	}

	// TO SET THE USERNAME/EMAIL AND WAIT TILL IS IS NOT APPERS MAX WAIT TIME(30
	// SECONDS)
	public void setUserName(String email) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(textemail));
		textemail.sendKeys(Keys.CONTROL, "a");
		textemail.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textemail.sendKeys(email);
		logger.info("Enteterd email");
		Thread.sleep(200);
	}

	// TO SET THE PASSWORD
	public void setTextpassword(String password) throws InterruptedException {
		textpassword.sendKeys(Keys.CONTROL, "a");
		textpassword.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textpassword.sendKeys(password);
		logger.info("Entered password");
		Thread.sleep(200);
	}

	// TO CLICK ON THE SUBMIT BUTTON
	public void clickBtnsubmit() throws InterruptedException {
		btnsubmit.click();
		logger.info("clicke on login submit button");
		Thread.sleep(200);
	}

	public boolean isLoginDone() throws InterruptedException {
		boolean isLoginDone = false;
		driver.getCurrentUrl();
		wait.until(ExpectedConditions.invisibilityOfAllElements(textGetStartedHere));
		String text = textGetStartedHere.getText().toString().trim();
		logger.info("Text: "+text);
		if (textGetStartedHere.equals(text)) {
			isLoginDone = true;
		}
		return isLoginDone;
	}

	// TO CLICK ON THE CLOSE MODEL BUTTON
	public void clickBtnCloseModel() throws InterruptedException {
		try {
			if (btnCloseModel.isDisplayed() && btnCloseModel.isEnabled()) {
				btnCloseModel.click();
			}
		} catch (Exception e) {
		}

		logger.info("clicke on btnCloseModel");
		Thread.sleep(1000);
	}

	// FOR USER LOGIN
	public PO_HomePage Login(String userEmail, String userPassword) throws InterruptedException {
		try {
			logger.info("Method called Login: Login");
			// clickBtnLaunchApp();
			changeBetweenTabs();
			setUserName(userEmail);
			setTextpassword(userPassword);
			clickBtnsubmit();
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
