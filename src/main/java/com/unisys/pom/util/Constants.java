package com.unisys.pom.util;

import java.util.Hashtable;

public class Constants {
	public static final boolean GRID_RUN = true;

	//Paths
	public static final String CHROME_DRIVER_EXE=System.getProperty("user.dir")+"/drivers/chromedriver.exe";	
	public static final String FIREFOX_DRIVER_EXE=System.getProperty("user.dir")+"/drivers/geckodriver.exe";



	//Locators
	public static final String LOGIN_USERNAME = "//*[@id='email']";
	public static final String LOGIN_PASSWORD = "//*[@id='pass']";
	public static final String PROFILEPAGE_LINK = "//span[contains(text(),'Selenium Hari')]";


	// URLs-prod
	public static final String PROD_HOMEPAGE_URL = "http://facebook.com";
	public static final String PROD_USERNAME = "Test";
	public static final String PROD_PASSWORD = "Test";

	// URLs-uat
	public static final String UAT_HOMEPAGE_URL = "http://uat.facebook.com";
	public static final String UAT_USERNAME = "uat.test";
	public static final String UAT_PASSWORD = "uat_test";

	//Environment
	public static final String ENV="PROD"; //PROD, UAT,SAT 

	//Path
	public static final String REPORTS_PATH = System.getProperty("user.dir")+"/Report/";
	public static final String DATA_XLS_PATH = System.getProperty("user.dir")+"/data/Data.xlsx";
	public static final String TESTDATA_SHEET = "TestData";
	public static final String TESTCASES_SHEET = "TestCases";


	public static final String RUNMODE_COL = "Runmode";

	public static Hashtable<String,String> table;

	public static Hashtable<String,String> getEnvDetails(){
		if(table==null){
			table = new Hashtable<String,String>();
			if(ENV.equals("PROD")){
				table.put("url", PROD_HOMEPAGE_URL);
				table.put("username", PROD_USERNAME);
				table.put("password", PROD_PASSWORD);
			}else if(ENV.equals("UAT")){
				table.put("url", UAT_HOMEPAGE_URL);
				table.put("username", UAT_USERNAME);
				table.put("password", UAT_PASSWORD);
			}
		}
		return table;
	}
}
