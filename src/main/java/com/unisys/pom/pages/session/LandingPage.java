package com.unisys.pom.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.unisys.pom.base.BasePage;

public class LandingPage extends BasePage{
	
	public LandingPage(WebDriver driver,ExtentTest test)
	{
		super(driver,test);
	}
	
	public ProfilePage gotoProfilePage()
	{
		//code to go to profile page
		
		//ProfilePage profilepage=new ProfilePage();
		//return profilepage;
		test.log(LogStatus.INFO, "Going to Profile Page");
		ProfilePage profPage=new ProfilePage(driver,test);
		PageFactory.initElements(driver, profPage);
		return profPage;
		
	}

}
