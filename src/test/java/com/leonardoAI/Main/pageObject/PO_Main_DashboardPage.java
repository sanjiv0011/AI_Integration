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
import com.leonardoAI.projectUtility.FindHoverDataOfLineGraphs;
import com.leonardoAI.projectUtility.FindKeyFromListAndTakeActoinBasedOnTwoColumnElement;
import com.leonardoAI.projectUtility.Generic_Method_ToSelect_Bootstrap_Dropdown;
import com.leonardoAI.projectUtility.ScrollListElement;
import com.leonardoAI.projectUtility.ScrollPageUpDown;

public class PO_Main_DashboardPage extends ReUseAbleElement {

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
	public Runnable runnable;
	public ScrollPageUpDown scrollPage;

	// CONSTRUCTOR CREATION
	public PO_Main_DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// ALL REQUIRED FILED IN THE SINGLE SET

	Set<String> requiredFided = new HashSet<String>(Arrays.asList("no messages right now"));

	// BASE ADDRESS FOR LIST BOXES PRESENT AT THE DASHBOARD
	final String baseAddress_ClassCancellationActivity = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[1]";
	final String baseAddress_TotalPaymentsActivity = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[2]";
	final String baseAddress_PackagePurchaseHistory = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[3]";
	final String baseAddress_ClassRegistrationActivity = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[4]";
	final String baseAddress_TopCoaches = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[5]";
	final String baseAddress_TopWorkouts = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[6]";
	final String baseAddress_FailedPayments = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[7]";
	final String baseAddress_FreeTrialUsers = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[8]";
	final String baseAddress_TrialUsersConversions = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[9]";
	final String baseAddress_TotalClassesCoached = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[10]";
	final String baseAddress_NewMembers = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[11]";
	final String baseAddress_NoShows = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[12]";
	final String baseAddress_CanceledMemberships = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[13]";
	final String baseAddress_CategoryRevenue = "(// div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[14]";

	// ADDRESSES FOR THE LIST PRESENT ON THE DASHBOARDS
	final String list_FreeTrailUser_address = baseAddress_FreeTrialUsers
			+ "//div[@class='w-full flex flex-col border-b py-1 gap-1']";
	final String list_TopCoaches_Address = baseAddress_TopCoaches
			+ "//div[@class='w-full flex flex-col border-b py-1 gap-1']";
	final String list_FailedPayment_Address = baseAddress_FailedPayments
			+ "//div[@class='w-full flex flex-col border-b py-1 gap-1']";
	final String list_TrailUsersConveration_Address = baseAddress_TrialUsersConversions
			+ "//div[@class='w-full flex flex-col border-b py-1 gap-1']";
	final String list_TotalClassesCoached_Address = baseAddress_TotalClassesCoached
			+ "//div[@class='w-full flex flex-col border-b py-1 gap-1']";
	final String list_TopWorkout_Address = baseAddress_TopWorkouts
			+ "//div[@class='w-full flex justify-between items-start border-b py-1']";
	final String list_NewMember_Address = baseAddress_NewMembers
			+ "//div[@class='w-full flex flex-col border-b py-1 gap-1']";
	final String list_NoShow_Address = baseAddress_NoShows + "//div[@class='w-full flex flex-col border-b py-1 gap-1']";
	final String list_CanceledMemberships_Address = baseAddress_CanceledMemberships
			+ "//div[@class='w-full flex flex-col border-b py-1 gap-1']";
	final String list_CategoryRenenue_Address = baseAddress_CategoryRevenue
			+ "//div[@class='w-full flex flex-col border-b py-1 gap-1']";

	// ======START======PAGE OBJECT FOR DASHBOARD AND ACTOIN METHODS==========//

	// TO SELECT THE LOCATIONS
	public void selectLocation(String locationName) throws InterruptedException {
		if (locationName == "" || locationName == null) {
			logger.info("Defaut location name: All location selected");
		} else {
			ruae.clickOnDropdown_2_RU(driver);
			Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver, ruae.listOptionAddress_RU,
					locationName);
			Thread.sleep(1000);
		}

	}

	// TO SELECT THE TIME DURATION
	public void selectTimeDuration(String timeDuration) throws InterruptedException {
		ruae.clickOnDropdown_1_RU(driver);
		Generic_Method_ToSelect_Bootstrap_Dropdown.selectOptionFromDropdown(driver, ruae.listOptionAddress_RU,
				timeDuration);
		Thread.sleep(1000);
	}

	@FindBy(xpath = "(//div[@class='text-3xl font-bold'])[1]//span")
	@CacheLookup
	WebElement totalSignUp;

	public void totalSignUpValue() throws InterruptedException {
		String totalSingUpValue = null;
		String singUpValue = null;
		try {
			singUpValue = totalSignUp.getText();
			logger.info("singUpValue: " + singUpValue);
			Thread.sleep(200);
			totalSingUpValue = totalSignUp.getAttribute("title");

			if (singUpValue.contains("+")) {
				logger.info("totalSingUpValue: " + totalSingUpValue);
			} else {
				logger.info("singUpValue and totalSingUpValue both are same");
			}

			action.clickAndHold(totalSignUp).build().perform();
			Thread.sleep(1000);
			action.release(totalSignUp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FindBy(xpath = "(//div[@class='text-3xl font-bold'])[2]//span")
	@CacheLookup
	WebElement totalRevenue;

	public void totalRevenueValue() throws InterruptedException {
		String totalRevenueValue = null;
		String revenueValue = null;
		try {
			revenueValue = totalRevenue.getText();
			logger.info("revenueValue: " + revenueValue);
			Thread.sleep(200);

			totalRevenueValue = totalRevenue.getAttribute("title");

			if (revenueValue.contains("+")) {
				logger.info("totalRevenueValue: " + totalRevenueValue);
			} else {
				logger.info("singUpValue and totalSingUpValue both are same");
			}

			action.clickAndHold(totalRevenue).build().perform();
			Thread.sleep(1000);
			action.release(totalRevenue);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FindBy(xpath = "(//div[@class='text-3xl font-bold'])[3]//span")
	@CacheLookup
	WebElement totalMemberships;

	public void totalMembershipsValue() throws InterruptedException {
		String totalMembershipsValue = null;
		String membershipValue = null;
		try {
			membershipValue = totalMemberships.getText();
			logger.info("membershipValue: " + membershipValue);
			Thread.sleep(200);

			totalMembershipsValue = totalMemberships.getAttribute("title");

			if (membershipValue.contains("+")) {
				logger.info("totalMembershipsValue: " + totalMembershipsValue);
			} else {
				logger.info("membershipValue and totalMembershipsValue both are same");
			}

			action.clickAndHold(totalMemberships).build().perform();
			Thread.sleep(1000);
			action.release(totalMemberships);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='text-3xl font-bold'])[4]//span")
	@CacheLookup
	WebElement totalActiveMemberships;

	public void totalActiveMembershipsValue() throws InterruptedException {
		String totalActiveMembershipsValue = null;
		String activeMembershipValue = null;
		try {
			activeMembershipValue = totalActiveMemberships.getText();
			logger.info("activeMembershipValue: " + activeMembershipValue);
			Thread.sleep(200);

			totalActiveMembershipsValue = totalMemberships.getAttribute("title");

			if (activeMembershipValue.contains("+")) {
				logger.info("totalActiveMembershipsValue: " + totalActiveMembershipsValue);
			} else {
				logger.info("activeMembershipValue and totalActiveMembershipsValue both are same");
			}

			action.clickAndHold(totalActiveMemberships).build().perform();
			Thread.sleep(1000);
			action.release(totalActiveMemberships);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FindBy(xpath = "(//div[@class='text-3xl font-bold'])[5]//span")
	@CacheLookup
	WebElement totalCanceledMembership;

	public void totalCanceledMembershipValue() throws InterruptedException {
		String totalCancelMembershipsValue = null;
		String cancelMembershipValue = null;
		try {
			cancelMembershipValue = totalCanceledMembership.getText();
			logger.info("cancelMembershipValue: " + cancelMembershipValue);
			Thread.sleep(200);

			totalCancelMembershipsValue = totalCanceledMembership.getAttribute("title");

			if (cancelMembershipValue.contains("+")) {
				logger.info("totalCancelMembershipsValue: " + totalCancelMembershipsValue);
			} else {
				logger.info("cancelMembershipValue and totalCancelMembershipsValue both are same");
			}

			action.clickAndHold(totalCanceledMembership).build().perform();
			Thread.sleep(1000);
			action.release(totalCanceledMembership);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='text-3xl font-bold'])[6]//span")
	@CacheLookup
	WebElement totalHoldMemberships;

	public void totalHoldMembershipsValue() throws InterruptedException {
		String totalHoldMembershipsValue = null;
		String holdMembershipValue = null;
		try {
			holdMembershipValue = totalHoldMemberships.getText();
			logger.info("holdMembershipValue: " + holdMembershipValue);
			Thread.sleep(200);

			totalHoldMembershipsValue = totalHoldMemberships.getAttribute("title");

			if (holdMembershipValue.contains("+")) {
				logger.info("totalHoldMembershipsValue: " + totalHoldMembershipsValue);
			} else {
				logger.info("holdMembershipValue and totalHoldMembershipsValue both are same");
			}

			action.clickAndHold(totalHoldMemberships).build().perform();
			Thread.sleep(1000);
			action.release(totalHoldMemberships);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='text-3xl font-bold'])[7]//span")
	@CacheLookup
	WebElement totalSuspendedMemberships;

	public void totalSuspendedMembershipsValue() throws InterruptedException {
		String totalSuspendedMembershipsValue = null;
		String SuspendedMembershipValue = null;
		try {
			SuspendedMembershipValue = totalSuspendedMemberships.getText();
			logger.info("holdMembershipValue: " + SuspendedMembershipValue);
			Thread.sleep(200);

			totalSuspendedMembershipsValue = totalCanceledMembership.getAttribute("title");

			if (SuspendedMembershipValue.contains("+")) {
				logger.info("totalSuspendedMembershipsValue: " + totalSuspendedMembershipsValue);
			} else {
				logger.info("suspendedMembershipValue and totalSuspendedMembershipsValue both are same");
			}

			action.clickAndHold(totalSuspendedMemberships).build().perform();
			Thread.sleep(1000);
			action.release(totalSuspendedMemberships);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='text-3xl font-bold'])[8]//span")
	@CacheLookup
	WebElement totalNewMemberships;

	public void totalNewMembershipsValue() throws InterruptedException {
		String totalNewMembershipsValue = null;
		String newMembershipValue = null;
		try {
			newMembershipValue = totalNewMemberships.getText();
			logger.info("newMembershipValue: " + newMembershipValue);
			Thread.sleep(200);

			totalNewMembershipsValue = totalNewMemberships.getAttribute("title");

			if (newMembershipValue.contains("+")) {
				logger.info("totalNewMembershipsValue: " + totalNewMembershipsValue);
			} else {
				logger.info("newMembershipValue and totalNewMembershipsValue both are same");
			}

			action.clickAndHold(totalNewMemberships).build().perform();
			Thread.sleep(1000);
			action.release(totalNewMemberships);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FindBy(xpath = "(//div[@class='text-3xl font-bold'])[9]//span")
	@CacheLookup
	WebElement totalClassesAttended;

	public void totalClassesAttendedValue() throws InterruptedException {
		String totalClassesAttendedValue = null;
		String classesAttendedValue = null;
		try {
			classesAttendedValue = totalClassesAttended.getText();
			logger.info("classesAttendedValue: " + classesAttendedValue);
			Thread.sleep(200);

			totalClassesAttendedValue = totalClassesAttended.getAttribute("title");

			if (classesAttendedValue.contains("+")) {
				logger.info("totalClassesAttendedValue: " + totalClassesAttendedValue);
			} else {
				logger.info("classesAttendedValue and totalClassesAttendedValue both are same");
			}

			action.clickAndHold(totalClassesAttended).build().perform();
			Thread.sleep(1000);
			action.release(totalClassesAttended);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "(//div[@class='text-3xl font-bold'])[10]//span")
	@CacheLookup
	WebElement avgClassSize;

	public void avgClassSizeValue() throws InterruptedException {
		String totalAvgClassValue = null;
		String avgClassValue = null;
		try {
			avgClassValue = avgClassSize.getText();
			logger.info("avgClassValue: " + avgClassValue);
			Thread.sleep(200);

			totalAvgClassValue = avgClassSize.getAttribute("title");

			if (avgClassValue.contains("+")) {
				logger.info("totalClassesAttendedValue: " + totalAvgClassValue);
			} else {
				logger.info("avgClassValue and totalAvgClassValue both are same");
			}

			action.clickAndHold(avgClassSize).build().perform();
			Thread.sleep(1000);
			action.release(avgClassSize);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// DASH BOARD GRAPHS TITLES LIST
	@FindBy(xpath = "//div[@class='flex items-center gap-2 pl-3']")
	@CacheLookup
	List<WebElement> dashboardGraphsTitles;
	public boolean isDashboardGraphsTitlesPresent(String graphsName) {
		boolean flag = false;
		for(WebElement ele : dashboardGraphsTitles) {
			if(ele.getText().trim().equals(graphsName));{
				flag = true;
				logger.info("dashboardGraphsTitles : "+graphsName+" is present: "+flag);
			}
		}
		if(flag == false) {
			logger.info("Given dashboardGraphsName is not present:"+graphsName);
		}
		return flag;
	}

	
	// DASH BOARD GRAPHS TITLES LIST
	@FindBy(xpath = "//div[@class='flex items-center gap-2 px-3']")
	@CacheLookup
	List<WebElement> dashboardListTitles;
	public boolean isDashboardListTitlesPresent(String dashboardTitleName) {
		boolean flag = false;
		for(WebElement ele : dashboardGraphsTitles) {
			if(ele.getText().trim().equals(dashboardTitleName));{
				flag = true;
				logger.info("dashboardTitlesName : "+dashboardTitleName+" is present: "+flag);
			}
		}
		if(flag == false) {
			logger.info("Given dashboardTitlesName is not present:"+dashboardTitleName);
		}
		return flag;
	}

	

	// CLASS CANCEL ACTIVITY COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_ClassCancellationActivity)
	@CacheLookup
	WebElement titleClassCancelActivity;

	public void moveToClassCancelActivity() throws InterruptedException {
		try {
			action.moveToElement(titleClassCancelActivity).build().perform();
			logger.info("Mouse move over : titleClassCancelActivity ");
			Thread.sleep(500);
		} catch (Exception e) {
			logger.info(" Exception form moveToClassCancelActivity : " + e.getCause());
		}
	}

	// TOTAL PAYMENT ACTIVITY COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_TotalPaymentsActivity)
	@CacheLookup
	WebElement titleTotalPaymentActivity;

	public void moveToTotalPaymentActivity() throws InterruptedException {

		try {
			action.moveToElement(titleTotalPaymentActivity).build().perform();
			logger.info("Mouse move over : titleTotalPaymentActivity");
			Thread.sleep(500);
		} catch (Exception e) {
			logger.info("Exception from moveToTotalPaymentActivity : " + e.getCause());
		}
	}

	// TOOL-TIP FOR TOTAL PAYMENT ACTIVITY COMPLETE BOX AREA
	@FindBy(xpath = "(//div[@class='apexcharts-tooltip-y-group'])[2]")
	@CacheLookup
	WebElement toolTips_titleTotalPaymentActivity;

	// CHART MONTH LIST ADDRESS FOR TOTAL PAYMENT ACTIVITY COMPLETE BOX AREA
	@FindBy(xpath = "(//*[name()='g'][@class='apexcharts-xaxis'])[2]")
	@CacheLookup
	WebElement xaxis_month_titleTotalPaymentActivity;

	// PACKAGE PURCHASE ACTIVITY COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_PackagePurchaseHistory)
	@CacheLookup
	WebElement titlePackagePurchageActivity;

	public void moveToPackagePurchageActivity() throws InterruptedException {

		try {
			action.moveToElement(titlePackagePurchageActivity).build().perform();
			logger.info("Mouse move over : titlePackagePurchageActivity");
			Thread.sleep(500);
		} catch (Exception e) {
			logger.info("Exception from moveToPackagePurchageActivity : " + e.getCause());
		}
	}

	// TOOL-TIP FOR PACKAGE PURCHASE ACTIVITY COMPLETE BOX AREA
	@FindBy(xpath = "(//div[@class='apexcharts-tooltip-y-group'])[3]")
	@CacheLookup
	WebElement toolTips_titlePackagePurchageActivity;

	// CHART MONTH LIST ADDRESS FOR PACKAGE PURCHASE ACTIVITY COMPLETE BOX AREA
	@FindBy(xpath = "(//*[name()='g'][@class='apexcharts-xaxis'])[3]")
	@CacheLookup
	WebElement xaxis_month_titlePackagePurchageActivity;

	// CLASS REGISTRATION ACTIVITY COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_ClassRegistrationActivity)
	@CacheLookup
	WebElement titleClassRegistrationActivity;

	public void moveClassRegistrationActivity() throws InterruptedException {

		try {
			action.moveToElement(titleClassRegistrationActivity).build().perform();
			logger.info("Mouse move over : titleClassRegistrationActivity");
			Thread.sleep(500);

		} catch (Exception e) {
			logger.info(" Exceptin from moveClassRegistrationActivity : " + e.getCause());
		}
	}

	// TOOL-TIP FOR CLASS REGISTRATION ACTIVITY COMPLETE BOX AREA
	@FindBy(xpath = "(//div[@class='apexcharts-tooltip-y-group'])[4]")
	@CacheLookup
	WebElement toolTips_titleClassRegistrationActivity;

	// CHART MONTH LIST ADDRESS FOR CLASS REGISTRATION ACTIVITY COMPLETE BOX AREA
	@FindBy(xpath = "(//*[name()='g'][@class='apexcharts-xaxis'])[4]")
	@CacheLookup
	WebElement xaxis_month_titleClassRegistrationActivity;

	// TOP COACHES COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_TopCoaches)
	@CacheLookup
	WebElement titleTopCoaches;

	public void moveTopCoaches() throws InterruptedException {

		try {
			action.moveToElement(titleTopCoaches).build().perform();
			logger.info("Mouse move over : titleTopCoaches");
			Thread.sleep(500);
		} catch (Exception e) {
			logger.info("Exceptin form  moveTopCoaches : " + e.getCause());
		}
	}

	// TOP WORKOUT COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_TopWorkouts)
	@CacheLookup
	WebElement titleTopWorkouts;

	public void moveTopWorkouts() throws InterruptedException {

		try {
			action.moveToElement(titleTopWorkouts).build().perform();
			logger.info("Mouse move over : titleTopWorkouts");
			Thread.sleep(500);
		} catch (Exception e) {
			logger.info("Exceptin form  moveTopWorkouts : " + e.getCause());
		}
	}

	// FAILED PAYMENT COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_FailedPayments)
	@CacheLookup
	WebElement titleFailedPayments;

	public void moveFailedPayments() throws InterruptedException {

		try {
			action.moveToElement(titleFailedPayments).build().perform();
			logger.info("Mouse move over : titleFailedPayments");
			Thread.sleep(500);
		} catch (Exception e) {
			logger.info("Exceptin form moveFailedPayments : " + e.getCause());
		}
	}

	// FREE TRIAL USERS COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_FreeTrialUsers)
	@CacheLookup
	WebElement titleFreeTrailUsers;

	public void moveFreeTrailUsers() throws InterruptedException {
		try {
			logger.info("baseAddress_FreeTrialUsers: " + baseAddress_FreeTrialUsers);
			action.moveToElement(titleFreeTrailUsers).build().perform();
			logger.info("Mouse move over : titleFreeTrailUsers");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.info("Exceptin form  moveFreeTrailUsers : " + e.getCause());
		}
	}

	// TRIAL USERS CONVERSATION COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_TrialUsersConversions)
	@CacheLookup
	WebElement titleTrailUsersConversations;

	public void moveTrailUsersConversations() throws InterruptedException {

		try {
			action.moveToElement(titleTrailUsersConversations).build().perform();
			logger.info("Mouse move over : titleTrailUsersConversations");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.info(" Exceptin form  moveTrailUsersConversations: " + e.getCause());
		}
	}

	// CANCELED MEMBERSHIP COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_CanceledMemberships)
	@CacheLookup
	WebElement titleCanceledMemberships;

	public void moveCanceledMemberships() throws InterruptedException {

		try {
			action.moveToElement(titleCanceledMemberships).build().perform();
			logger.info("Mouse move over : titleCanceledMemberships");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.info("Exceptin form  moveCanceledMemberships : " + e.getCause());
		}
	}

	// TOTAL CLASSES COACHED COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_TotalClassesCoached)
	@CacheLookup
	WebElement titleTotalClassesCoacheds;

	public void moveTotalClassesCoacheds() throws InterruptedException {

		try {
			action.moveToElement(titleTotalClassesCoacheds).build().perform();
			logger.info("Mouse move over : titleTotalClassesCoacheds");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.info("Exceptin form  moveTotalClassesCoacheds: " + e.getCause());
		}
	}

	// NEW MEMBERS COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_NewMembers)
	@CacheLookup
	WebElement titleNewMembers;

	public void moveNewMembers() throws InterruptedException {

		try {
			action.moveToElement(titleNewMembers).build().perform();
			logger.info("Mouse move over : titleNewMembers");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.info("Exceptin form moveNewMembers: " + e.getCause());
		}
	}

	// NOW SHOW COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_NoShows)
	@CacheLookup
	WebElement titleNoShow;

	public void moveNoShow() throws InterruptedException {
		try {
			action.moveToElement(titleNoShow).build().perform();
			logger.info("Mouse move over : titleNoShow");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.info("Exceptin form  moveNoShow" + e.getCause());
		}
	}

	// CATEGORY REVENUE COMPLETE BOX AREA
	@FindBy(xpath = baseAddress_CategoryRevenue)
	@CacheLookup
	WebElement titleCategoryRevenues;

	public void moveCategoryRevenues() throws InterruptedException {
		try {
			action.moveToElement(titleCategoryRevenues).build().perform();
			logger.info("Mouse move over : titleCategoryRevenues");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.info("Exceptin form  moveCategoryRevenues: " + e.getCause());
		}
	}

	String scrollAbleElement = "(//p[contains(@class,'MuiTypography-body1')][normalize-space()='Dashboard'])[1]";

	// ======START============= CLASS CANCEL ACTIVITY COMPLETE BOX
	// AREA=====================//
	// TOOL-TIP
	String toolTips_Title_ClassCancelActivity_Address = "(//div[@class='apexcharts-tooltip-title'])[1]";

	// TOOL-TIP MONTH NAME
	String toolTips_Content_MonthNameClassCancelActivity_Address = "(//div[@class='apexcharts-tooltip-y-group'])[1]";

	// CHART XAXIS-MONTH LIST ADDRESS
	public String list_xaxis_titleClassCancelActivity_address = "((//*[name()='g'][@class='apexcharts-xaxis-texts-g'])[1]//*[name()='text'])";

	// CHART MONTH LIST FROM Y-AXIS ADDRESS
	public String list_yaxis__WRT_xaxis_MonthLinesClassCancelActivity_address = "(//div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[1]//*[name()='line'][@class='apexcharts-xaxis-tick']";

	// TO CATCH THE LINE GRAPH DATA BY HOVER ON THE GRAPHS
	public void findClassCancelActivityGraphsDataByHover(String xAxisUserValue) throws InterruptedException {
		FindHoverDataOfLineGraphs.findLineGraphYAxisDataBasedOnXAxisDataFromLineGraphByHover(driver,
				list_xaxis_titleClassCancelActivity_address, xAxisUserValue,
				list_yaxis__WRT_xaxis_MonthLinesClassCancelActivity_address, toolTips_Title_ClassCancelActivity_Address,
				toolTips_Content_MonthNameClassCancelActivity_Address);
	}
	// ======END============= CLASS CANCEL ACTIVITY COMPLETE BOX
	// AREA=====================//

	// ======START============= TOTAL PAYMENTS ACTIVITY.=====================//
	// TOOL-TIP TITLE
	String toolTips_Title_TotalPaymentsActivity_Address = "(//div[@class='apexcharts-tooltip-title'])[2]";

	// TOOL-TIP MONTH NAME
	String toolTips_Content_MonthNameTotalPaymentsActivity_Address = "(//div[@class='apexcharts-tooltip-y-group'])[2]";

	// CHART XAXIS-MONTH LIST ADDRESS
	public String list_xaxis_titleTotalPaymentsActivity_address = "((//*[name()='g'][@class='apexcharts-xaxis-texts-g'])[2]//*[name()='text'])";

	// CHART MONTH LIST FROM Y-AXIS ADDRESS
	public String list_yaxis__WRT_xaxis_MonthTotalPaymentsActivity_address = "(//div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[2]//*[name()='line'][@class='apexcharts-xaxis-tick']";

	// TO CATCH THE LINE GRAPH DATA BY HOVER ON THE GRAPHS
	public void findTotalPaymentsActivityGraphsDataByHover(String xAxisUserValue) throws InterruptedException {
		FindHoverDataOfLineGraphs.findLineGraphYAxisDataBasedOnXAxisDataFromLineGraphByHover(driver,
				list_xaxis_titleTotalPaymentsActivity_address, xAxisUserValue,
				list_yaxis__WRT_xaxis_MonthTotalPaymentsActivity_address, toolTips_Title_TotalPaymentsActivity_Address,
				toolTips_Content_MonthNameTotalPaymentsActivity_Address);
	}
	// ======END============= TOTAL PAYMENTS ACTIVITY=====================//

	// ======START=============PACKAGE PURCHAGE HISTORY=====================//
	// TOOL-TIP TITLE
	String toolTips_Title_PackagePurchageHistory_Address = "(//div[@class='apexcharts-tooltip-title'])[3]";

	// TOOL-TIP MONTH NAME
	String toolTips_Content_MonthNamePackagePurchageHistory_Address = "(//div[@class='apexcharts-tooltip-y-group'])[3]";

	// CHART XAXIS-MONTH LIST ADDRESS
	public String list_xaxis_titlePackagePurchageHistory_address = "((//*[name()='g'][@class='apexcharts-xaxis-texts-g'])[3]//*[name()='text'])";

	// CHART MONTH LIST FROM Y-AXIS ADDRESS
	public String list_yaxis__WRT_xaxis_MonthPackagePurchageHistory_address = "(//div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[3]//*[name()='line'][@class='apexcharts-xaxis-tick']";

	// TO CATCH THE LINE GRAPH DATA BY HOVER ON THE GRAPHS
	public void findPackagePurchaseHistoryGraphsDataByHover(String xAxisUserValue) throws InterruptedException {
		FindHoverDataOfLineGraphs.findLineGraphYAxisDataBasedOnXAxisDataFromLineGraphByHover(driver,
				list_xaxis_titlePackagePurchageHistory_address, xAxisUserValue,
				list_yaxis__WRT_xaxis_MonthPackagePurchageHistory_address,
				toolTips_Title_PackagePurchageHistory_Address,
				toolTips_Content_MonthNamePackagePurchageHistory_Address);
	}
	// ======END============= PACKAGE PURCHAGE HISTORY=====================//

	// ======START=============CLASS REGISTRATION ACTIVITY=====================//
	// TOOL-TIP TITLE
	String toolTips_Title_ClassRegistrationActivity_Address = "(//div[@class='apexcharts-tooltip-title'])[4]";

	// TOOL-TIP MONTH NAME
	String toolTips_Content_MonthNameClassRegistrationActivity_Address = "(//div[@class='apexcharts-tooltip-y-group'])[4]";

	// CHART XAXIS-MONTH LIST ADDRESS
	public String list_xaxis_titleClassRegistrationActivity_address = "((//*[name()='g'][@class='apexcharts-xaxis-texts-g'])[4]//*[name()='text'])";

	// CHART MONTH LIST FROM Y-AXIS ADDRESS
	public String list_yaxis__WRT_xaxis_MonthClassRegistrationActivity_address = "(//div[contains(@class,'px-3 py-6 rounded-lg border hover:shadow-inner shadow-lg flex flex-col gap-2')])[4]//*[name()='line'][@class='apexcharts-xaxis-tick']";

	// TO CATCH THE LINE GRAPH DATA BY HOVER ON THE GRAPHS
	public void findClassRegistrationActivityGraphsDataByHover(String xAxisUserValue) throws InterruptedException {
		FindHoverDataOfLineGraphs.findLineGraphYAxisDataBasedOnXAxisDataFromLineGraphByHover(driver,
				list_xaxis_titleClassRegistrationActivity_address, xAxisUserValue,
				list_yaxis__WRT_xaxis_MonthClassRegistrationActivity_address,
				toolTips_Title_ClassRegistrationActivity_Address,
				toolTips_Content_MonthNameClassRegistrationActivity_Address);
	}
	// ======END=============CLASS REGISTRATION ACTIVITY=====================//

	// ======END======PAGE OBJECT FOR ADD DASHBOARD ACTOIN METHODS==========//

	// TO CHECK DASHBOARD STATICS DATA
	public PO_Main_DashboardPage dashboardStatisticsValue(String locationName, String timeDuration)
			throws InterruptedException {
		selectLocation(locationName);
		selectTimeDuration(timeDuration);
		Thread.sleep(5000);

		totalSignUpValue();
		totalRevenueValue();
		totalMembershipsValue();
		totalActiveMembershipsValue();
		totalCanceledMembershipValue();
		totalHoldMembershipsValue();
		totalSuspendedMembershipsValue();
		totalNewMembershipsValue();
		totalClassesAttendedValue();
		avgClassSizeValue();

		softAssert.assertAll();
		return new PO_Main_DashboardPage(driver);
	}

	// TO MOVE OVER OVER THE DASHBOARD BOXES LIST
	public PO_Main_DashboardPage moveOverDashboardListElement(String timeDuration) throws InterruptedException {
		Thread.sleep(2000);
		selectTimeDuration(timeDuration);
		Thread.sleep(3000);

		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 300, false, "");
		moveToClassCancelActivity();
		moveToTotalPaymentActivity();
		moveToPackagePurchageActivity();

		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 300, false, "");
		moveClassRegistrationActivity();
		moveTopCoaches();
		moveTopWorkouts();

		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 300, false, "");
		moveTotalClassesCoacheds();
		moveNewMembers();
		moveNoShow();

		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 300, false, "");
		moveFailedPayments();
		moveFreeTrailUsers();
		moveTrailUsersConversations();

		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 300, false, "");
		moveCanceledMemberships();
		moveCategoryRevenues();

		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 300, false, "");
		softAssert.assertAll();
		return new PO_Main_DashboardPage(driver);
	}

	// TO CHECK CLASS CANCELATION DATA FROM THE GRAPH AS PER MONTH NAME
	public PO_Main_DashboardPage checkClassCancelationDataMonthWise(String timeDuration, String locationName,
			String xAxisUserValue) throws InterruptedException {
		logger.info("Method called: checkClassCancelationDataMonthWise");
		Thread.sleep(3000);
		selectTimeDuration(timeDuration);
		selectLocation(locationName);
		Thread.sleep(3000);
		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 350, false, "");
		findClassCancelActivityGraphsDataByHover(xAxisUserValue);

		Thread.sleep(1000);
		softAssert.assertAll();
		return new PO_Main_DashboardPage(driver);
	}

	// TO CHECK TOTAL PAYMENTS ACTIVITY DATA FROM THE GRAPH AS PER MONTH NAME
	public PO_Main_DashboardPage checkTotalPaymentsActivityDataMonthWise(String timeDuration, String locationName,
			String xAxisUserValue) throws InterruptedException {
		logger.info("Method called: checkTotalPaymentsActivityDataMonthWise");
		Thread.sleep(3000);
		selectTimeDuration(timeDuration);
		selectLocation(locationName);
		Thread.sleep(3000);
		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 350, false, "");
		findTotalPaymentsActivityGraphsDataByHover(xAxisUserValue);

		Thread.sleep(1000);
		softAssert.assertAll();
		return new PO_Main_DashboardPage(driver);
	}

	// TO CHECK PACKAGE PURCHAGE HISTORY DATA FROM THE GRAPH AS PER MONTH NAME
	public PO_Main_DashboardPage checkPakagePurchaseHisoryDataMonthWise(String timeDuration, String locationName,
			String xAxisUserValue) throws InterruptedException {
		logger.info("Method called: checkPakagePurchaseHisoryDataMonthWise");
		Thread.sleep(3000);
		selectTimeDuration(timeDuration);
		selectLocation(locationName);
		Thread.sleep(3000);
		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 350, false, "");
		findPackagePurchaseHistoryGraphsDataByHover(xAxisUserValue);

		Thread.sleep(1000);
		softAssert.assertAll();
		return new PO_Main_DashboardPage(driver);
	}

	// TO CHECK CLASS REGISTRATION ACTIVITY DATA FROM THE GRAPH AS PER MONTH NAME
	public PO_Main_DashboardPage checkClassRegistrationActivityDataMonthWise(String timeDuration, String locationName,
			String xAxisUserValue) throws InterruptedException {
		logger.info("Method called: checkPakagePurchaseHisoryDataMonthWise");
		Thread.sleep(3000);
		selectTimeDuration(timeDuration);
		selectLocation(locationName);
		Thread.sleep(3000);
		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 350, false, "");
		findClassRegistrationActivityGraphsDataByHover(xAxisUserValue);

		Thread.sleep(1000);
		softAssert.assertAll();
		return new PO_Main_DashboardPage(driver);
	}

	// TO CHECK FREE TRAIL USERS
	public PO_Main_DashboardPage findFreeTrialUsers(String timeDuration, String locationName)
			throws InterruptedException {
		selectTimeDuration(timeDuration);
		selectLocation(locationName);
		ScrollPageUpDown.scrollPageUpDown(driver, scrollAbleElement, "down", 400, true, "Free Trial Users");
		moveFreeTrailUsers();
		Thread.sleep(1000);

		ScrollListElement.scrollPageUpDown(driver, list_FreeTrailUser_address);

		softAssert.assertAll();
		return new PO_Main_DashboardPage(driver);
	}
}
