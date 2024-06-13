package com.leonardoAI.Main.testCases;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.Main.pageObject.PO_Main_HomePage;
import com.leonardoAI.Main.pageObject.PO_Main_TrailsPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.testCases.BaseClass;

public class TC_Main_Trials extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Trials() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;	//lp = LOGIN PAGE
	public PO_HomePage hp;	//hp = HOME PAGE
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;	//m_hp = MAIN HOME PAGE
	public PO_Main_TrailsPage m_tp;
	
	//VARIABLES TO ADD TEMPALTE
	String number = randomStringNumber(1,2);
	String temlateTypes = "Email"; //SMS;
	String templateLocation = "WESTWOOD";
	String templateTitle = "Westwood"+number;
	String templateDescription = faker.lorem().paragraph();
	boolean wantToEnableGlobal = true;
	String templateEmailSubject = faker.book().title();
	String templateEmailDescription = faker.lorem().paragraph();
	
	//TO FIND TEMPLATE FROM THE LIST
	String templateName = "Westwood3";
	int searchKeyColumnIndex = 1;
	boolean wantToClickOnThreeDot = true;
	boolean wantToclickOnFindSearckKey = false;
	
	//TO TEMPLATE
	//@Test(priority = 1)
	public void test_Main_AddTemplate() throws InterruptedException {
		m_tp = callMeBeforePerformAnyAction();
		m_hp = m_tp.addTemplate(temlateTypes, templateTitle, templateDescription, wantToEnableGlobal, templateLocation, templateEmailSubject, templateEmailDescription);
	}
	
	//TO UPADATE TEMPLATE
	@Test(priority = 6)
	public void test_Main_UpdatedTemplate() throws InterruptedException {
		test_Main_FindTempalteFromListAndClickOnThreedotButton();
		m_hp = m_tp.changeTemplate(temlateTypes, templateTitle, templateDescription, wantToEnableGlobal, templateLocation, templateEmailSubject, templateEmailDescription);
	}
	
	//TO DEACTIVATE TEMPLATE
	//@Test(priority = 2)
	public void test_Main_DeActivateTemplate() throws InterruptedException {
		test_Main_FindTempalteFromListAndClickOnThreedotButton();
		m_tp.deActivateTemplate();
	}
	
	//TO ACTIVATE TEMPLATE
	//@Test(priority = 3)
	public void test_Main_ActivateTemplate() throws InterruptedException {
		test_Main_FindTempalteFromListAndClickOnThreedotButton();
		m_tp.activateTemplate();
	}
		
		
	//TO ARCHIVE TEMPLATE
	//@Test(priority = 4)
	public void test_Main_ArchiveTemplate() throws InterruptedException {
		test_Main_FindTempalteFromListAndClickOnThreedotButton();
		m_tp.archiveTemplate();
	}

	//TO RESTORE TEMPLATE
	//@Test(priority = 5)
	public void test_Main_RestoreTemplate() throws InterruptedException {
		test_Main_FindTempalteFromListAndClickOnThreedotButton();
		m_tp.restoreTemplate();
	}
			
		
	//TO FIND TEMPLATE AND CLICK ON THE THREE DOT BUTTON
	//@Test(priority = 10)
	public void test_Main_FindTempalteFromListAndClickOnThreedotButton() throws InterruptedException {
		m_tp = callMeBeforePerformAnyAction();
		m_tp.findTemplateAndClickOnThreeDot(templateName,searchKeyColumnIndex,wantToClickOnThreeDot,wantToclickOnFindSearckKey,templateLocation);
	}
			
			
	//CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_Main_TrailsPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		m_hp = new PO_Main_HomePage(driver);
		m_hp.clickOntabDashboard();
		m_hp.clickOntabTrials();
		Thread.sleep(5000);
		return new PO_Main_TrailsPage(driver);	
	}
	
}
