package com.leonardoAI.pageObject;

import java.time.Duration;

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

import com.jkl.ReUseAble.PageObject.ReUseAbleElement;
import com.jkl.Main.pageObject.PO_Main_HomePage;

public class PO_LoginPage extends ReUseAbleElement {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	public PO_Main_HomePage mhp;
	public SoftAssert softAssert = new SoftAssert();
	
	public  PO_LoginPage(WebDriver driver)
	{   super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(30));
		action = new Actions(driver);
	}

	// to find page elements
	@FindBy(xpath = "//span[text()='Sign in with Google'][1]")
	@CacheLookup
	public WebElement btnSignInWithGoogle;
	
	@FindBy(xpath = "//input[@id='signInName']")
	@CacheLookup
	WebElement textemail;
	
	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	WebElement textpassword;
	
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	@CacheLookup
	WebElement btnsubmit;
	
	@FindBy(xpath = "(//div[contains(@class,\"MuiList-root\")][contains(.,'Dashboard')])[2]")
	@CacheLookup
	WebElement tabDashboard;

	
	//TO CLICK ON THE LOGIN BUTTON
	public void clickBtnSignIn() throws InterruptedException {
		btnSignInWithGoogle.click();
		logger.info("clicked on Sign in with google");
		Thread.sleep(1000);
	}
	
	//TO SET THE USERNAME/EMAIL AND WAIT TILL IS IS NOT APPERS MAX WAIT TIME(30 SECONDS)
	public void setUserName(String email) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(textemail));
		textemail.sendKeys(Keys.CONTROL,"a");
		textemail.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textemail.sendKeys(email);
		logger.info("Enteterd email");
		Thread.sleep(200);
	}
	
	//TO SET THE PASSWORD
	public void setTextpassword(String password) throws InterruptedException {
		textpassword.sendKeys(Keys.CONTROL,"a");
		textpassword.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textpassword.sendKeys(password);
		logger.info("Entered password");
		Thread.sleep(200);
	}

	//TO CLICK ON THE SUBMIT BUTTON
	public void clickBtnsubmit() throws InterruptedException {
		btnsubmit.click();
		logger.info("clicke on login submit button");
		Thread.sleep(200);
	}
	
	//FOR USER LOGIN
	public PO_HomePage Login(String userEmail,String userPassword) throws InterruptedException {
		try {
			logger.info("Method called Login: Login");
			clickBtnSignIn();
			setUserName(userEmail);
			setTextpassword(userPassword);
			clickBtnsubmit();
			
			try {
				wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Dashboard"));
				Thread.sleep(500);
				if(driver.getPageSource().contains("Welcome")) {
					softAssert.assertTrue(true);
					logger.info("...LOGIN DONE...");
				} else {
					softAssert.assertTrue(false);
					logger.info("!!!LOGIN FAILED!!!");
				}
			}catch(Exception e) {
				logger.info("Login exception message: "+e.getMessage());
				softAssert.assertEquals(driver.getPageSource().contains("Welcome"),"To check the login");
			}
		}catch(Exception e) {}
		
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}
	
	//FOR ADMIN LOGIN
	public PO_Main_HomePage AdminLogin(String adminEmail,String adminPassword) throws InterruptedException {
		try {
			logger.info("Method called Login: AdminLogin");
			clickBtnSignIn();
			setUserName(adminEmail);
			setTextpassword(adminPassword);
			clickBtnsubmit();
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(tabDashboard));
				Thread.sleep(500);
				if(driver.getPageSource().contains("This Week")) {
					softAssert.assertTrue(true);
					logger.info("...LOGIN DONE...");
				} else {
					Assert.assertTrue(false);
					logger.info("!!!LOGIN FAILED!!!");
				}
			}catch(Exception e) {
				logger.info("Login exception message: "+e.getMessage());
				softAssert.assertEquals(driver.getPageSource().contains("This Week"),"To check the login");
			}
			
		}catch(Exception e) {}
		softAssert.assertAll();
		return new PO_Main_HomePage(driver);
	}
	
}
