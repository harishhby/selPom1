package com.unisys.pom.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.unisys.pom.base.BasePage;
import com.unisys.pom.pages.session.LandingPage;
import com.unisys.pom.util.Constants;

public class LoginPage extends BasePage {

	@FindBy(xpath=Constants.LOGIN_USERNAME)
	public WebElement un;

	@FindBy(xpath=Constants.LOGIN_PASSWORD)
	public WebElement pwd;
	
	
	public LoginPage(WebDriver driver,ExtentTest test)
	{
		super(driver,test);
	}

	public Object doLogin(String Un,String Pwd)
	{
		//login

		test.log(LogStatus.INFO, "Logging in "+Un+"/"+Pwd);
		un.sendKeys(Un);
		pwd.sendKeys(Pwd);
		pwd.sendKeys(Keys.ENTER);

		//boolean loginsuccess=false;
		boolean loginSuccess=isElementPresent(Constants.PROFILEPAGE_LINK);
		if(loginSuccess)	
		{
			test.log(LogStatus.INFO, "Login Success");
			LandingPage landingPage=new LandingPage(driver, test);
			PageFactory.initElements(driver, landingPage);
			return landingPage;
		}
		else
		{
			test.log(LogStatus.INFO, "Login Unsuccessfull");
			LoginPage loginPage=new LoginPage(driver, test);
			PageFactory.initElements(driver, loginPage);
			return loginPage;
		}
	}

}
