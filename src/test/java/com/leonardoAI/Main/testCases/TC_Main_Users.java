package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_UsersPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Users extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Users() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;
	public PO_HomePage hp;
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;
	public PO_Main_UsersPage m_up;
	
	
	//VARIABLES
	String firstName = "OTPUser";
	String lastName = faker.name().lastName();
	String phoneNumber = "1234567890";
	String emailAdd = faker.internet().emailAddress();
	String location = "WESTWOOD";
	String packageName = "westwood Categories (westwood)";
	String membershipName = "Westwood_Package_02";
	String membershipStartDate = "22 September 2023";
	
	//TO SEARCH USER AND VIEW DETAILS
	String searchKeyuserNameOrEmail = "SUSAN4 DAVIS4";
	String regionName = "WESTWOOD";
	boolean wantToClickOnUser = true;
	int listActionIndex = 1;
	int searchKeyColumnIndex = 1;
	
	//TO PAUSE MEMBERSHIP
	String pauseStartDate = "20 September 2023";
	String pauseEndDate = "30 September 2023";
	String pauseReason = "Travel";
	
	//TO CHANGE EMAIL
	String confirmNewEmail = "susandavis6@yopmail.com";
	String newEmail = "susandavis6@yopmail.com";
	
	//TO CREATE AND ASSIGN USER LABELS
	String userLabel = "MAXWELL";
	String newUserLabelName = "UserLabel4";
	boolean wantToCreateNewLabel = true;
	
	//TO CANCEL MEMBERSHIP
	String CancelmembershipCustomDate = "17 October 2023";
	String description = faker.lorem().paragraph();
	boolean wantToSelectCustomDate = true;
	
	//TO CHANGE MEMBERS CREDIT
	String creditStartDate= "25 September 2023";
	String creditEndDate= "30 October 2023";
	String totalCredit= String.valueOf(faker.number().numberBetween(50, 100));
	String usedCredit= String.valueOf(faker.number().digits(2));
	String comment= faker.lorem().paragraph();
	String searchKey= "Sep 20, 2023 - Oct 18, 2023";
	boolean wantToClickOnThreeDot = true;
	int searchKeyColumnIndexMemberCredit = 3;
	
	//SEN INVOICE
	String searchKeyPaymentHistory = "Sep 13, 2023";
	int searchKeyColumnIndexPaymentHistory = 3;
	boolean wantToClickOnThreeDotPaymentHistory = true;
	boolean wantToclickOnFindSearckKey = false;
	
	
	
	
	//==========START TEST CASES=============//
	
	//TO ADD MEMBER
	//@Test(priority = 1)
	public void test_Main_AddMember() throws Throwable {
		m_up = callMeBeforePerformAnyAction();
		m_hp = m_up.addMember(firstName, lastName, phoneNumber, emailAdd, location, packageName, membershipName, membershipStartDate);
	}
	
	
	
	//TO PAUSE THE USERS MEMBERSHIP
	//@Test(priority = 2)
	public void test_Main_PauseMembership() throws Throwable {
		searchAndViewUsersDetails();
		m_hp = m_up.pauseMembership(pauseStartDate, pauseEndDate, pauseReason);
	}
	
	
	//TO RESUME THE USERS MEMBERSHIP
	//@Test(priority = 3)
	public void test_Main_ResumeMembership() throws Throwable {
		searchAndViewUsersDetails();
		m_hp = m_up.resumeMembership();
	}
	
	//TO VIEW AGREED TERMS AND CONDITIONS
	//@Test(priority = 4)
	public void test_Main_ViewAgreedConditions() throws Throwable {
		searchAndViewUsersDetails();
		m_up.checkAgreedTerm();
	}
	
	//TO CHANGE EMAIL
	//@Test(priority = 5)
	public void test_Main_ChangeEmail() throws Throwable {
		searchAndViewUsersDetails();
		m_up.changeEmail(newEmail,confirmNewEmail);
	}
	
	//TO ASSIGN LABEL TO THE USERS
	//@Test(priority = 6)
	public void test_Main_UserLabelAssignment() throws Throwable {
		searchAndViewUsersDetails();
		m_up.userLabelAssignment(userLabel);
	}
		
	//TO CREATE USER LABLES
	//@Test(priority = 7)
	public void test_Main_CreateUserLabel() throws Throwable {
		searchAndViewUsersDetails();
		m_up.createUserLabel(newUserLabelName);
	}
		
	//TO UNLOCK USER ACCOUNT
	@Test(priority = 8)
	public void test_Main_UnlockUserAccount() throws Throwable {
		searchAndViewUsersDetails();
		m_up.unlockUserAccount();
	}
	
	//TO SUSPENDS USER ACCOUNT
	//@Test(priority = 9)
	public void test_Main_SuspendUserAccount() throws Throwable {
		searchAndViewUsersDetails();
		m_up.suspendsAccount();
	}
		
	//TO CHANGE MEMBERSHIP
	//@Test(priority = 10)
	public void test_Main_ChangeMembership() throws Throwable {
		searchAndViewUsersDetails();
		m_up.changeMembership(packageName, membershipName);
	}	
	
	//TO CANCEL MEMBERSHIP
	//@Test(priority = 11)
	public void test_Main_CancelMembership() throws Throwable {
		searchAndViewUsersDetails();
		m_up.cancelMembership(CancelmembershipCustomDate, description, wantToSelectCustomDate);
	}	
	
	
	//TO RENEW MEMBERSHIP
	//@Test(priority = 12)
	public void test_Main_RenewMembership() throws Throwable {
		searchAndViewUsersDetails();
		m_up.renewMembership(location, packageName, membershipName,membershipStartDate);
	}	
		
	//TO CHANGE MEMBER CREDIT
	//@Test(priority = 13)
	public void test_Main_ChangeMemberCredit() throws Throwable {
		searchAndViewUsersDetails();
		m_up.changeMemberCredit(creditStartDate, creditEndDate, totalCredit,usedCredit, comment,searchKey, searchKeyColumnIndexMemberCredit,wantToClickOnThreeDot,wantToclickOnFindSearckKey);
	}
	
	
	//TO SEND INVOICE
	//@Test(priority = 14)
	public void test_Main_SendInvoice() throws Throwable {
		searchAndViewUsersDetails();
		m_up.sendInvoice(searchKeyPaymentHistory, searchKeyColumnIndexPaymentHistory,wantToClickOnThreeDotPaymentHistory,wantToclickOnFindSearckKey);
	}
		
		
		
		
	//TO FIND ANY SPECIFIC USERS FROM THE LIST AND CLICK ON THE VIEW DETAILS ACTION BUTTON
	public void searchAndViewUsersDetails() throws Throwable {
		m_up = callMeBeforePerformAnyAction();
		m_up.findUsersAndViewUsersDetails(searchKeyuserNameOrEmail,regionName,location,searchKeyColumnIndex, wantToClickOnUser,listActionIndex,wantToclickOnFindSearckKey);
	}	
	
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_UsersPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOnTabUsers();
		Thread.sleep(5000);
		//TO USERS PAGE OBJECTS
		return new PO_Main_UsersPage(driver);	
	}
	
	
}
