package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_MovementsPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Movements extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Movements() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//m_hp = MAIN HOME PAGE
	public PO_Main_MovementsPage m_mp; //m_mp = MAIN MOVEMENT PAGE
	
	//VARIABLES TO ADD MOVEMENT
	String movementName = "Westwook movement "+faker.name().firstName();
	String movementDescription = "movementDescription: "+faker.lorem().paragraph();
	boolean wantToAllowTracking = true;
	boolean wantToAllowModifiedTracking = true;
	boolean hieght = true;
	boolean weight = true;
	boolean reps = true;
	boolean distance = true;
	boolean time = true;
	boolean score = true;
	boolean rounds = true;
	boolean tonnage = true;
	
	
	//TO FIND MOVEMENT FROM THE LIST
	String movementTitle = "WESTWOOK MOVEMENT CONCEPCION";
	String searchKey = "WESTWOOK MOVEMENT CONCEPCION";
	boolean wantToClickOnThreeDot = true;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = false;
	
	//ASSIGN MOVEMENT TO THE DATE
	String dateValue = "17 October 2023" ;
	String wantToClickOnDateOrDateBox = "dateBox";
	String assingMovementName = "Westwook movement Concepcion";
	
	//REMOVE ASSIGNED MOVEMENT FROM THE DATE
	String dateValue_removedMovement = "17 October 2023";
	String wantToClickOnDateOrDateBox_removedMovement = "dateBox";
	String workoutName_removedMovement = "Westwook movement Concepcion";
	String searchKey_removedMovement = "Westwook movement Concepcion";
	int searchKeyColumnIndex_removedMovement = 1;
	boolean wantToClickOnDeleteBox_removedMovement = true;
	boolean wantToclickOnFindSearckKey_removedMovement = false;
	
	
	//TO ADD MOVEMENT
	//@Test(priority = 1)
	public void test_Main_AddMovement() throws Throwable {
		m_mp = callMeBeforePerformAnyAction();
		System.out.println("movementName: "+movementName);
		m_mp.addOrChangeMovement(movementName,movementDescription,wantToAllowTracking, wantToAllowModifiedTracking,hieght, weight, reps,distance,time,score,rounds,tonnage);
	}
	
	//TO UPDATE/CHANGE WORKOUT
	//@Test(priority = 2)
	public void test_Main_UpdateMovement() throws Throwable {
		test_Main_FindMovementFromListAndClickOnThreeDotButton();
		m_mp.addOrChangeMovement(movementName,movementDescription,wantToAllowTracking, wantToAllowModifiedTracking,hieght, weight, reps,distance,time,score,rounds,tonnage);
	}
		
		
		
	//TO DEACTIVATE MOVEMENT
	//@Test(priority = 3)
	public void test_Main_DeactivateMovement() throws InterruptedException {
		test_Main_FindMovementFromListAndClickOnThreeDotButton();
		m_mp.deactivateMovement();
	}
		
	//TO ACTIVATE MOVEMENT
	//@Test(priority = 4)
	public void test_Main_ActivateMovement() throws InterruptedException {
		test_Main_FindMovementFromListAndClickOnThreeDotButton();
		m_mp.activateMovement();
	}	
	
	//TO ASSIGN MOVEMENT TO THE DATE
	@Test(priority = 5)
	public void test_Main_AssignMovementToDate() throws InterruptedException {
		m_mp = callMeBeforePerformAnyAction();
		m_mp.assignMovementToDate(dateValue,wantToClickOnDateOrDateBox,assingMovementName);
	}
		

	//TO REMOVED ASSIGN MOVEMENT FROM THE DATE
	@Test(priority = 6)
	public void test_Main_removedAssignedMovementFromDate() throws InterruptedException {
		m_mp = callMeBeforePerformAnyAction();
		m_mp.removeMovementFromDate(dateValue_removedMovement,wantToClickOnDateOrDateBox_removedMovement,workoutName_removedMovement,searchKey_removedMovement,searchKeyColumnIndex_removedMovement, wantToClickOnDeleteBox_removedMovement, wantToclickOnFindSearckKey_removedMovement);
	}
	
	
	
	
	//TO FIND MOVEMENT AND CLICK ON THREE DOT BUTTON
	//@Test(priority = 10)
	public void test_Main_FindMovementFromListAndClickOnThreeDotButton() throws InterruptedException {
		m_mp = callMeBeforePerformAnyAction();
		m_mp.findMovementFromListAndClickOnThreeDotButton(movementTitle, searchKey,wantToClickOnThreeDot, searchKeyColumnIndex,  wantToClickOnSearchKey);
	}
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_MovementsPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabMovement();
		Thread.sleep(5000);
		return new PO_Main_MovementsPage(driver);	
	}
	
}
