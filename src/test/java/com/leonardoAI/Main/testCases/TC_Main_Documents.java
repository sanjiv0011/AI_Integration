package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_DocumentsPage;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Documents extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_Main_Documents() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_LoginPage lp; // lp = LOGIN PAGE
	public PO_HomePage hp; // hp = HOME PAGE
	public Faker faker = new Faker();
	public PO_Main_HomePage m_hp; // m_hp = MAIN HOME PAGE
	public PO_Main_DocumentsPage m_dp; // MAIN DOCUMENTS PAGE

	// VARIABLES TO ADD PAYEMNTS
	String documentName =  "WESTWOOD_DOCUMENT_"+faker.name().firstName();// "WESTWOOD_BRADY";
	String documentDescritpion = faker.lorem().paragraph();
	String documentLink = "https://www.google.com";
	String locationName = "WESTWOOD";
	String  selectRadioBtnDocumentLinkOrUploadImage = "documentLink"; //uploadImage
	String searchKey = documentName; //"WESTWOOD_BRADY";
	boolean wantToClickOnThreeDot = true;
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnSearchKey = false;

	// TO ADD DOCUMENTS
	@Test(priority = 1)
	public void test_Main_AddDocuments() throws Throwable {
		m_dp = callMeBeforePerformAnyAction();
		m_dp.addOrChangeDocuments(documentName,documentDescritpion,documentLink, locationName, selectRadioBtnDocumentLinkOrUploadImage,searchKey, searchKeyColumnIndex, wantToClickOnThreeDot, wantToClickOnSearchKey);
	}

	// TO CHANGE DOCUMENTS
	@Test(priority = 2)
	public void test_Main_ChangeDocuments() throws Throwable {
		m_dp = callMeBeforePerformAnyAction();
		m_dp.addOrChangeDocuments(documentName,documentDescritpion,documentLink,locationName, selectRadioBtnDocumentLinkOrUploadImage,searchKey, searchKeyColumnIndex, wantToClickOnThreeDot, wantToClickOnSearchKey);
	}

	// TO DEACTIVATE DOCUMENTS
	@Test(priority = 3)
	public void test_Main_DeactivateDocuments() throws Throwable {
		test_Main_FindUserLabelFromListAndClickOnThreeDotButton();
		m_dp.deactivateDocument();
	}

	// TO ACTIVATE DOCUMENTS
	@Test(priority = 4)
	public void test_Main_ActivateDocuments() throws Throwable {
		test_Main_FindUserLabelFromListAndClickOnThreeDotButton();
		m_dp.activateDocument();
	}

	
	
	// TO FIND THE DOCUMENTS FROM THE LIST AND CLICK ON THE THREE DOT ACTION BUTTON
	//@Test(priority = 10)
	public void test_Main_FindUserLabelFromListAndClickOnThreeDotButton() throws Throwable {
		m_dp = callMeBeforePerformAnyAction();
		m_dp.findDocumentsFromRowListAndClickOnThreeDot(documentName, searchKey, searchKeyColumnIndex,
				wantToClickOnThreeDot, wantToClickOnSearchKey);
	}

	// CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_DocumentsPage callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabDocuments();
		Thread.sleep(5000);
		return new PO_Main_DocumentsPage(driver);
	}

}
