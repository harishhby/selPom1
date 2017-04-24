package com.unisys.pom.pages.common;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TopMenu {
	WebDriver driver;
	ExtentTest test;

	public TopMenu(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
	}

	public void logOut()
	{

	}

	public void gotoSttings()
	{
		test.log(LogStatus.INFO, "Going to Setings");

	}

	public void search()
	{

	}
}
