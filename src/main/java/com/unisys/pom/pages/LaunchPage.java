package com.unisys.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.unisys.pom.base.BasePage;
import com.unisys.pom.util.Constants;

public class LaunchPage extends BasePage {	
	

	public LaunchPage(WebDriver driver,ExtentTest test)
	{
		super(driver,test);
	}

	public LoginPage gotoLoginPage()
	{
		test.log(LogStatus.INFO, "Go to URL "+Constants.getEnvDetails().get("url"));
		driver.get(Constants.getEnvDetails().get("url"));
		LoginPage loginPage=new LoginPage(driver,test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}

}
