package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_DashboardPage;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Dashboard extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_Main_Dashboard() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_LoginPage lp; // lp = LOGIN PAGE
	public PO_HomePage hp; // hp = HOME PAGE
	public Faker faker = new Faker();
	public PO_Main_HomePage m_hp; // m_hp = MAIN HOME PAGE
	public PO_Main_DashboardPage m_dp; // m_dp = MAIN DASHBOARD PAGE

	// VARIABLES TO DASHBOARD
	String locationName = ""; // "", null;
	String timeDuration = "This Year";
	String monthWithYear = ""; // "Jul '23"; //

	// TO CHECK DAHS BOARD ANALYTICS VALUES
	// @Test(priority = 1)
	public void test_Main_DashboardStasticsValues() throws Throwable {
		m_dp = callMeBeforePerformAnyAction();
		m_dp.dashboardStatisticsValue(locationName, timeDuration);
	}

	// TO MOVE OVER THE DASHBOARD ANALYTICS ELEMENT
	// @Test(priority = 2)
	public void test_Main_MoveOverDashboardElement() throws Throwable {
		m_dp = callMeBeforePerformAnyAction();
		m_dp.moveOverDashboardListElement(timeDuration);
	}

	// TO CHECK CLASS CANCELATION DATA FROM THE GRAPH MONTH WISE
	// @Test(priority = 3)
	public void test_Main_CheckClassCancelationDataFromGraphMonthWise() throws Throwable {
		m_dp = callMeBeforePerformAnyAction();
		m_dp.checkClassCancelationDataMonthWise(timeDuration, locationName, monthWithYear);
	}

	// TO CHECK TOTAL PAYMENTS ACTIVITY DATA FROM THE GRAPH MONTH WISE
	//@Test(priority = 4)
	public void test_Main_CheckTotalPaymentsActivityDataFromGraphMonthWise() throws Throwable {
		m_dp = callMeBeforePerformAnyAction();
		m_dp.checkTotalPaymentsActivityDataMonthWise(timeDuration, locationName, monthWithYear);
	}

	// TO CHECK PACKAGE PURCHASE ACTIVITY DATA FROM THE GRAPH MONTH WISE
	//@Test(priority = 5)
	public void test_Main_CheckPackagePurchaseHistoryDataFromGraphMonthWise() throws Throwable {
		m_dp = callMeBeforePerformAnyAction();
		m_dp.checkPakagePurchaseHisoryDataMonthWise(timeDuration, locationName, monthWithYear);
	}

	// TO CHECK CLASS REGISTRATION ACTIVITY DATA FROM THE GRAPH MONTH WISE
	//@Test(priority = 6)
	public void test_Main_CheckClassRegistrationActivityDataFromGraphMonthWise() throws Throwable {
		m_dp = callMeBeforePerformAnyAction();
		m_dp.checkClassRegistrationActivityDataMonthWise(timeDuration, locationName, monthWithYear);
	}

	//TO CHECK FREE TRAIL USERS
	@Test(priority = 7)
	public void test_Main_findFreeTrailUser() throws Throwable {
		m_dp = callMeBeforePerformAnyAction();
		m_dp.findFreeTrialUsers(timeDuration, locationName);
	}

	
	

	// CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_DashboardPage callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		Thread.sleep(5000);
		return new PO_Main_DashboardPage(driver);
	}

}
