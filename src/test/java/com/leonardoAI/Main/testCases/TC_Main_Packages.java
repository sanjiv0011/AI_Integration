package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_PackagesPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Packages extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Packages() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//m_hp = MAIN HOME PAGE
	public PO_Main_PackagesPage m_pp;	//m_pp = MAIN PACKAGE PAGE
	
	//VARIABLES TO CREATE PACKAGE CATEGORY
	String packageCategoryTitle = "Economy Category";  //faker.name().title();
	String packageCategoryInternalTitle = faker.company().name();
	String packageCategoryDescription = faker.lorem().paragraph();
	String categoryLocation = "Westwood";
	String wantToMarkCategoryHidden = "No";
	
	
	//VARIABLES TO CREATE PACKAGE
	String packageName = "LEGACY IMPLEMENTATION ORCHESTRATOR_2"; //faker.name().title();
	String packageLocation = "WESTWOOD"; //categoryLocation;
	String packageCategory = "Dicki-Turner"; //packageCategoryTitle; 
	String packgeDescription = faker.lorem().paragraph();
	String wantToInternalUseOnly = "No";
	String chargeInterval = "Monthly"; //One-Time
	String totalClasses = String.valueOf(faker.number().numberBetween(30, 60));
	String miniumDurationInMonth = String.valueOf(faker.number().digit());
	String regularPrice = String.valueOf(faker.number().numberBetween(100, 200));
	String packagedisclaimers = faker.lorem().paragraph();

	//FIND PACKAGE FROM THE LIST
	String packageTitle = "Westwood_Package_02";
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnThreeDot = true;
	String locationName = "WESTWOOD";
	String packageStatus = "ALL";
	
	//PACKAGE BUYERS USERS DETAILS
	String packageBuyersEmail = "ab12@yopmail.com"; 
	int packageBuyersSearchKeyColumnIndex = 2; 
	boolean packageBuyersWantToClickOnThreeDot = false;
	boolean packageBuyersWantToclickOnFindSearckKey = true;
	
	//PACKAGE CATEGORY
	int packageCategorySearchKeyColumnIndex = 1;
	boolean packageCategoryWantToClickOnThreeDot = true;
	boolean packageCategoryWantToclickOnFindSearckKey = false;
	
	
	
		//TO ADD PACKAGE CATEGORY
		//@Test(priority = 1)
		public void test_Main_AddPackageCategory() throws InterruptedException {
			m_pp = callMeBeforePerformAnyAction();
			m_hp = m_pp.addAndUpdatePackageCategory(packageCategoryTitle,packageCategoryInternalTitle,packageCategoryDescription,categoryLocation,wantToMarkCategoryHidden);
		}
		
		
		//TO ADD PACKAGE
		//@Test(priority = 2)
		public void test_Main_AddPackage() throws InterruptedException {
			m_pp = callMeBeforePerformAnyAction();
			m_hp = m_pp.addAndUpdatePackage(packageName,packageLocation,packageCategory,packgeDescription,wantToInternalUseOnly,chargeInterval,totalClasses,miniumDurationInMonth, regularPrice,packagedisclaimers);
		}
		
		
		
		//TO UPDATE PACKAGE CATEGORY
		//@Test(priority = 3)
		public void test_Main_UpdatePackageCategory() throws InterruptedException {
			test_Main_FindPackageCategoryFromListAndClickOnThreedotButton();
			m_hp = m_pp.addAndUpdatePackageCategory(packageCategoryTitle,packageCategoryInternalTitle,packageCategoryDescription,categoryLocation,wantToMarkCategoryHidden);
		}
	
	
		//TO UPDATE PACKAGE 
		//@Test(priority = 4)
		public void test_Main_UpdatePackage() throws InterruptedException {
			test_Main_FindPackageFromListAndClickOnThreedotButton();
			m_hp = m_pp.addAndUpdatePackage(packageName,packageLocation,packageCategory,packgeDescription,wantToInternalUseOnly,chargeInterval,totalClasses,miniumDurationInMonth, regularPrice,packagedisclaimers);
		}
		
		//TO DEACTIVATE PACKAGE
		@Test(priority = 5)
		public void test_Main_DeActivatePackage() throws InterruptedException {
			test_Main_FindPackageFromListAndClickOnThreedotButton();
			m_pp.deActivatePackage();
		}
		
		//TO ACTIVATE PACKAGE
		@Test(priority = 6)
		public void test_Main_ActivatePackage() throws InterruptedException {
			test_Main_FindPackageFromListAndClickOnThreedotButton();
			m_pp.activatePackage();
		}
			
			
		//TO ARCHIVE PACKAGE
		@Test(priority = 7)
		public void test_Main_ArchivePackage() throws InterruptedException {
			test_Main_FindPackageFromListAndClickOnThreedotButton();
			m_pp.archivePackage();
		}
	
		//TO RESTORE PACKAGE
		@Test(priority = 8)
		public void test_Main_RestorePackage() throws InterruptedException {
			test_Main_FindPackageFromListAndClickOnThreedotButton();
			m_pp.restorePackage();
		}
		
		
		//TO VIEW REPORT PACKAGE
		//@Test(priority = 9)
		public void test_Main_ViewPackageReport() throws InterruptedException {
			test_Main_FindPackageFromListAndClickOnThreedotButton();
			m_pp.viewPackageReport();
		}
		//TO VIEW PACKAGE BUYERS USERS DETAILS
		//@Test(priority = 10, dependsOnMethods = "test_Main_ViewPackageReport")
		public void test_Main_ViewPackageBuyersUserDetails() throws InterruptedException {
			m_pp.findPackageBuyersUserListAndViewUsersDetails(packageBuyersEmail,packageBuyersSearchKeyColumnIndex,packageBuyersWantToClickOnThreeDot,packageBuyersWantToclickOnFindSearckKey);
		}
			
	
	
		//TO FIND PACKAGE AND CLICK ON THE THREE DOT BUTTON
		//@Test(priority = 11)
		public void test_Main_FindPackageFromListAndClickOnThreedotButton() throws InterruptedException {
			m_pp = callMeBeforePerformAnyAction();
			m_pp.findPackageAndClickOnThreeDot(packageTitle,searchKeyColumnIndex,wantToClickOnThreeDot,packageLocation,packageStatus, packageBuyersWantToclickOnFindSearckKey);
		}
		
		//TO FIND PACKAGE CATEGORY AND CLICK ON THE THREE DOT BUTTON
		//@Test(priority = 12)
		public void test_Main_FindPackageCategoryFromListAndClickOnThreedotButton() throws InterruptedException {
			m_pp = callMeBeforePerformAnyAction();
			m_pp.findPackageCategoryAndClickOnThreeDot(packageCategoryTitle,packageCategorySearchKeyColumnIndex,packageCategoryWantToClickOnThreeDot,packageLocation,packageCategoryWantToclickOnFindSearckKey);
		}
			
		//TO DEACTIVATE PACKAGE CATEGORY
		//@Test(priority = 13)
		public void test_Main_DeActivatePackageCategory() throws InterruptedException {
			test_Main_FindPackageCategoryFromListAndClickOnThreedotButton();
			m_pp.deActivatePackageCategory();
		}
		
		//TO ACTIVATE PACKAGE CATEGORY
		//@Test(priority = 14)
		public void test_Main_ActivatePackageCategory() throws InterruptedException {
			test_Main_FindPackageCategoryFromListAndClickOnThreedotButton();
			m_pp.activatePackageCategory();
		}
			
			
		//TO ARCHIVE PACKAGE CATEGORY
		//@Test(priority = 15)
		public void test_Main_ArchivePackageCategory() throws InterruptedException {
			test_Main_FindPackageCategoryFromListAndClickOnThreedotButton();
			m_pp.archivePackageCategory();
		}
		
		//TO RESTORE PACKAGE CATEGORY
		//@Test(priority = 16)
		public void test_Main_RestorePackageCategory() throws InterruptedException {
			test_Main_FindPackageCategoryFromListAndClickOnThreedotButton();
			m_pp.restorePackageCategory();
		}
		
		
	
		
		//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
		public PO_Main_PackagesPage callMeBeforePerformAnyAction() throws InterruptedException {
			//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
			m_hp = new PO_Main_HomePage(driver);
			m_hp.clickOntabDashboard();
			m_hp.clickOntabPackages();
			Thread.sleep(5000);
			return new PO_Main_PackagesPage(driver);	
		}
	
}
