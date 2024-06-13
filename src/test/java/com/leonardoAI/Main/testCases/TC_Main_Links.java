package com.leonardoAI.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_LinksPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Links extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_Main_Links() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_LoginPage lp; // lp = LOGIN PAGE
	public PO_HomePage hp; // hp = HOME PAGE
	public Faker faker = new Faker();
	public PO_Main_HomePage m_hp; // m_hp = MAIN HOME PAGE
	public PO_Main_LinksPage m_linkPage; // MAIN LINK PAGE

	// VARIABLES TO ADD PAYEMNTS
	String linkName =  "ChichaWatni";
	String locationName = "CHICAGO";
	String searchKey = linkName;
	boolean wantToCopayCalendarLink = true;
	int searchKeyColumnIndex = 1;
	boolean wantToCopyQuickRegistrationLink = true;

	//TO COPY THE LINK
	@Test(priority = 1)
	public void test_Main_AddDocuments() throws Throwable {
		m_linkPage = callMeBeforePerformAnyAction();
		m_linkPage.copyLinks(locationName, searchKey, wantToCopayCalendarLink,
				wantToCopyQuickRegistrationLink, searchKeyColumnIndex);
	}

	// CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_LinksPage callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabLinks();
		Thread.sleep(5000);
		return new PO_Main_LinksPage(driver);
	}

}
