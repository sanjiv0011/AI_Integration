package com.leonardoAI.pageObject.pageLocators;

public class PL_LoginPage {

	public static final String addressBtnLaunchApp = "(//a[@title='Launch App'])[2]";
	public static final String addressFieldEmail = "(//input[@id='email'])[1]";
	public static final String addressFieldPassword = "(//input[@id='password'])[1]";
	public static final String addressBtnSumbit = "//button[normalize-space()='Sign in']";
	public static final String addressTabDashboard = "(//div[contains(@class,\\\"MuiList-root\\\")][contains(.,'Dashboard')])[2]";
	public static final String addressBtnCloseModel = "(//button[starts-with(@aria-label,'Close')])[2]";
	public static final String addressTextGettingStarted = "//h1[contains(@class,'chakra-heading')]";
	public static final String addresslogoLeonardoAI =  "(//img[@alt='Leonardo.Ai'])[2]";
	
}
