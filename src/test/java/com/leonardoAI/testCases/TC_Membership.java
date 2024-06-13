package com.leonardoAI.testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.leonardoAI.ReUseAble.PageObject.ReUseAbleElement;
import com.leonardoAI.dataProviders.from_readDataFromExcelFile.DataProviders;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.pageObject.PO_MembershipPage;

public class TC_Membership extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Membership() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;
	public PO_HomePage hp;
	public Faker faker  = new Faker();
	public PO_MembershipPage mp;
	public ReUseAbleElement ruae;
	public SoftAssert softAssert = new SoftAssert();
	
	String categoryName = "All";
	String packageName = "Package2";
	String radioButton = "The end of the current period";
	
	//PASS THE ALL THE DATE IN THE GIVEN FORMAT
	String membershipDate = "15 September 2023";
	String pauseStartDate = "18 September 2023";
	String pauseEndDate = "25 September 2023";
	String pauseReason = "Travel"; //"Other" and "Medical Reason"

	//TO CHANGE MEMBERSHIP
	@Test(priority = 1 , dataProvider = "TC_ChangeMembership")
	public void test_ChangeMembership(String categoryName,String packageName,String radioButton,String membershipDate) throws Throwable {
		mp = callMeBeforePerformAnyAction();
		hp = mp.changeMembership(userEmail,categoryName,packageName,radioButton, membershipDate);
	}
	
	//TO CHECK AGREED TERMS OF MEMBERSHIP
	@Test(priority = 2)
	public void test_CheckAgreedTerms() throws InterruptedException {
		mp = callMeBeforePerformAnyAction();
		hp = mp.checkAgreedTerm();
	}
	
	
	//TO PAUSE MEMBERSHIP
	@Test(priority = 3 , dataProvider = "TC_PauseMembership")
	public void test_PauseMembership(String pauseStartDate, String pauseEndDate, String pauseReason) throws Throwable {
		mp = callMeBeforePerformAnyAction();
		hp = mp.pasueMembership(userEmail,pauseStartDate, pauseEndDate, pauseReason);
	}
	
	//TO RESUME MEMBERSHIP
	@Test(priority = 4 )
	public void test_ResumeMembership() throws InterruptedException, SQLException {
		mp = callMeBeforePerformAnyAction();
		hp = mp.resumeMembership(userEmail);
	}
			
	//CALL ME IN EVERY @TEST METHODS EXCEPT
	public PO_MembershipPage callMeBeforePerformAnyAction() throws InterruptedException {
		//TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver);	//LOGIN DONE FROM THE BASE CLASS THAT'S WHY IT IS NECCESARY TO CATCH THE DRIVER AND PAGE OBJECTS
		hp.clickMenuDashBoard_RU(); //MOVE THE DRIVER ON THE HOME PAGE
		hp.clickMenuMembership();	//MOVE THE DRIVER ON THE MEMBERSHIP PAGE
		Thread.sleep(2000);			//DRIVER WAIT FOR 2 SECONDS
		return new PO_MembershipPage(driver);	//TO MEMBERSHIP PAGE OBJECTS
		
	}
	
	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly_ChangeMembership = "TC_ChangeMembership";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	public DataProviders dp_ChangeMembership =  new DataProviders();
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly_ChangeMembership)
  	public String[][] dataProvider_ChangeMemebership() throws IOException {
  		String data[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_ChangeMembership);
  		return data;
  	}
  	
  	//EXCEL FILE NAME ONLY(EXCEL FILE MUST PRESENT ONLY EXCELDATA FOLDER THEN ONLY IT IS ACCESS IT)
  	public final String fileNameOnly_PauseMembership = "TC_PauseMembership";
  	//CONSTRUCTOR DECLARATIONS TO ACCESS THE DATA PROVIDER METHODs
  	public DataProviders dp_PauseMembership =  new DataProviders();
  	//DATA PROVIDER
  	@DataProvider(name = fileNameOnly_PauseMembership)
  	public String[][] dataProvider_PauseMembership() throws IOException {
  		String data[][] = DataProviders.dataProviderGetDataFromExcelFile(fileNameOnly_PauseMembership);
  		return data;
  	}
	
}
