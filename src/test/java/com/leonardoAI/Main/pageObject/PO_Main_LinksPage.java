package com.leonardoAI.Main.pageObject;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.projectUtility.FindKeyFromListAndTakeActoinBasedOnTwoColumnElement;

public class PO_Main_LinksPage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();
	public FindKeyFromListAndTakeActoinBasedOnTwoColumnElement findKeyAndTakeAction;
	// CONSTRUCTOR CREATION
	public PO_Main_LinksPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);
	}

	// ALERT MESSAGES
	public static String linkCopied = "Link Copied!!";

	// ALL REQUIRED FILED IN THE SINGLE SET
	Set<String> requiredFided = new HashSet<String>(Arrays.asList("no messages"));

	// ======START======PAGE OBJECT FOR LINKS AND ACTOIN METHODS==========//

	// TEXT NO LINKS MATCHED TO CURRENT APPLIED FILTER
	@FindBy(xpath = "//*[.='No region Matches Current Filter")
	@CacheLookup
	public WebElement noLinkMatchedWithApplieddFilter;

	public boolean isNoLinkMatchedDisplayed() throws InterruptedException {
		boolean flag = false;
		try {
			Thread.sleep(5000);
			flag = noLinkMatchedWithApplieddFilter.isDisplayed();
			if (flag) {
				logger.info("Searched key not present");
				softAssert.assertTrue(flag, "Link you are searching is not found");
				clickOnP360Logo_RU();
			}
		} catch (Exception e) {
			logger.info("Searched Link list is present, after applied filter");
			logger.info("Exception from : " + e.getMessage());
		}
		logger.info("noLinkMatchedWithApplieddFilter: " + flag);
		softAssert.assertAll();
		return flag;
	}

	
	
	// LINKS LIST
	@FindBy(xpath = "//div[contains(@class,'px-2 py-3')]")
	@CacheLookup
	List<WebElement> listLinks;
	// LINKS ROW LIST ADDRESS AND ACTION METHODS
	public String listUsreLabels_address = "//div[contains(@class,'px-2 py-3')]";

	public boolean findAndCopyLinks(String searchKey,int intSearchKeyColumnIndex, boolean wantToCopyCalendarLink, boolean wantToCopyRegistrationLink ) throws InterruptedException {
		
		int actionFirstColumnIndex = 2;
		int actionSecondColumnIndext = 3;
		String address_CopyCalendarLink = "//div[contains(text(),'Copy Calendar Link')]";
		String address_CopyQuickRegistrationLink = "//div[contains(text(),'Copy Quick Registration Link')]";
		
		boolean flag = FindKeyFromListAndTakeActoinBasedOnTwoColumnElement.findAndCopyLinks(driver, listLinks, listUsreLabels_address, searchKey, intSearchKeyColumnIndex, actionFirstColumnIndex,  actionSecondColumnIndext, wantToCopyCalendarLink, wantToCopyRegistrationLink,address_CopyCalendarLink, address_CopyQuickRegistrationLink);
		
		return flag;
	}

	// TO SEARCH LOCATION NAME
	public void searchLinkLocation(String locationName) throws InterruptedException {
		searchBox_1_RU(driver, locationName);
	}
	// ======END======PAGE OBJECT FOR ADD LINKS ACTOIN METHODS==========//

	// TO COPY LINKS
	public PO_Main_HomePage copyLinks(String locationName, String searchKey, boolean wantToCopayCalendarLink,
		boolean wantToCopyQuickRegistrationLink,int searchKeyColumnIndex ) throws Throwable {
		searchLinkLocation(locationName);
		boolean flag = findAndCopyLinks(searchKey,searchKeyColumnIndex, wantToCopayCalendarLink, wantToCopyQuickRegistrationLink );
		if(flag) {
			String alertMsg = snakeAlertMessagesDisplayedContent_RU();
			if(alertMsg.equals(linkCopied)) {
				logger.info("Linked Copied");
			}
			softAssert.assertEquals(alertMsg,linkCopied,"Check link copied or not");
		}
		
		softAssert.assertAll();
		return new PO_Main_HomePage(driver);
	}

}
