package com.leonardoAI.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.leonardoAI.pageObject.PO_CustomersPage;
import com.leonardoAI.pageObject.PO_HomePage;
import com.leonardoAI.pageObject.PO_LoginPage;
import com.leonardoAI.pageObject.PO_TenantsPage;

public class TC_AssumeRole extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_AssumeRole() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_LoginPage lp; // lp = LOGIN PAGE
	public PO_HomePage hp; // hp = HOME PAGE
	public Faker faker = new Faker();
	public PO_CustomersPage cp;
	public PO_TenantsPage tp;

	// TO ACCESS CUSTOMERS PAGE OBJECTS
	public PO_CustomersPage customerPageAccess() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver);
		hp.clickOnMenuDashboard();
		hp.clickOnMenuCustomer();
		Thread.sleep(4000);
		return new PO_CustomersPage(driver);
	}

	// TO VIEW SPECIFIC CUSTOMERS
	//@Test(priority = 1)
	public void viewCustomers(String customerName, String searchKey, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToClickOnSearchKey, String tenantName) throws Throwable {
		cp = customerPageAccess();
		logger.info("driver handle: " + Thread.currentThread().getName());
		test_FindDataFromListAndClickOnThreeDotButton(customerName, searchKey, searchKeyColumnIndex, wantToClickOnThreeDot,  wantToClickOnSearchKey, tenantName);
		tp = cp.viewCustomerAndTenantPageOjbect();
	}

	

	// TO ASSUME A ROLE AS TENANTS
	//@Test(dependsOnMethods = "test_ViewCustomers")
	public void assumeRoleAsTenant(String tenantName, String searchKey, int searchKeyColumnIndex, boolean wantToClickOnThreeDot,boolean wantToClickOnSearchKey) throws Throwable {
		int rowListcount = tp.findTenantFromRowListAndClickOnThreeDot(tenantName, searchKey, searchKeyColumnIndex,
				false, false);
		tp.assumeRoleAsTenant(tenantName, rowListcount, 5,  true, driver);
	}
	
	
	
	//TO FIND FROM THE LIST AND CLICK ON THE THREE DOT ACTION BUTTON
	public void test_FindDataFromListAndClickOnThreeDotButton(String customerName, String searchKey, int searchKeyColumnIndex, boolean wantToClickOnThreeDot, boolean wantToClickOnSearchKey, String tenantName ) throws Throwable {
		// logger.info("1");
		StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTraceElement[2].getMethodName();
		
		if (callerMethodName.equals("viewCustomers")) {
			// logger.info("6: "+cp);
			cp.findCustomerFromRowListAndClickOnThreeDot(customerName, searchKey, searchKeyColumnIndex,
					wantToClickOnThreeDot, wantToClickOnSearchKey);
			// logger.info("7");
		} else {
			// logger.info("8");
			tp.findTenantFromRowListAndClickOnThreeDot(tenantName, searchKey, searchKeyColumnIndex,
					wantToClickOnThreeDot, wantToClickOnSearchKey);
		}

	}

}
