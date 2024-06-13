package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_PaymentsPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Payments extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Payments() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//m_hp = MAIN HOME PAGE
	public PO_Main_PaymentsPage m_pp; //m_mp = MAIN MOVEMENT PAGE
	
	//VARIABLES TO ADD PAYEMNTS
	String  paymentStartDate = "1 January 2023";
	String paymentEndDate = "15 October 2023";;
	String locationName = "WESTWOOD";
	String paymentName = "AB 12";
	String searchKey = "ab12@yopmail.com";
	boolean wantToClickOnThreeDot = false;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = true;
	
	
	//TO FIND PAYMENTS USES DETAILS
	@Test(priority = 1)
	public void test_Main_CheckPaymentUserDetails() throws Throwable {
		m_pp = callMeBeforePerformAnyAction();
		m_pp.checkPaymentUserDetails(locationName,paymentStartDate, paymentEndDate, searchKey,paymentName,wantToClickOnThreeDot,searchKeyColumnIndex, wantToClickOnSearchKey);
	}
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_PaymentsPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabPayments();
		Thread.sleep(5000);
		return new PO_Main_PaymentsPage(driver);	
	}
	
}
