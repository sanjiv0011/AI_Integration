package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_Locations;
import com.leonardoAI.Main.pageObject.PO_Main_PackagesPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Locations extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Locations() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//m_hp = MAIN HOME PAGE
	public PO_Main_PackagesPage m_pp;	//m_pp = MAIN PACKAGE PAGE
	public PO_Main_Locations m_lp; //m_lp = MAIN LOCATION PAGE
	
	//VARIABLES TO CREATE REGIONS
	String regionName = "WESTWOOD"; //faker.address().cityName();
	String parentRegion = "WESTWOOD";
	String regionCode = faker.random().hex(3);
	String regionDescription = faker.lorem().paragraph();
	
	
	
	//VARIABLES TO CREATE LOCATIONS
	String locationName = "WESTWOOD"; //regionName;
	String locationInternalName = "WESTWOOD"; //regionName;
	String locationRegionName = "WESTWOOD"; //"Jefferyview"; //"Dicki-Turner";
	String locatoinCode = randomStringNumber(5,6);
	String locationDescription = faker.lorem().paragraph();
	String addressLine1 = faker.address().fullAddress();
	String addressLine2 = faker.address().secondaryAddress();
	String city = faker.address().cityName();
	String postalCode = String.valueOf(faker.number().digits(6));
	String stateName = "West Virginia";
	String locationEmail = faker.internet().emailAddress();
	String locationPhoneNumber = "1"+String.valueOf(faker.number().digits(9));
	String locationVitalsDescription = faker.lorem().paragraph();
	String timeZone = faker.address().timeZone();
	String p360Shares = faker.number().digits(1);
	String wantEnableNoShow = "Yes";
	String noShowFee = faker.number().digits(1);
	
	//VARAIBLE FOR SEARCH REGION/LOCATION FROM THE LIST
	String searchKeyLocationName = "WESTWOOD";
	String searchKeyRegionName = "WESTWOOD";
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnThreeDot = true;
	boolean wantToclickOnFindSearckKey = false;

	
	
	
	//TO ADD REGIONS
	//@Test(priority = 1)
	public void test_Main_AddRegion() throws InterruptedException {
		m_lp = callMeBeforePerformAnyAction();
		m_hp = m_lp.addAndUpdateRegion(regionName,parentRegion,regionCode,regionDescription);
	}
	
	
	//TO ADD LOCATIONS
	//@Test(priority = 2)
	public void test_Main_AddLocation() throws InterruptedException {
		m_lp = callMeBeforePerformAnyAction();
		m_hp = m_lp.addAndUpdateLocation(locationName,locationInternalName,locationRegionName,locatoinCode,locationDescription,addressLine1,addressLine2,city, postalCode,stateName,locationEmail,locationPhoneNumber,locationVitalsDescription,timeZone,p360Shares,wantEnableNoShow,noShowFee);
	}
	
	
	//TO FIND ANY SPECIFIC LOCATIONS FROM THE LIST AND CLICK ON THE VIEW DETAILS ACTION BUTTON
	@Test(priority = 3)
	public void test_Main_SearchAndViewLocationDetails() throws Throwable {
		m_lp = callMeBeforePerformAnyAction();
		m_lp.findLocatoinAndViewDetails(searchKeyLocationName,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
	}
	
	//TO FIND ANY SPECIFIC LOCATIONS FROM THE LIST UPDATE IT
	//@Test(priority = 4)
	public void test_Main_UpdateLocatoin() throws Throwable {
		m_lp = callMeBeforePerformAnyAction();
		boolean bol = m_lp.findAndUpdateLocation(searchKeyLocationName,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
		if(bol) {
			m_hp = m_lp.addAndUpdateLocation(locationName,locationInternalName,locationRegionName,locatoinCode,locationDescription,addressLine1,addressLine2,city, postalCode,stateName,locationEmail,locationPhoneNumber,locationVitalsDescription,timeZone,p360Shares,wantEnableNoShow,noShowFee);
		}else {
			logger.info("Not clicked on the change location button");
		}
	}
		
		
	//TO FIND ANY SPECIFIC LOCATIONS FROM THE LIST AND CLICK ON THE VIEW DETAILS ACTION BUTTON
	//@Test(priority = 5)
	public void test_Main_SearchAndViewRegionDetails() throws Throwable {
		m_lp = callMeBeforePerformAnyAction();
		m_lp.findRegionAndViewDetails(searchKeyRegionName,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
	}
		
	
	//TO FIND AND UPDATE ANY SPECIFIC REGIONS FROM THE LIST
	//@Test(priority = 6)
	public void test_Main_UpdateRegion() throws Throwable {
		m_lp = callMeBeforePerformAnyAction();
		boolean bol = m_lp.findAndUpdateRegion(searchKeyRegionName,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
		if(bol) {
			m_hp = m_lp.addAndUpdateRegion(regionName,parentRegion,regionCode,regionDescription);
		}else {
			logger.info("Not clicked on the change region button");
		}
	}
	
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_Locations callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabLocations();
		Thread.sleep(5000);
		return new PO_Main_Locations(driver);	
	}
	
}
