package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_WorkoutsPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Workouts extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Workouts() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//m_hp = MAIN HOME PAGE
	public PO_Main_WorkoutsPage m_wp; //m_Wp = MAIN WORKOUT PAGE
	
	//VARIABLES TO ADD WORKOUT
	String workoutName = "Westwook workout "+faker.name().firstName();
	String workoutMemberDescription = "MemberDescription: "+faker.lorem().paragraph();
	String workoutCaochDescription = "CoachDescription: "+faker.lorem().paragraph();
	String workoutPublishDate = "5 October 2023";
	String workoutLink = faker.internet().url();
	
	
	//TO FIND WORKOUT FROM THE LIST
	String workoutTitle = "WESTWOOK WORKOUTCHERISE";
	String searchKey = "WESTWOOK WORKOUTCHERISE";
	boolean wantToClickOnThreeDot = true;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = false;
	
	//ASSIGN WORKOUT TO THE DATE
	String dateValue = "10 October 2023" ;
	String wantToClickOnDateOrDateBox = "dateBox";
	String assingWorkoutName = "Westwook workoutCherise";
	
	//REMOVE ASSIGNED WORKOUT FROM THE DATE
	String dateValue_removedWorkout = "10 October 2023";
	String wantToClickOnDateOrDateBox_removedWorkout = "dateBox";
	String workoutName_removedWorkout = "Westwook workoutCherise";
	String searchKey_removedWorkout = "Westwook workoutCherise";
	int searchKeyColumnIndex_removedWorkout = 1;
	boolean wantToClickOnDeleteBox_removedWorkout = true;
	boolean wantToclickOnFindSearckKey_removedWorkout = false;
	
	
	//TO ADD WORKOUT
	@Test(priority = 1)
	public void test_Main_AddWorkout() throws Throwable {
		m_wp = callMeBeforePerformAnyAction();
		m_wp.addOrChangeWorkout(workoutName,workoutMemberDescription, workoutCaochDescription, workoutPublishDate,workoutLink);
	}
	
	//TO UPDATE/CHANGE WORKOUT
	//@Test(priority = 2)
	public void test_Main_UpdateWorkout() throws Throwable {
		test_Main_FindWorkoutFromListAndClickOnThreeDotButton();
		m_wp.addOrChangeWorkout(workoutName,workoutMemberDescription, workoutCaochDescription, workoutPublishDate,workoutLink);
	}
		
		
		
	//TO DEACTIVATE WORKOUT
	//@Test(priority = 3)
	public void test_Main_DeactivateWorkout() throws InterruptedException {
		test_Main_FindWorkoutFromListAndClickOnThreeDotButton();
		m_wp.deactivateWorkout();
	}
		
	//TO ACTIVATE WORKOUT
	//@Test(priority = 4)
	public void test_Main_ActivateWorkout() throws InterruptedException {
		test_Main_FindWorkoutFromListAndClickOnThreeDotButton();
		m_wp.activateWorkout();
	}	
	
	//TO ASSIGN WORKOUT TO THE DATE
	//@Test(priority = 5)
	public void test_Main_AssignWorkoutToDate() throws InterruptedException {
		m_wp = callMeBeforePerformAnyAction();
		m_wp.assignWorkoutToDate(dateValue,wantToClickOnDateOrDateBox,assingWorkoutName);
	}
		

	//TO REMOVED ASSIGN WORKOUT FROM THE DATE
	//@Test(priority = 6)
	public void test_Main_removedAssignedWorkoutFromDate() throws InterruptedException {
		m_wp = callMeBeforePerformAnyAction();
		m_wp.removeWorkoutFromDate(dateValue_removedWorkout,wantToClickOnDateOrDateBox_removedWorkout,workoutName_removedWorkout,searchKey_removedWorkout,searchKeyColumnIndex_removedWorkout, wantToClickOnDeleteBox_removedWorkout, wantToclickOnFindSearckKey_removedWorkout);
	}
	
	
	
	
	//TO FIND WORKOUT AND CLICK ON THREE DOT BUTTON
	//@Test(priority = 10)
	public void test_Main_FindWorkoutFromListAndClickOnThreeDotButton() throws InterruptedException {
		m_wp = callMeBeforePerformAnyAction();
		m_wp.findWorkoutFromListAndClickOnThreeDotButton(workoutTitle, searchKey,wantToClickOnThreeDot, searchKeyColumnIndex,  wantToClickOnSearchKey);
	}
		
		
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_WorkoutsPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabWorkouts();
		Thread.sleep(5000);
		return new PO_Main_WorkoutsPage(driver);	
	}
	
}
