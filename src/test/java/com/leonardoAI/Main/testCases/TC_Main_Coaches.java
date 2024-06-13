package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_CoachesPage;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Coaches extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Coaches() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//mhp = MAIN HOME PAGE
	public PO_Main_CoachesPage m_CoachesP; //mlp = MAIN LOCATION PAGE
	
	//VARIABLES TO CREATE CLASS
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String coachLocation = "WESTWOOD";
	
	//TO FIND COACH FROM THE LIST
	String coachName = "WEST WOOD";
	String searchKey = "WEST WOOD";
	boolean wantToClickOnThreeDot = true;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = false;
	
	//UPDATE COACH
	String emailNew = "westwood@yopmail.com" ;//"faker.internet().emailAddress()";
	String coachLocationNew = "WESTWOOD";
	
	

	//TO INVITE A COACH
	//@Test(priority = 1)
	public void test_Main_InviteCoaches() throws InterruptedException {
		m_CoachesP = callMeBeforePerformAnyAction();
		m_hp = m_CoachesP.inviteCoach(firstName,lastName, email, coachLocation);
	}
	
	//TO UPDATE COACH
	@Test(priority = 2)
	public void test_Main_UpdateCoach() throws InterruptedException {
		test_Main_FindCoachFromListAndClickOnThreeDotButton();
		m_CoachesP.updateCoach(emailNew, coachLocationNew);
	}
		
		
		
	//TO DEACTIVATE COACH
	//@Test(priority = 3)
	public void test_Main_DeactivateCoach() throws InterruptedException {
		test_Main_FindCoachFromListAndClickOnThreeDotButton();
		m_CoachesP.deactivateCoach();
		}
		
	//TO ACTIVATE COACH
	//@Test(priority = 4)
	public void test_Main_ActivateCoach() throws InterruptedException {
		test_Main_FindCoachFromListAndClickOnThreeDotButton();
		m_CoachesP.activateCoach();
	}	
	
	//TO DEACTIVATE COACH
	//@Test(priority =5)
	public void test_Main_resendInvitation() throws InterruptedException {
		test_Main_FindCoachFromListAndClickOnThreeDotButton();
		m_CoachesP.resendInvitation();
		}
		
	//TO ACTIVATE COACH
	//@Test(priority = 6)
	public void test_Main_CancelInvitation() throws InterruptedException {
		test_Main_FindCoachFromListAndClickOnThreeDotButton();
		m_CoachesP.cancelInvitation();
	}
		
		
	//TO FIND COACH AND CLICK ON THREE DOT BUTTON
	//@Test(priority = 10)
	public void test_Main_FindCoachFromListAndClickOnThreeDotButton() throws InterruptedException {
		m_CoachesP = callMeBeforePerformAnyAction();
		m_CoachesP.findCoachFromListAndClickOnThreeDotButton(coachName,coachLocation, searchKey,wantToClickOnThreeDot, searchKeyColumnIndex,  wantToClickOnSearchKey);
	}
		
		
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_CoachesPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabCoaches();
		Thread.sleep(5000);
		return new PO_Main_CoachesPage(driver);	
	}
	
}
