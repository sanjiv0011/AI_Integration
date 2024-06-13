package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_PromoCodesPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_PromoCodes extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_PromoCodes() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//m_hp = MAIN HOME PAGE
	public PO_Main_PromoCodesPage m_pc; //m_pp = MAIN PAYMENT PAGE
	
	//VARIABLES TO ADD PROMO CODE
	String  promoCodeStartDate = "17 October 2023";
	String promoCodeEndDate = "30 October 2023";;
	String promoCodeName = "WESTWOOKPROMOCODE_6";
	String searchKey = "WESTWOOKPROMOCODE_6";
	String discountTypes = "percent"; //dollar
	String discountValue = "5";
	String locationName = "WESTWOOD";
	String maxNumberOfUsers = "10";
	boolean wantToAllowForAllLocations = false;
	boolean wantToAllowForAllUsers = false;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = true;
	boolean wantToClickOnThreeDot = true;
	
	
	
	//ADD AND UPDATE PROMO CODE
	//@Test(priority = 1)
	public void test_Main_AddORChangePromocode() throws Throwable {
		m_pc = callMeBeforePerformAnyAction();
		m_pc.addOrChangePromoCodes(promoCodeName,discountTypes,discountValue, promoCodeStartDate,promoCodeEndDate,wantToAllowForAllLocations,wantToAllowForAllUsers,locationName,maxNumberOfUsers) ;
	}
	
	//DEACTIVATE PROMOCODE
	@Test(priority = 2)
	public void test_Main_DeActivatePromocode() throws Throwable {
		test_Main_FindPromoCodeFromListAndClickOnThreeDotButton();
		m_pc.deactivatePromoCode();
		}
		
		
		
	//ACTIVATE PROMOCODE
	@Test(priority = 3)
	public void test_Main_ActivatePromocode() throws Throwable {
		test_Main_FindPromoCodeFromListAndClickOnThreeDotButton();
		m_pc.activatePromoCode();
	}
	
	
		
		
	
	//TO FIND PAYMENT AND CLICK ON THREE DOT BUTTON
	//@Test(priority = 10)
	public void test_Main_FindPromoCodeFromListAndClickOnThreeDotButton() throws InterruptedException {
		m_pc = callMeBeforePerformAnyAction();
		m_pc.findPromoCodesFromListAndClickOnThreeDotButton(searchKey,promoCodeName,wantToClickOnThreeDot,searchKeyColumnIndex, wantToClickOnSearchKey);
	}
		
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_PromoCodesPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabPromoCodes();
		Thread.sleep(5000);
		return new PO_Main_PromoCodesPage(driver);	
	}
	
}
