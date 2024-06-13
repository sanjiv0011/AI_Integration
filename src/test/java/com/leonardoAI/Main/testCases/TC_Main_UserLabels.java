package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_UserLablesPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_UserLabels extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_Main_UserLabels() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_LoginPage lp; // lp = LOGIN PAGE
	public PO_HomePage hp; // hp = HOME PAGE
	public Faker faker = new Faker();
	public PO_Main_HomePage m_hp; // m_hp = MAIN HOME PAGE
	public PO_Main_UserLablesPage m_ulp; // MAIN USER LABLES PAGE

	// VARIABLES TO ADD PAYEMNTS
	String userLabelsName = "WESTWOOD_BRADY"; // "WESTWOOD_"+faker.name().firstName();
	String searchKey = "WESTWOOD_BRADY";
	boolean wantToClickOnThreeDot = true;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = false;

	// TO ADD USER LABELS
	// @Test(priority = 1)
	public void test_Main_AddUserLabels() throws Throwable {
		m_ulp = callMeBeforePerformAnyAction();
		m_ulp.addOrChangeUserLabels(userLabelsName, searchKey, searchKeyColumnIndex, wantToClickOnThreeDot,
				wantToClickOnSearchKey);
	}

	// TO CHANGE USER LABELS
	// @Test(priority = 2)
	public void test_Main_ChangeUserLabels() throws Throwable {
		m_ulp = callMeBeforePerformAnyAction();
		m_ulp.addOrChangeUserLabels(userLabelsName, searchKey, searchKeyColumnIndex, wantToClickOnThreeDot,
				wantToClickOnSearchKey);
	}

	// TO DEACTIVATE USER LABELS
	@Test(priority = 3)
	public void test_Main_DeactivateUserLabels() throws Throwable {
		test_Main_FindUserLabelFromListAndClickOnThreeDotButton();
		m_ulp.deactivateUserLabels();
	}

	// TO ACTIVATE USER LABELS
	@Test(priority = 4)
	public void test_Main_ActivateUserLabels() throws Throwable {
		test_Main_FindUserLabelFromListAndClickOnThreeDotButton();
		m_ulp.activateUserLabels();
	}

	// TO ARCHIVE USER LABELS
	@Test(priority = 5)
	public void test_Main_ArchiveUserLabels() throws Throwable {
		test_Main_FindUserLabelFromListAndClickOnThreeDotButton();
		m_ulp.archiveUserLabels();
	}

	// TO RESTORE USER LABELS
	@Test(priority = 6)
	public void test_Main_RestoreUserLabels() throws Throwable {
		test_Main_FindUserLabelFromListAndClickOnThreeDotButton();
		m_ulp.restoreUserLabels();
	}

	
	// TO FIND THE USER LABELS FROM THE LIST AND CLICK ON THE THREE DOT ACTION BUTTON
	//@Test(priority = 10)
	public void test_Main_FindUserLabelFromListAndClickOnThreeDotButton() throws Throwable {
		m_ulp = callMeBeforePerformAnyAction();
		m_ulp.findUserLabelsFromRowListAndClickOnThreeDot(userLabelsName, searchKey, searchKeyColumnIndex,
				wantToClickOnThreeDot, wantToClickOnSearchKey);
	}

	// CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_UserLablesPage callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabUserLabels();
		Thread.sleep(5000);
		return new PO_Main_UserLablesPage(driver);
	}

}
