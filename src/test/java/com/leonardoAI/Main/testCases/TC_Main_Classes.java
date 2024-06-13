package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_ClassesPage;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_PackagesPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Classes extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Classes() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//mhp = MAIN HOME PAGE
	public PO_Main_PackagesPage m_pp;	//mpp = MAIN PACKAGE PAGE
	public PO_Main_ClassesPage m_cp; //mlp = MAIN LOCATION PAGE
	
	//VARIABLES TO CREATE CLASS
	String className = "Class "+faker.name().title();
	String classLocation = "Westwood";
	String coachName = "west wood";
	String classCapacity = "20";
	String cancelationCutOffTime = "2";
	String waitListSpot = "10";
	String description = faker.lorem().paragraph();
	String classStartDate = "12 September 2023";
	String classEndDate = "10 October 2023";
	String dayName = "Monday";
	String hours = "10";
	String minutes = "30";
	String AmPm = "AM";
	
	
	//TO FIND CLASSES
	String classLocation2 = "WESTWOOD";
	String coachName2 = "WEST WOOD";
	String SearchKey_Classes = "WESTWOOD_CANCELATION TIME IS ZERO";
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnThreeDot = true;
	boolean wantToclickOnFindSearckKey = false;
	
	//TO ADD MEMBER IN THE CLASS
	String searchKey_memberEmail = "susan_2@yopmail.com";
	String dateValue = "03 October 2023";
	String  eventKey = "3:00 PM";
	
	//VIEW CLASS REGISTERED USER DETAILS
	String SearchKey_ClassRegisteredUser = "susan_2 adfsadf";
	int searchKeyColumnIndex_ClassRegisteredUser = 2;
	boolean wantToClickOnThreeDot_ClassRegisteredUser = true;
	boolean wantToclickOnFindSearckKey_ClassRegisteredUser = false;
	
	//TO CANCEL CLASS REASON
	String cancelClassReason = faker.lorem().paragraph();
	
	
	
	
	
	//TO ADD CLASS
	//@Test(priority = 1)
	public void test_Main_AddClass() throws InterruptedException {
		m_cp = callMeBeforePerformAnyAction();
		m_hp = m_cp.addClass(className,classLocation, coachName, classCapacity,cancelationCutOffTime, waitListSpot, description, classStartDate,classEndDate,dayName,hours,minutes,AmPm);
	}
	
	//TO DEACTIVATE TEMPLATE
	//@Test(priority = 2)
	public void test_Main_DeActivateClasses() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.deActivateClasses();
	}
	
	//TO ACTIVATE TEMPLATE
	//@Test(priority = 3)
	public void test_Main_ActivateClasses() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.activateClasses();
	}
		
		
	//TO ARCHIVE TEMPLATE
	//@Test(priority = 4)
	public void test_Main_ArchiveClasses() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.archiveClasses();
	}

	//TO RESTORE TEMPLATE
	//@Test(priority = 5)
	public void test_Main_RestoreClasses() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.restoreClasses();
	}
		
	//TO VIEW CLASS CALENDAR
	//@Test(priority = 6)
	public void test_Main_CalendarClasses() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.calendarClasses();
	}
	
	//TO VIEW CLASS CALENDAR AND ADD MEMBER IN THE CLASS
	//@Test(priority = 7)
	public void test_Main_AddMemberInTheClasses() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.addMemberInClass(searchKey_memberEmail,dateValue, eventKey);
	}
		
	//TO VIEW CLASS REGISTERED USER DETAILS
	//@Test(priority = 8)
	public void test_Main_ViewClassRegisteredUserDetails() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.veiwClassRegisteredMemberDetails(searchKey_memberEmail,dateValue, eventKey,SearchKey_ClassRegisteredUser, searchKeyColumnIndex_ClassRegisteredUser, wantToClickOnThreeDot_ClassRegisteredUser,wantToclickOnFindSearckKey_ClassRegisteredUser);

	}
		
	//REOMVE USERS FROMS THE REGISTERED CLASS
	//@Test(priority = 9)
	public void test_Main_RemovedRegisteredUsersFromClass() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.removeUsersFromRegisteredClass(searchKey_memberEmail,dateValue, eventKey,SearchKey_ClassRegisteredUser, searchKeyColumnIndex_ClassRegisteredUser, wantToClickOnThreeDot_ClassRegisteredUser,wantToclickOnFindSearckKey_ClassRegisteredUser);

	}	
		
	//CANCEL THE REGISTERED CLASS
	//@Test(priority = 10)
	public void test_Main_CancelScheduleClass() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.cancelScheduleClass(dateValue, eventKey, cancelClassReason);

	}
		
	//BLACKOUT THE SCHEDULED CLASS
	//@Test(priority = 11)
	public void test_Main_BlackoutScheduleClass() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.blackOutScheduleClass(dateValue, eventKey);

	}	
	
	//BLACKOUT THE SCHEDULED CLASS
	//@Test(priority = 11)
	public void test_Main_RemoveClassFromBlackout() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.removeClassFromBlackout(dateValue, eventKey);

	}	
	
	//OVERRIDE A CLASS
	@Test(priority = 12)
	public void test_Main_OverrideClass() throws InterruptedException {
		test_Main_FindClassesFromListAndClickOnThreedotButton();
		m_cp.overrideClass(dateValue, eventKey,coachName,classCapacity,cancelationCutOffTime, description, waitListSpot);
	}
		
		
		
	
	
	//TO FIND CLASSES AND CLICK ON THE THREE DOT BUTTON
	//@Test(priority = 15)
	public void test_Main_FindClassesFromListAndClickOnThreedotButton() throws InterruptedException {
		m_cp = callMeBeforePerformAnyAction();
		m_cp.findClassesAndClickOnThreeDot(SearchKey_Classes,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey,coachName2, classLocation2);
	}
		
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_ClassesPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabClasses();
		Thread.sleep(5000);
		return new PO_Main_ClassesPage(driver);	
	}
	
}
